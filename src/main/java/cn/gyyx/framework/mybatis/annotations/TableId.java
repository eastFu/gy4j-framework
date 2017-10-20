package cn.gyyx.framework.mybatis.annotations;

import cn.gyyx.framework.mybatis.enums.IdType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableId {

    /*
     * <p>
     * 字段值（驼峰命名方式，该值可无）
     * </p>
     */
    String value() default "";

    /*
     * <p>
     * 主键ID
     * </p>
     * {@link IdType}
     */
    IdType type() default IdType.NONE;

}
