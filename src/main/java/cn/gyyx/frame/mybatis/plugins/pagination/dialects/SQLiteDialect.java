package cn.gyyx.frame.mybatis.plugins.pagination.dialects;

import cn.gyyx.frame.mybatis.plugins.pagination.IDialect;

public class SQLiteDialect implements IDialect {

    public static final SQLiteDialect INSTANCE = new SQLiteDialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" limit ").append(limit).append(" offset ").append(offset);
        return sql.toString();
    }
}
