package cn.whl.commonutils.spring.data.jpa;

import cn.whl.commonutils.page.Page;
import cn.whl.commonutils.page.PageUtils;
import cn.whl.commonutils.response.page.DataPageResponse;
import cn.whl.commonutils.spring.data.jpa.strategy.ConstructStrategy;
import cn.whl.commonutils.spring.data.jpa.strategy.QueryStrategy;
import cn.whl.commonutils.spring.data.jpa.strategy.ResultStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 工具类——spring.data.JPA工具
 * @author wuhailong
 */
public class JPAUtils {
    
//    /**
//     * 封装的查询方法
//     * @param <T>
//     * @param <K>
//     * @param resultClass
//     * @param queryClass
//     * @param qs
//     * @param rs
//     * @param poName
//     * @return 
//     * @throws cn.whl.commonutils.exception.NotExistException 
//     */
//    public static <T, K> K query(Class<K> resultClass, Class<T> queryClass,
//            QueryStrategy<T> qs, ResultStrategy<T, K> rs, String poName) throws NotExistException{
//        
//        T ts = qs.query();
//        if(ts == null){
//            throw new NotExistException(poName);
//        }
//
//        return rs.getResult(ts);
//    }
//    
//    /**
//     * 封装的查询方法, 查询值和返回值一直
//     * @param <T>
//     * @param queryClass
//     * @param qs
//     * @param poName
//     * @return 
//     * @throws cn.whl.commonutils.exception.NotExistException 
//     */
//    public static <T> T query(Class<T> queryClass, QueryStrategy<T> qs, String poName) throws NotExistException{
//        
//        return query(queryClass, queryClass, qs, (t) -> t, poName);
//    }
//    
    /**
     * 获取Spring Data的分页
     * @param page
     * @return Pageable
     */
    public static Pageable getPageable(Page page){
        return getPageable(page.getCountOfOnePage(), page.getShowPage(), page.getOrderByParamName(), page.isDesc());
    }
    
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
     * 封装的分页查询方法，基础方法
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
        Pageable pageable = JPAUtils.getPageable(page.getCountOfOnePage(), page.getShowPage(), page.getOrderByParamName(), page.isDesc());

        org.springframework.data.domain.Page<T> ts = qs.query(pageable);

        page = PageUtils.getPage(page, (int) ts.getTotalElements());

        List<S> responses = new ArrayList<>();

        for (T t : ts) {
            S s = cs.construct(t);

            responses.add(s);
        }
        
        return rs.getResult(page, responses);
    }
    
    /**
     * 封装的分页查询方法（返回值为DataPageResponse类）
     * @param <T>
     * @param <S>
     * @param listClass
     * @param responseClass
     * @param page
     * @param qs
     * @param cs
     * @return 
     */
    public static <T, S> DataPageResponse<S> queryByPageable(Class<T> listClass, Class<S> responseClass, Page page,
            QueryStrategy<T> qs, ConstructStrategy<T, S> cs){
        return queryByPageable(DataPageResponse.class, listClass, responseClass, page, qs, cs, (pg, responses)-> new DataPageResponse<>(pg, responses));
    }
    
    /**
     * 封装的分页查询方法（返回值为DataPageResponse类，其中封装返回对象为查询对象）
     * @param <T>
     * @param listClass
     * @param page
     * @param qs
     * @return 
     */
    public static <T> DataPageResponse<T> queryByPageable(Class<T> listClass, Page page, QueryStrategy<T> qs){
        return queryByPageable(DataPageResponse.class, listClass, listClass, page, qs, (t)->t, (pg, responses)-> new DataPageResponse<>(pg, responses));
    }
    
    /**
     * 封装的分页查询方法（返回值为DataPageResponse类，其中封装返回对象为查询对象）
     * @param <T>
     * @param page
     * @param qs
     * @return 
     */
    public static <T> DataPageResponse<T> queryByPageable(Page page, QueryStrategy<T> qs){
        return queryByPageable(null, null, null, page, qs, (t)->t, (pg, responses)-> new DataPageResponse<>(pg, responses));
    }
    
    /**
     * 转换分页里的泛型对象，常用于queryByPageable(Class<T> listClass, Page page, QueryStrategy<T> qs)查询后，两者组合可替代queryByPageable(Class<T> listClass, Class<S> responseClass, Page page,
            QueryStrategy<T> qs, ConstructStrategy<T, S> cs)方法
     * @param <T>
     * @param <K>
     * @param datePageResponse
     * @param cs
     * @return 
     */
    public static <T, K> DataPageResponse<K> transferClass(DataPageResponse<T> datePageResponse, ConstructStrategy<T, K> cs){
       
       List<K> responses = new ArrayList<K>(datePageResponse.getList().size());
       
       for(T t : datePageResponse.getList()){
            K result = cs.construct(t);

            responses.add(result);
        }
       
        return new DataPageResponse<>(datePageResponse.getPage(), responses);
    }
    
//    /**
//     * 转换分页里的泛型对象，常用于queryByPageable(Class<T> listClass, Page page, QueryStrategy<T> qs)查询后，两者组合可替代queryByPageable(Class<T> listClass, Class<S> responseClass, Page page,
//            QueryStrategy<T> qs, ConstructStrategy<T, S> cs)方法
//     * @param <T>
//     * @param <K>
//     * @param datePageResponse
//     * @param resonpseClass
//     * @return 
//     */
//    public static <T, K> DataPageResponse<K> transferClass(DataPageResponse<T> datePageResponse, Class<K> resonpseClass){
//       
//       List<K> responses = new ArrayList<K>(datePageResponse.getList().size());
//       
//       for(T t : datePageResponse.getList()){
//            K result = new K(t);
//
//            responses.add(result);
//        }
//       
//        return new DataPageResponse<>(datePageResponse.getPage(), responses);
//    }
    
    /**
     * list封装为分页列表对象
     * @param <T>
     * @param list
     * @param page
     * @return
     */
    public static <T> DataPageResponse<T> constructByList(List<T> list, Page page){
        page = PageUtils.getPage(page, list.size());
        
        //截取列表
        
        return new DataPageResponse<>(page, list);
    }
    
    /**
     * list封装为分页列表对象
     * @param <T>
     * @param array
     * @param page
     * @return
     */
    public static <T> DataPageResponse<T> constructByArray(T[] array, Page page){
        List<T> list = Arrays.asList(array);
        return constructByList(list, page);
    }
}
