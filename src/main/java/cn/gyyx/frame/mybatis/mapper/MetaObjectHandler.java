package cn.gyyx.frame.mybatis.mapper;

import org.apache.ibatis.reflection.MetaObject;

public abstract class MetaObjectHandler {

    /**
     * <p>
     * 插入元对象字段填充
     * </p>
     *
     * @param metaObject 元对象
     */
    public abstract void insertFill(MetaObject metaObject);

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     * Created with IntelliJ IDEA.
     * Author:  Wu Yujie
     * Email:  coffee377@dingtalk.com
     * Time:  2017/04/16 15:03
     *
     * @param metaObject 元对象
     */
    public abstract void updateFill(MetaObject metaObject);

    /**
     * 开启插入填充
     */
    public boolean openInsertFill() {
        return true;
    }

    /**
     * 开启更新填充
     */
    public boolean openUpdateFill() {
        return true;
    }

}
