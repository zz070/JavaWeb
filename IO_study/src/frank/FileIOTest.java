package frank;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOTest {
    @Test
    public void t1() throws IOException {
        FileInputStream fis = null;
        try {
            //方式一：使用FileInputStream+绝对路径；方式二：使用ClassLoader+相对路径
           fis  = new FileInputStream(new File("D:\\software\\IDEA\\IntelliJ IDEA 2020.1\\Project\\JavaWeb\\IO_study\\Data\\Test.txt"));
            //abcdefg,读取操作，从当前位置偏移多少位（read，new String中的第二个参数参数），读取多长（第三个参数）
            byte[] bytes = new byte[1024];
            int len ;
            while((len = fis.read(bytes))!=-1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } finally {
            if(fis!=null){
                fis.close();
            }
        }
    }
}
