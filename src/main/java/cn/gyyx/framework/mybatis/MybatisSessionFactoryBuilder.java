package cn.gyyx.framework.mybatis;

import cn.gyyx.framework.mybatis.entity.GlobalConfiguration;
import cn.gyyx.framework.mybatis.toolkit.IOUtils;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class MybatisSessionFactoryBuilder extends SqlSessionFactoryBuilder {

    private GlobalConfiguration globalConfig = GlobalConfiguration.defaults();

    @Override
    public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
        try {
            MybatisXMLConfigBuilder parser = new MybatisXMLConfigBuilder(reader, environment, properties);
            GlobalConfiguration.setGlobalConfig(parser.getConfiguration(), this.globalConfig);
            return build(parser.parse());
        } catch (Exception e) {
            throw ExceptionFactory.wrapException("Error building SqlSession.", e);
        } finally {
            ErrorContext.instance().reset();
            IOUtils.closeQuietly(reader);
        }
    }

    @Override
    public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
        try {
            MybatisXMLConfigBuilder parser = new MybatisXMLConfigBuilder(inputStream, environment, properties);
            GlobalConfiguration.setGlobalConfig(parser.getConfiguration(), this.globalConfig);
            return build(parser.parse());
        } catch (Exception e) {
            throw ExceptionFactory.wrapException("Error building SqlSession.", e);
        } finally {
            ErrorContext.instance().reset();
            IOUtils.closeQuietly(inputStream);
        }
    }

    // TODO 注入全局配置
    public void setGlobalConfig(GlobalConfiguration globalConfig) {
        this.globalConfig = globalConfig;
    }

}
