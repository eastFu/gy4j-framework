package cn.gyyx.framework.cache;


/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/6 21:34
 */
public interface  CacheHelper {

    public Object findByKey(Object key);

    public boolean save(Object obj);

    public boolean remove(Object key);

    public boolean clear();
}
