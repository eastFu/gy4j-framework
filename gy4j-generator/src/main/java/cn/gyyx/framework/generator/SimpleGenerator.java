package cn.gyyx.framework.generator;

import cn.gyyx.framework.generator.config.*;
import cn.gyyx.framework.generator.config.converts.MySqlTypeConvert;
import cn.gyyx.framework.generator.config.po.TableInfo;
import cn.gyyx.framework.generator.config.rules.DbColumnType;
import cn.gyyx.framework.generator.config.rules.DbType;
import cn.gyyx.framework.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/20 16:49
 */
public class SimpleGenerator extends AutoGenerator{

    // 数据源配置
    private void initDataSourceConfig(String userName,String pwd,String url){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(userName);
        dsc.setPassword(pwd);
        dsc.setUrl(url);
        setDataSource(dsc);
    }

    private void initPackageConfig(String moduleName){
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.gyyx");
        pc.setModuleName(moduleName);
        setPackageInfo(pc);
    }

    private void initMapperXml(){
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 自定义 mapper.xml 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        setCfg(cfg);
    }

    public void initBasicConfig(String moduleName,String userName,String pwd,String url){
        initPackageConfig(moduleName);
        initDataSourceConfig(userName,pwd,url);
        initMapperXml();
    }

    private void initStrategyCofig(){
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        setStrategy(strategy);
    }

    public void run(String outPath,String author){
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outPath);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(author);
        setGlobalConfig(gc);
        //BasicConfigurator.configure();
        initStrategyCofig();
        execute();
    }
}
