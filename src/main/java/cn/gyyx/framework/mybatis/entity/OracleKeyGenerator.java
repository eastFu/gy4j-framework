package cn.gyyx.frame.mybatis.entity;

import cn.gyyx.frame.mybatis.mapper.IKeyGenerator;

public class OracleKeyGenerator implements IKeyGenerator {

    @Override
    public String executeSql(TableInfo tableInfo) {
        return String.format("SELECT %s.NEXTVAL FROM DUAL", tableInfo.getKeySequence().value());
    }

}
