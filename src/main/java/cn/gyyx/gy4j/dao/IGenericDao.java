package cn.gyyx.gy4j.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/13 17:23
 */
public interface IGenericDao<T,PK> {

    @Select("MapperGD.find.entityById")
    public T findEntityById(PK id);

    @Select("MapperGD.find.entitys")
    public List<T> findEntity(Object... obj);

    @Select("MapperGD.find.ListByLike")
    public List<T> findLikeEntity(Object... obj);

    @Insert("MapperGD.insert.entity")
    public void insertEntity(T t);

    @Update("MapperGD.update.entity")
    public void updateEntityById(T entity);

    @Delete("MapperGD.delete.id")
    public void deleteById(PK id);

    @Delete("MapperGD.delete.condition")
    public void deleteByCondition(Object param);

    @Select("MapperGD.find.entity.queryByVo")
    public PageMyBatis<T> queryByVo(int i,int c,Object... obj);

    @Select("MapperGD.find.entity.queryByVoLike")
    public PageMyBatis<T> LikequeryByVo(int i,int c,Object... obj);

}
