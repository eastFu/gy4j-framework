package com.gyyx.core.dao;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/11 15:52
 */
public interface BaseDao<T,PK extends Serializable> {


    /**
     * 记录添加（所有字段入库，效率中）
     * @param po
     * @return
     */
    public int add(T po);

    /**
     * 通过主键获取某个记录
     * @param id 主键
     * @return PO
     */
    public T get(PK id);

    /**
     * 条件查询列表
     * @param wrapper 条件表达式
     * @return PO列表
     */
    public List<T> list(EntityWrapper wrapper);

}
