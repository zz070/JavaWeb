package frank;
import org.junit.Test;

import java.io.InputStream;

public class ClassLoaderTest {
    @Test
    public void t1(){
        //通过class获取资源或IO流：以当前class编译类的路径作为相对路径
        InputStream is = this.getClass().getResourceAsStream("../Test.txt");
        System.out.println(is);
        //通过classLoader获取资源或IO流:以整个项目变编译的根路径作为相对位置的
        //项目通过相对路径获取资源文件时，一般使用ClassLoader获取，不使用file和class获取
        InputStream is2 = this.getClass().getClassLoader().getResourceAsStream("Test.txt");
        System.out.println(is2);
    }
}
