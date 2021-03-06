package cn.gyyx.framework.mybatis.plugins.pagination;

import cn.gyyx.framework.mybatis.enums.DBType;
import cn.gyyx.framework.mybatis.exceptions.MybatisPlusException;
import cn.gyyx.framework.mybatis.plugins.pagination.dialects.*;
import cn.gyyx.framework.mybatis.toolkit.StringUtils;
import org.apache.ibatis.session.RowBounds;

public class DialectFactory {

    /**
     * <p>
     * 生成翻页执行 SQL
     * </p>
     *
     * @param page
     *            翻页对象
     * @param buildSql
     *            执行 SQL
     * @param dialectType
     *            方言类型
     * @param dialectClazz
     *            自定义方言实现类
     * @return
     * @throws Exception
     */
    public static String buildPaginationSql(Pagination page, String buildSql, String dialectType, String dialectClazz)
            throws Exception {
        // fix #172, 196
        return getiDialect(dialectType, dialectClazz).buildPaginationSql(buildSql, page.getOffsetCurrent(), page.getSize());
    }

    /**
     * Physical Pagination Interceptor for all the queries with parameter
     * {@link org.apache.ibatis.session.RowBounds}
     *
     * @param rowBounds
     * @param buildSql
     * @param dialectType
     * @param dialectClazz
     * @return
     * @throws Exception
     */
    public static String buildPaginationSql(RowBounds rowBounds, String buildSql, String dialectType, String dialectClazz)
            throws Exception {
        // fix #196
        return getiDialect(dialectType, dialectClazz).buildPaginationSql(buildSql, rowBounds.getOffset(), rowBounds.getLimit());
    }

    /**
     * <p>
     * 获取数据库方言
     * </p>
     *
     * @param dialectType
     *            方言类型
     * @param dialectClazz
     *            自定义方言实现类
     * @return
     * @throws Exception
     */
    private static IDialect getiDialect(String dialectType, String dialectClazz) throws Exception {
        IDialect dialect = null;
        if (StringUtils.isNotEmpty(dialectType)) {
            dialect = getDialectByDbtype(dialectType);
        } else {
            if (StringUtils.isNotEmpty(dialectClazz)) {
                try {
                    Class<?> clazz = Class.forName(dialectClazz);
                    if (IDialect.class.isAssignableFrom(clazz)) {
                        dialect = (IDialect) clazz.newInstance();
                    }
                } catch (ClassNotFoundException e) {
                    throw new MybatisPlusException("Class :" + dialectClazz + " is not found");
                }
            }
        }
        /* 未配置方言则抛出异常 */
        if (dialect == null) {
            throw new MybatisPlusException("The value of the dialect property in mybatis configuration.xml is not defined.");
        }
        return dialect;
    }

    /**
     * <p>
     * 根据数据库类型选择不同分页方言
     * </p>
     *
     * @param dbType
     *            数据库类型
     * @return
     * @throws Exception
     */
    private static IDialect getDialectByDbtype(String dbType) {
        IDialect dialect;
        switch (DBType.getDBType(dbType)) {
            case MYSQL:
                dialect = MySqlDialect.INSTANCE;
                break;
            case ORACLE:
                dialect = OracleDialect.INSTANCE;
                break;
            case DB2:
                dialect = DB2Dialect.INSTANCE;
                break;
            case H2:
                dialect = H2Dialect.INSTANCE;
                break;
            case SQLSERVER:
                dialect = SQLServerDialect.INSTANCE;
                break;
            case SQLSERVER2005:
                dialect = SQLServer2005Dialect.INSTANCE;
                break;
            case POSTGRE:
                dialect = PostgreDialect.INSTANCE;
                break;
            case HSQL:
                dialect = HSQLDialect.INSTANCE;
                break;
            case SQLITE:
                dialect = SQLiteDialect.INSTANCE;
                break;
            default:
                throw new MybatisPlusException("The Database's Not Supported! DBType:" + dbType);
        }
        return dialect;
    }

}