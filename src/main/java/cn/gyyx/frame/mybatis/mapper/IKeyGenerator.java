package com.gyyx.core.mybatis.mapper;


import com.gyyx.core.mybatis.entity.TableInfo;

public interface IKeyGenerator {

    /**
     * <p>
     * 执行 key 生成 SQL
     * </p>
     *
     * @param tableInfo 数据库表反射信息
     * @return
     */
    String executeSql(TableInfo tableInfo);

}
