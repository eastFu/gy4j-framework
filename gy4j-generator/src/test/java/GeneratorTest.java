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
        String url="jdbc:mysql://192.168.10.36:3306/db_gm?characterEncoding=utf8";
        String author="xiaoming";
        String outPath="E://TEST";

        SimpleGenerator generator=new SimpleGenerator();
        generator.initBasicConfig(moduleName,userName,pwd,url);
        generator.run(outPath,author);
    }
}
