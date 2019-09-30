package com.whl.whlcommonutils.page;

/**
 * 工具类：分页信息
 * @author wuhailong
 */
public class PageTool {
    
    /**
     * 查询分页信息模板方法
     * @param countOfOnePage  每页条数
     * @param showPage  当前显示页
     * @param qi 操作查询总条数的策略实现
     * @return Page
     */
    public static Page getPage(int countOfOnePage, int showPage, GetTotalCountStrategy qi){
        //Page
        Page page = new Page();
        
        //每页条数
        page.setCountOfOnePage(countOfOnePage);
        
        //查询总条数
        int totalCount = qi.queryTotalCount();
        
        //设置总条数
        page.setTotalCount(totalCount);
        
        //设置总页数
        int totalPage = (int) Math.ceil(totalCount /(double) countOfOnePage);
        page.setTotalPage(totalPage);
        
        //设置当前页数
        if(showPage > 0 && showPage <= totalPage){
            page.setShowPage(showPage);
        }else{
            page.setShowPage(1);
        }
        
        return page;
    }
    
    /**
     * 根据总条数设置分页
     * @param page  分页信息
     * @param totalCount  总条数
     * @return Page
     */
    public static Page getPage(Page page, int totalCount){
        
        
        //设置总条数
        page.setTotalCount(totalCount);
        
        //设置总页数
        int totalPage = (int) Math.ceil(totalCount /(double) page.getCountOfOnePage());
        page.setTotalPage(totalPage);
        
        return page;
    }
}
