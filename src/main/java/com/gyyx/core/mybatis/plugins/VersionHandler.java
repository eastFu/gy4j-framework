package com.gyyx.core.mybatis.plugins;

import java.lang.reflect.Field;

public interface VersionHandler<T> {

    /**
     * 根据类型,使得对象对应的字段+1
     */
    void plusVersion(Object paramObj, Field field, T versionValue) throws Exception;
}