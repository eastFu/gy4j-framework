package com.gyyx.core.mybatis.entity;

import com.gyyx.core.mybatis.mapper.IKeyGenerator;

public class OracleKeyGenerator implements IKeyGenerator {

    @Override
    public String executeSql(TableInfo tableInfo) {
        return String.format("SELECT %s.NEXTVAL FROM DUAL", tableInfo.getKeySequence().value());
    }

}
