package wang.utils.page;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/12.
 */
public class Page implements Serializable{
    private static final long serialVersionUID = 1L;

    //当前页数
    private int pageNum;
    //每页显示的条数
    private int pageSize;
    //开始索引
    private int startRow;
    //结束索引
    private int endRow;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //分页数据
    private com.github.pagehelper.Page records;

    public Page() {
    }

    public Page(com.github.pagehelper.Page page) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.startRow = page.getStartRow();
        this.endRow = page.getEndRow();
        this.records = page;
    }

    public com.github.pagehelper.Page getRecords() {
        return records;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public long getTotal() {
        this.total = records.getTotal();
        return total;
    }

    public int getPages() {
        this.pages = records.getPages();
        return pages;
    }

}
