package lesson5;

/**
 * 单例：在某些场景下，需要获取同一个对象
 * 类加载在JVM内部执行，保证了线程间同步互斥的：
 * （1）只执行一次（2）线程安全
 */
public class SingleTest {
    //饿汉模式：在类加载的时候就创建对象
    public static SingleTest SINGLE = new SingleTest();

    public SingleTest() {}

    public static SingleTest getInstance(){
        return SINGLE;
    }

    //懒汉模式
    //存在线程安全问题
    public static SingleTest SINGLEA = null;

    public static SingleTest getInstanceA() {
        if(SINGLEA == null){
            SINGLEA = new SingleTest();
            /*
            SINGLEA = new SingleTest()可以分解为：
            （1）分配对象的内存空间
            （2）初始化对象
            （3）对象赋值给变量
            不具有原子性，可见性
             */
        }
        return SINGLEA;
    }
}
