package com.gyyx.core.mybatis.generator.config.rules;

public enum DbType {

    MYSQL("mysql"), ORACLE("oracle"), SQL_SERVER("sql_server"), POSTGRE_SQL("postgre_sql");

    private final String value;

    DbType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
