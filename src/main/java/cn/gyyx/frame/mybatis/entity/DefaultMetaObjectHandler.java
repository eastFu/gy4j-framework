package cn.gyyx.frame.mybatis.entity;

import cn.gyyx.frame.mybatis.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

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
