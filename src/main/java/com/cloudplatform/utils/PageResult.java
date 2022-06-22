package com.cloudplatform.utils;

import java.util.List;

/**
 * 分页结果类
 */
public class PageResult<T> {

    private Long total;//总记录数
    private List<T> rows;//记录
    private int pagenum;
    private int pagesize;

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    private int totalpage;

    public PageResult(Long total,int pagenum,int pagesize,List<T> rows) {
        this.total = total;
        this.rows = rows;
        this.pagesize=pagesize;
        this.pagenum=pagenum;
        this.totalpage= (int) ((total-1)/pagesize+1);
    }

    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
