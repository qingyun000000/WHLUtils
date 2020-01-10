package cn.whl.commonutils.spring.data.jpa;

import cn.whl.commonutils.page.Page;
import cn.whl.commonutils.page.PageTool;
import cn.whl.commonutils.spring.data.jpa.strategy.ConstructStrategy;
import cn.whl.commonutils.spring.data.jpa.strategy.QueryStrategy;
import cn.whl.commonutils.spring.data.jpa.strategy.ResultStrategy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 工具类——spring.data.JPA工具
 * @author wuhailong
 */
public class JPATool {
    
    /**
     * 获取Spring Data的分页
     * @param countOfOnePage  每页条数
     * @param showPage  当前页
     * @param orderByParamName  排序属性名
     * @param desc  是否倒序
     * @return Pageable
     */
    public static Pageable getPageable(int countOfOnePage, int showPage, String orderByParamName, Boolean desc){
        Sort sort;
        if(desc){
            sort = new Sort(Sort.Direction.DESC, orderByParamName);
        }else{
            sort = new Sort(Sort.Direction.ASC, orderByParamName);
        }
        return PageRequest.of(showPage-1, countOfOnePage, sort);
    }
    
    /**
     * 获取Spring Data的排序
     * @param orderByParamName  排序属性名
     * @param desc  是否倒序
     * @return Sort
     */
    public static Sort getSort(String orderByParamName, Boolean desc){
        if(desc){
            return new Sort(Sort.Direction.DESC, orderByParamName);
        }else{
            return new Sort(Sort.Direction.ASC, orderByParamName);
        }
    }
    
    /**
     * 封装的分页查询方法
     * @param <T>
     * @param <S>
     * @param <K>
     * @param resultClass
     * @param listClass
     * @param responseClass
     * @param page
     * @param qs
     * @param cs
     * @param rs
     * @return 
     */
    public static <T, S, K> K queryByPageable(Class<K> resultClass, Class<T> listClass, Class<S> responseClass, Page page,
            QueryStrategy<T> qs, ConstructStrategy<T, S> cs, ResultStrategy<S, K> rs){
        Pageable pageable = JPATool.getPageable(page.getCountOfOnePage(), page.getShowPage(), page.getOrderByParamName(), page.isDesc());

        org.springframework.data.domain.Page<T> ts = qs.query(pageable);

        page = PageTool.getPage(page, (int) ts.getTotalElements());

        List<S> responses = new ArrayList<>();

        for (T t : ts) {
            S s = cs.construct(t);

            responses.add(s);
        }
        
        return rs.getResult(page, responses);
    }
}
