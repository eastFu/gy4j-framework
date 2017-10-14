package cn.gyyx.gy4j.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/14 15:02
 */
public abstract class TemplateDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK>{

    protected Class<T> entityClass;

    @Autowired
    private SqlSessionTemplate sqlSession;

    @SuppressWarnings("unchecked")
    public TemplateDaoImpl(){
//        this.entityClass = ReflectHelper.getSuperClassGenericType(getClass(), 0);
        this.entityClass = null;
    }


    public SqlSession getSqlSession(){
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    public T selectSingle(Object param) {
        if(null == param){
            throw new IllegalArgumentException("非法参数：param为空！");
        }
        T result = null;
        try{
            result = getSqlSession().selectOne(entityClass.getName()+SQL_SELECT_SINGLE, param);
        }catch(Throwable e){
        }
        return result;
    }
}
