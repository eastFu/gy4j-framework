package cn.gyyx.framework.mybatis.toolkit;

import com.alibaba.druid.sql.PagerUtils;

public class DruidUtils {

    /**
     * 通过Druid方式获取count语句
     *
     * @param originalSql
     * @param dialectType
     * @return
     */
    public static String count(String originalSql, String dialectType) {
        return PagerUtils.count(originalSql, dialectType);
    }

}
