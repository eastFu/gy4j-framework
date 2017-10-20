package cn.gyyx.framework.mybatis.mapper;

import cn.gyyx.framework.mybatis.entity.GlobalConfiguration;
import cn.gyyx.framework.mybatis.plugins.Page;
import cn.gyyx.framework.mybatis.toolkit.CollectionUtils;
import cn.gyyx.framework.mybatis.entity.TableInfo;
import cn.gyyx.framework.mybatis.exceptions.MybatisPlusException;
import cn.gyyx.framework.mybatis.toolkit.TableInfoHelper;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SqlHelper {

    private static final Log logger = LogFactory.getLog(SqlHelper.class);

    /**
     * 获取Session 默认自动提交
     * <p>
     * 特别说明:这里获取SqlSession时这里虽然设置了自动提交但是如果事务托管了的话 是不起作用的 切记!!
     * <p/>
     *
     * @return SqlSession
     */
    public static SqlSession sqlSession(Class<?> clazz) {
        return sqlSession(clazz, true);
    }

    /**
     * <p>
     * 批量操作 SqlSession
     * </p>
     *
     * @param clazz 实体类
     * @return SqlSession
     */
    public static SqlSession sqlSessionBatch(Class<?> clazz) {
        return GlobalConfiguration.currentSessionFactory(clazz).openSession(ExecutorType.BATCH);
    }

    /**
     * 获取sqlSessionå
     *
     * @param clazz
     * @return
     */
    private static SqlSession getSqlSession(Class<?> clazz) {
        SqlSession session = null;
        try {
            SqlSessionFactory sqlSessionFactory = GlobalConfiguration.currentSessionFactory(clazz);
            Configuration configuration = sqlSessionFactory.getConfiguration();
            session = GlobalConfiguration.getGlobalConfig(configuration).getSqlSession();
        } catch (Exception e) {
            // ignored
        }
        return session;
    }

    /**
     * <p>
     * 获取Session
     * </p>
     *
     * @param clazz      实体类
     * @param autoCommit true自动提交false则相反
     * @return SqlSession
     */
    public static SqlSession sqlSession(Class<?> clazz, boolean autoCommit) {
        SqlSession sqlSession = getSqlSession(clazz);
        return (sqlSession != null) ? sqlSession : GlobalConfiguration.currentSessionFactory(clazz).openSession(autoCommit);
    }

    /**
     * 获取TableInfo
     *
     * @return TableInfo
     */
    public static TableInfo table(Class<?> clazz) {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(clazz);
        if (null == tableInfo) {
            throw new MybatisPlusException("Error: Cannot execute table Method, ClassGenricType not found .");
        }
        return tableInfo;
    }

    /**
     * <p>
     * 判断数据库操作是否成功
     * </p>
     *
     * @param result 数据库操作返回影响条数
     * @return boolean
     */
    public static boolean retBool(Integer result) {
        return null != result && result >= 1;
    }

    /**
     * <p>
     * 返回SelectCount执行结果
     * </p>
     *
     * @param result
     * @return int
     */
    public static int retCount(Integer result) {
        return (null == result) ? 0 : result;
    }

    /**
     * <p>
     * 从list中取第一条数据返回对应List中泛型的单个结果
     * </p>
     *
     * @param list
     * @param <E>
     * @return
     */
    public static <E> E getObject(List<E> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                logger.warn(String.format("Warn: execute Method There are  %s results.", size));
            }
            return list.get(0);
        }
        return null;
    }

    /**
     * 填充Wrapper
     *
     * @param page
     * @param wrapper
     */
    public static void fillWrapper(Page<?> page, Wrapper<?> wrapper) {
        if (null == page) {
            return;
        }
        if (isNotEmptyOfWrapper(wrapper)) {
            if (page.isOpenSort()) {
                wrapper.orderBy(page.getOrderByField(), page.isAsc());
            }
            wrapper.allEq(page.getCondition());
        }
    }

    /**
     * 判断Wrapper为空
     *
     * @param wrapper
     * @return
     */
    public static boolean isEmptyOfWrapper(Wrapper<?> wrapper) {
        return null == wrapper || Condition.EMPTY.equals(wrapper);
    }

    /**
     * 判断Wrapper不为空
     *
     * @param wrapper
     * @return
     */
    public static boolean isNotEmptyOfWrapper(Wrapper<?> wrapper) {
        return !isEmptyOfWrapper(wrapper);
    }
}