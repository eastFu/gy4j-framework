package cn.gyyx.framework.mybatis.plugins.pagination.dialects;

import cn.gyyx.framework.mybatis.plugins.pagination.IDialect;

public class PostgreDialect implements IDialect {

    public static final PostgreDialect INSTANCE = new PostgreDialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" limit ").append(limit).append(" offset ").append(offset);
        return sql.toString();
    }
}
