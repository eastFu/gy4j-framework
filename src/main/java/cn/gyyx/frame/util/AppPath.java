package cn.gyyx.frame.util;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/15 21:24
 */
public class AppPath {

    private static AppPath APP_PATH = null;
    private static String APP_ROOT_PATH;//应用部署的根路径

    public static synchronized AppPath getInstance()
    {
        if(APP_PATH == null)
        {
            APP_PATH = new AppPath();
        }

        return APP_PATH;
    }


    public String setRootPath(String rootPath)
    {
        return APP_ROOT_PATH = rootPath;
    }

    /**
     * 获取应用部署的根路径
     * @return
     */
    public String getRootPath()
    {

        return APP_ROOT_PATH;
    }

    /**
     * 获取应用部署的classes的绝对路径
     * @return
     */
    public String getAppClassesPath()
    {
        return APP_ROOT_PATH + "WEB-INF/classes/";
    }


    public String getProjectName()
    {
        String proUrl = APP_ROOT_PATH.substring(0, APP_ROOT_PATH.length()-1);
        return (proUrl.substring(proUrl.lastIndexOf("/")+1));
    }



}
