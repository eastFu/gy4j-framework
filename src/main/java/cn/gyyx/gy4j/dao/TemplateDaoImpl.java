package cn.gyyx.gy4j.dao;

import cn.gyyx.gy4j.util.ReflectionUtils;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/14 15:02
 */
@TableName
public abstract class TemplateDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK>,BaseMapper<T>{

    protected Class<T> entityClass;

    public TemplateDaoImpl(){
        this.entityClass= ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public void save(final T entity){
        insert(entity);
    }

    public int delete(final PK id){
        int flag = deleteById(id);
        return flag;
    }

    public T get(final PK id){
        return selectById(id);
    }

    public List<T> getAll(){
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.setEntity(entityClass);
        return selectList(wrapper);
    }

}
