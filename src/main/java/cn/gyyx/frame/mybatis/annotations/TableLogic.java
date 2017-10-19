package com.gyyx.core.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableLogic {

	/**
	 * <p>
	 * 默认逻辑未删除值（该值可无、会自动获取全局配置）
	 * </p>
	 */
	String value() default "";

	/**
	 * <p>
	 * 默认逻辑删除值（该值可无、会自动获取全局配置）
	 * </p>
	 */
	String delval() default "";

}
