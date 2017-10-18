package com.gyyx.core.mybatis.plugins.pagination.dialects;

import com.gyyx.core.mybatis.plugins.pagination.IDialect;

public class H2Dialect implements IDialect {

    public static final H2Dialect INSTANCE = new H2Dialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" limit ").append(limit);
        if (offset > 0) {
            sql.append(" offset ").append(offset);
        }
        return sql.toString();
    }
}