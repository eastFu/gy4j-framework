package com.gyyx.core.mybatis.plugins.pagination.dialects;

import com.gyyx.core.mybatis.plugins.pagination.IDialect;

public class HSQLDialect implements IDialect {

    public static final HSQLDialect INSTANCE = new HSQLDialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" limit ").append(offset).append(",").append(limit);
        return sql.toString();
    }
}
