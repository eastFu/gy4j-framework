package com.gyyx.core.listener;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public class WebContextListener extends ContextLoaderListener {

    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n    欢迎使用 gy4j-framework v 0.0.1");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());

        //log4j 配置文件目录
        PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));

        //cache类型（redis,memcache,mogodb）

        //cache配置文件目录

        return super.initWebApplicationContext(servletContext);
    }

}