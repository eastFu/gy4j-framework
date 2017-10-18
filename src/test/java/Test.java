import cn.gyyx.test.UserService;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/17 15:04
 */
public class Test {

    ApplicationContext app =null;

    @Before
    public  void init(){
        app =new ClassPathXmlApplicationContext(new String[] { "classpath:springContext-dataSource.xml"});
    }

    @org.junit.Test
    public void test(){
        UserService service=app.getBean(UserService.class);
        service.query();
    }

}
