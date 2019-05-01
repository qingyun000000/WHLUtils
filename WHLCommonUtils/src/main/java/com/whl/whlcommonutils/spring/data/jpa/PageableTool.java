package com.whl.whlcommonutils.spring.data.jpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 工具类——Spring Data分页
 * @author wuhailong
 * @version 0.0.1
 * @createTime 2019-4-11
 * @updateTime 2019-4-12
 */
public class PageableTool {
    
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
        return new PageRequest(showPage-1, countOfOnePage, sort);
    }
}
