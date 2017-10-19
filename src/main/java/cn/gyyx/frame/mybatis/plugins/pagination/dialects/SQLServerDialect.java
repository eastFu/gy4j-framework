package cn.gyyx.frame.mybatis.plugins.pagination.dialects;

import cn.gyyx.frame.mybatis.plugins.pagination.IDialect;

public class SQLServerDialect implements IDialect {

    public static final SQLServerDialect INSTANCE = new SQLServerDialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" OFFSET ").append(offset).append(" ROWS FETCH NEXT ");
        sql.append(limit).append(" ROWS ONLY");
        return sql.toString();
    }
}
