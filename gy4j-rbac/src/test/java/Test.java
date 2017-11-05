/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/30 16:24
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * test
 * @author
 * @create 2017-10-30 16:24
 **/
public class Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ApplicationContext spring = new ClassPathXmlApplicationContext(new String[] {"spring.xml","srping-mvc.xml"});
//        LOGGER.info("sdfsdf");
    }
}
