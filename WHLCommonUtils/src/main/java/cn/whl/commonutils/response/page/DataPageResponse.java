package cn.whl.commonutils.response.page;

import cn.whl.commonutils.page.Page;
import java.util.List;

/**
 * 分页封装数据
 * @author wuhailong
 */
public class DataPageResponse<T> {
    
    private Page page;
    
    private List<T> list;

    public DataPageResponse(Page page, List<T> list) {
        this.page = page;
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
