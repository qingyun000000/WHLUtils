package cn.whl.commonutils.spring.data.jpa;

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
}
