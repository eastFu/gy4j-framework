package cn.gyyx.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/15 21:16
 */
public class StringUtil extends StringUtils{

    /**
     * 将给定的字符串按照给定的分隔符分割成一个数组
     * @param     strToSplit 要处理的字符串
     * @param     separator 分隔符
     * @return    分解后形成的数组
     */
    public static String[] splitString2Array(String strToSplit, String separator)
    {
        if(strToSplit == null || strToSplit.length() == 0) {
            return null;
        }
        if(separator == null || separator.length() == 0) {
            return null;
        }
        if (strToSplit.startsWith(separator))  //如果是以分隔符打头，则将打头的分隔符去掉
        {
            strToSplit = strToSplit.substring(separator.length());
        }
        int count = 0;
        int index = 0;
        int lastIndex = strToSplit.lastIndexOf(separator);
        if (lastIndex + separator.length() < strToSplit.length())   //如果不是以分割符结尾则补一个
        {
            strToSplit += separator;
        }
        for(int pos = 0; (pos = strToSplit.indexOf(separator, index)) > 0;)
        {
            count++;
            index = pos + separator.length();
        }

        if(count == 0) {
            return (new String[]{strToSplit});
        }
        String retStrArray[] = new String[count];
        index = 0;
        int pos;
        for(int i = 0; (pos = strToSplit.indexOf(separator, index)) > 0; i++)
        {
            retStrArray[i] = strToSplit.substring(index, pos);
            index = pos + separator.length();
        }
        return retStrArray;
    }
}
