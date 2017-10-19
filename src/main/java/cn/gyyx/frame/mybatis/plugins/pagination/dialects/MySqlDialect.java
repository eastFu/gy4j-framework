package cn.gyyx.frame.mybatis.plugins.pagination.dialects;

import cn.gyyx.frame.mybatis.plugins.pagination.IDialect;

public class MySqlDialect implements IDialect {

    public static final MySqlDialect INSTANCE = new MySqlDialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" LIMIT ").append(offset).append(",").append(limit);
        return sql.toString();
    }
}
