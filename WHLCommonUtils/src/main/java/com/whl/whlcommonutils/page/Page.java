package com.whl.whlcommonutils.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装类：分页信息
 * @author wuhailong
 * @version 0.0.1
 * @createTime：2019-4-13
 * @updateTime：2019-4-13
 */
public class Page {
    
    private int totalCount;                //总条数
    private int totalPage;                 //总页数
    private int showPage;                  //当前显示页
    private int countOfOnePage = 5;        //每页显示条数
    private int countAllPage = 10;            //显示页码数
    
    /**
     * 获取要显示的所有页码
     * @return
     */
    public List<Integer> getAllPage(){
        List<Integer> pages = new ArrayList<>();
        int num = 0;
        for(int i= showPage - countAllPage/2  - 1; i <= totalPage; i++){
            if(i > 0 && num < countAllPage){
                pages.add(i);
                num++;
            }
        }
        return pages; 
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getShowPage() {
        return showPage;
    }

    public void setShowPage(int showPage) {
        this.showPage = showPage;
    }

    public int getCountOfOnePage() {
        return countOfOnePage;
    }

    public void setCountOfOnePage(int countOfOnePage) {
        this.countOfOnePage = countOfOnePage;
    }

    public int getCountAllPage() {
        return countAllPage;
    }

    public void setCountAllPage(int countAllPage) {
        this.countAllPage = countAllPage;
    }
    
    
}
