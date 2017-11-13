import cn.gyyx.framework.generator.SimpleGenerator;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/20 14:45
 */
public class GeneratorTest {

    public static void main(String[] args) {
        String moduleName="test";
        String userName="root";
        String pwd="root";
        String url="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8";
        String author="east";
        String outPath="E://test";

        SimpleGenerator generator=new SimpleGenerator(moduleName,userName,pwd,url,outPath,author);
        generator.run();
    }
}
