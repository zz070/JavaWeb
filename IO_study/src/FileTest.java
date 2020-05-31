import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    @Test
    public void t1(){
        //文件的相对路径（./当前目录；../上一级目录）
        // 绝对路径（全路径）
        //java在idea中的编译路径
        //全路径
        File file = new File("D:\\software\\IDEA\\IntelliJ IDEA 2020.1\\Project\\JavaWeb\\IO_study\\Data\\Test.txt");
        System.out.println(file.exists());
        File f2 = new File("../Data/Test.txt");
        System.out.println(f2.exists());
        File f3 = new File("Data/Test.txt");//项目里最好还是使用全路径
        System.out.println(f3.exists());//文件是否存在
        System.out.println(f3.getPath());//获取路径
        //查看文件路径
        File f4 = new File(".");
        System.out.println(f4.getAbsolutePath());//获取全路径
        System.out.println(f4.lastModified());//上次修改时间
    }
    @Test
    public void t2(){
        File f5 = new File("D:\\software\\IDEA\\IntelliJ IDEA 2020.1\\Project\\JavaWeb\\Thread_study");
        File[] children = f5.listFiles();//返回目录下一级的子文件/子文件夹数组
        for(File child : children)
            System.out.println(child.getName());//文件名
    }

    //递归获取目录下所有的子文件和子文件夹
    public static List<File> list(File f){
        List<File> files = new ArrayList<>();
        if(f.isFile())
            files.add(f);
        else{
            //下一级子文件、子文件夹
            File[] children = f.listFiles();
            for(File child : children){
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;
    }

    @Test
    public void t3(){
        File f5 = new File("D:\\software\\IDEA\\IntelliJ IDEA 2020.1\\Project\\JavaWeb");
        List<File> children = list(f5);//返回目录下一级的子文件/子文件夹数组
        for(File child : children)
            System.out.println(child.getName());//文件名
    }
}
