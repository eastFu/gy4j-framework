package cn.gyyx.gy4j.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public interface BaseMapper<T> {

    List<T> select(T record);

    int selectCount(T record);

    T selectByPrimaryKey(Object key);

    int insert(T record);

    int insertSelective(T record);

    int delete(T key);

    int deleteByPrimaryKey(Object key);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

}
