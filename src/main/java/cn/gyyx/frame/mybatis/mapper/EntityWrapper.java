package com.gyyx.core.mybatis.mapper;

import com.gyyx.core.mybatis.toolkit.ReflectionKit;
import com.gyyx.core.mybatis.toolkit.StringUtils;

@SuppressWarnings("serial")
public class EntityWrapper<T> extends Wrapper<T> {

    /**
     * 数据库表映射实体类
     */
    protected T entity = null;

    public EntityWrapper() {
        /* 注意，传入查询参数 */
    }

    public EntityWrapper(T entity) {
        this.entity = entity;
    }

    public EntityWrapper(T entity, String sqlSelect) {
        this.entity = entity;
        this.sqlSelect = sqlSelect;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    /**
     * SQL 片段
     */
    @Override
    public String getSqlSegment() {
		/*
		 * 无条件
		 */
        String sqlWhere = sql.toString();
        if (StringUtils.isEmpty(sqlWhere)) {
            return null;
        }

		/*
		 * 根据当前实体判断是否需要将WHERE替换成 AND 增加实体不为空但所有属性为空的情况
		 */
        if (isWhere != null) {
            sqlWhere = isWhere ? sqlWhere : sqlWhere.replaceFirst("WHERE", AND_OR);
        } else {
            sqlWhere = ReflectionKit.checkFieldValueNotNull(entity) ? sqlWhere.replaceFirst("WHERE", AND_OR) : sqlWhere;
        }
        return sqlWhere;
    }

}