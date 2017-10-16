package cn.gyyx.gy4j.dao;

import cn.gyyx.gy4j.model.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/11 15:52
 */
public interface BaseDao<T,PK extends Serializable> {

    /**
     * 保存新增或修改的对象.
     */
    public void save(final T entity);

    /**
     * 删除对象.
     *
     * @param entity 对象必须是session中的对象或含id属性的transient对象.
     */
    public void delete(final T entity);

    /**
     * 按id删除对象.
     */
    public void delete(final PK id);

    /**
     * 按id获取对象.
     */
    public T get(final PK id);

    /**
     *	获取全部对象.
     */
    public List<T> getAll();

    /**
     *	获取全部对象,支持排序.
     */
    public List<T> getAll(String orderBy, boolean isAsc);

    /**
     * 按属性查找对象列表,匹配方式为相等.
     */
    public List<T> findBy(final String propertyName, final Object value);

    /**
     * 按属性查找唯一对象,匹配方式为相等.
     */
    public T findUniqueBy(final String propertyName, final Object value);

    /**
     * 按id列表获取对象.
     */
    public List<T> findByIds(List<PK> ids);

    /**
     * 按HQL查询对象列表.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    public <X> List<X> find(final String sql, final Object... values);

    /**
     * 分页获取全部对象.
     */
    public Page<T> getAll(final Page<T> page);

}
