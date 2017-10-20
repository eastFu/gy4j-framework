package cn.gyyx.framework.mybatis.mapper;


import cn.gyyx.framework.mybatis.entity.TableInfo;

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
