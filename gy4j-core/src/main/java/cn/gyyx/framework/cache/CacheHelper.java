package cn.gyyx.framework.cache;


import org.apache.log4j.Logger;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/6 21:34
 */
public class CacheHelper {

    private static final Logger LOG = Logger.getLogger(CacheHelper.class);

    public Object findByKey(Object key){
        return  null;
    }

    public boolean save(Object obj){
        return true;
    }

    public boolean remove(Object key){
        return true;
    }

    public boolean clear(){
        return true;
    }
}
