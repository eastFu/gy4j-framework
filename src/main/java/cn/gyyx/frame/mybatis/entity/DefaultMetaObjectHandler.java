package com.gyyx.core.mybatis.entity;

import org.apache.ibatis.reflection.MetaObject;

import com.gyyx.core.mybatis.mapper.MetaObjectHandler;

public class DefaultMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }

    @Override
    public boolean openInsertFill() {
        return false;
    }

    @Override
    public boolean openUpdateFill() {
        return false;
    }

}
