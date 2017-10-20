package cn.gyyx.framework.generator.config.rules;

import cn.gyyx.framework.generator.config.ConstVal;
import cn.gyyx.framework.generator.utils.StringUtils;

public enum NamingStrategy {
    /**
     * 不做任何改变，原样输出
     */
    nochange,
    /**
     * 下划线转驼峰命名
     */
    underline_to_camel;

    public static String underlineToCamel(String name) {
        // 快速检查
        if (StringUtils.isEmpty(name)) {
            // 没必要转换
            return "";
        }
        String tempName = name;
        StringBuilder result = new StringBuilder();
        // 大写数字下划线组成转为小写
        if (StringUtils.isCapitalMode(name)) {
            tempName = name.toLowerCase();
        }
        // 用下划线将原始字符串分割
        String camels[] = tempName.split(ConstVal.UNDERLINE);
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (StringUtils.isEmpty(camel)) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel);
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(capitalFirst(camel));
            }
        }
        return result.toString();
    }

    /**
     * 去掉下划线前缀
     *
     * @param name
     * @return
     */
    public static String removePrefix(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        int idx = name.indexOf(ConstVal.UNDERLINE);
        if (idx == -1) {
            return name;
        }
        return name.substring(idx + 1);
    }

    /**
     * 去掉指定的前缀
     *
     * @param name
     * @param prefix
     * @return
     */
    public static String removePrefix(String name, String[] prefix) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        if (null != prefix) {
            for (String pf : prefix) {
                if (name.toLowerCase().matches("^" + pf.toLowerCase() + ".*")) {
                    // 判断是否有匹配的前缀，然后截取前缀
                    // 删除前缀
                    return name.substring(pf.length());
                }
            }
        }
        return name;
    }

    /**
     * 去掉下划线前缀且将后半部分转成驼峰格式
     *
     * @param name
     * @param tablePrefix
     * @return
     */
    public static String removePrefixAndCamel(String name, String[] tablePrefix) {
        return underlineToCamel(removePrefix(name, tablePrefix));
    }

    /**
     * 实体首字母大写
     *
     * @param name 待转换的字符串
     * @return 转换后的字符串
     */
    public static String capitalFirst(String name) {
        if (StringUtils.isNotEmpty(name)) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return "";
    }

}
