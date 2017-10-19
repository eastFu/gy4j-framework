package com.gyyx.core.mybatis.generator;

import com.gyyx.core.mybatis.generator.config.DataSourceConfig;
import com.gyyx.core.mybatis.generator.config.GlobalConfig;
import com.gyyx.core.mybatis.generator.config.PackageConfig;
import com.gyyx.core.mybatis.generator.config.StrategyConfig;
import com.gyyx.core.mybatis.generator.config.TemplateConfig;
import com.gyyx.core.mybatis.generator.config.builder.ConfigBuilder;

public abstract class AbstractGenerator {

    protected ConfigBuilder config;
    protected InjectionConfig injectionConfig;
    /**
     * 数据源配置
     */
    private DataSourceConfig dataSource;
    /**
     * 数据库表配置
     */
    private StrategyConfig strategy;
    /**
     * 包 相关配置
     */
    private PackageConfig packageInfo;
    /**
     * 模板 相关配置
     */
    private TemplateConfig template;
    /**
     * 全局 相关配置
     */
    private GlobalConfig globalConfig;

    /**
     * 初始化配置
     */
    protected void initConfig() {
        if (null == config) {
            config = new ConfigBuilder(packageInfo, dataSource, strategy, template, globalConfig);
            if (null != injectionConfig) {
                injectionConfig.setConfig(config);
            }
        }
    }

    public DataSourceConfig getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSourceConfig dataSource) {
        this.dataSource = dataSource;
    }

    public StrategyConfig getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyConfig strategy) {
        this.strategy = strategy;
    }

    public PackageConfig getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageConfig packageInfo) {
        this.packageInfo = packageInfo;
    }

    public TemplateConfig getTemplate() {
        return template;
    }

    public void setTemplate(TemplateConfig template) {
        this.template = template;
    }

    public ConfigBuilder getConfig() {
        return config;
    }

    public void setConfig(ConfigBuilder config) {
        this.config = config;
    }

    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

    public void setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    public InjectionConfig getCfg() {
        return injectionConfig;
    }

    public void setCfg(InjectionConfig injectionConfig) {
        this.injectionConfig = injectionConfig;
    }

}
