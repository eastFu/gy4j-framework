package cn.gyyx.framework.mybatis.entity;

public class CountOptimize {

    /**
     * 是否排序
     */
    private boolean orderBy = true;
    /**
     * 优化后计算Count的SQL
     */
    private String countSQL;

    public static CountOptimize newInstance() {
        return new CountOptimize();
    }

    public boolean isOrderBy() {
        return orderBy;
    }

    public void setOrderBy(boolean orderBy) {
        this.orderBy = orderBy;
    }

    public String getCountSQL() {
        return countSQL;
    }

    public void setCountSQL(String countSQL) {
        this.countSQL = countSQL;
    }

}
