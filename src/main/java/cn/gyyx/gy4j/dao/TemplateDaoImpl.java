package cn.gyyx.gy4j.dao;

import cn.gyyx.gy4j.util.ReflectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/14 15:02
 */
public abstract class TemplateDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK>{

    protected Class<T> entityClass;

    public TemplateDaoImpl(){
        this.entityClass= ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public void save(final T entity){

    }

    public void delete(final T entity){

    }

    public void delete(final PK id){

    }

    public T get(final PK id){

        return null;
    }

    public List<T> getAll(){

        return null;
    }

}
