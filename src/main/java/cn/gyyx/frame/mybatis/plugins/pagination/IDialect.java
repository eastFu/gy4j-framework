package com.gyyx.core.mybatis.plugins.pagination;

public interface IDialect {

    /**
     * 组装分页语句
     *
     * @param originalSql
     *            原始语句
     * @param offset
     *            偏移量
     * @param limit
     *            界限
     * @return 分页语句
     */
    String buildPaginationSql(String originalSql, int offset, int limit);
}
