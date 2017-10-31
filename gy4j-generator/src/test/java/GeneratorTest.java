import cn.gyyx.framework.generator.SimpleGenerator;

/**
 * @Author : east.Fu
 * @Description :
 * @Date : Created in  2017/10/20 14:45
 */
public class GeneratorTest {

    public static void main(String[] args) {
        String moduleName="rbac";
        String userName="root";
        String pwd="east";
        String url="jdbc:mysql://localhost:3306/king-admin?characterEncoding=utf8";
        String author="east.Fu";
        String outPath="E://king";
        SimpleGenerator generator=new SimpleGenerator();
        generator.initBasicConfig(moduleName,userName,pwd,url);
        generator.run(outPath,author);
    }
}
