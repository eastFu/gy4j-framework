package com.gyyx.core.model;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public class Page<T> {

    private int totalPage = 0;//总页码
    private int totalRows = 0;//总记录数
    private int currentPage = 1;//当前页码
    private int pageSize = 10;//每页记录数
    private List<T> list = null;//数据列表
    private String sql = null;//查询语句
    private ResultSet resultSet = null;
    private static int defaultPageSize = 10;//每页默认条数

    public Page(){
    }


    public int getTotalPage() {
        this.totalPage = (int) Math.ceil(this.totalRows / this.pageSize) + (this.totalRows % this.pageSize > 0 ? 1:0);
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    /**
     * 获取当前查询总记录数
     * @return int totalRows 总记录数
     */
    public int getTotalRows() {
        return this.totalRows;
    }
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
    public int getCurrentPage() {
        return this.currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if(pageSize<=0){
            this.pageSize = this.defaultPageSize;
        }
    }
    public List getList() {
        return this.list;
    }
    public void setList(List list) {
        this.list = list;
    }
    public String getSql() {
        return this.sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
    public ResultSet getResultSet() {
        return this.resultSet;
    }
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public String toString() {
        return "Page [totalPage=" + totalPage + ", totalRows="
                + totalRows + ", currentPage=" + currentPage + ", pageSize="
                + pageSize + ", list=" + list + ", sql=" + sql + ", resultSet="
                + resultSet + "]";
    }
}
