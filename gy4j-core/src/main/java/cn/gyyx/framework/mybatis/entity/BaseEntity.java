package cn.gyyx.framework.mybatis.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/23 11:20
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
