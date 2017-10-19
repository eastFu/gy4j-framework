package com.gyyx.core.mybatis.annotations;

import com.gyyx.core.mybatis.enums.FieldStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableField {

    /**
     * <p>
     * 字段值（驼峰命名方式，该值可无）
     * </p>
     */
    String value() default "";

    /**
     * <p>
     * 当该Field为类对象时, 可使用#{对象.属性}来映射到数据表.
     * </p>
     * <p>
     * 支持：@TableField(el = "role, jdbcType=BIGINT)<br>
     * 支持：@TableField(el = "role, typeHandler=com.baomidou.xx.typehandler.PhoneTypeHandler")
     * </p>
     */
    String el() default "";

    /**
     * <p>
     * 是否为数据库表字段
     * </p>
     * <p>
     * 默认 true 存在，false 不存在
     * </p>
     */
    boolean exist() default true;

    /**
     * <p>
     * 字段验证
     * </p>
     * <p>
     * 默认 非 null 判断
     * </p>
     */
    FieldStrategy validate() default FieldStrategy.NOT_NULL;

}
