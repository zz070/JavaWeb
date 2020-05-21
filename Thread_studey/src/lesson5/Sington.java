package lesson5;

//单例模式
public class Sington {
    //饿汉式：类加载时就创建对象
    //类加载在JVM内部执行，保证了线程间同步互斥
    //（1）只执行一次；（2）线程安全
    public static Sington SINGTON = new Sington();

    private Sington() {
    }

    public static Sington getInstance() {
        return SINGTON;
    }

    //懒汉式
    //存在多线程安全问题
    //多行代码，并且存在需要分解的代码   --->    不具有原子性，可见性
    public static Sington SINGTON2;

    //省略了构造方法
    public static Sington getInstance2() {
        if (SINGTON2 == null) {
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }


    //懒汉式多线程安全版:存在效率低的问题
    public static Sington SINGTON3;

    public synchronized static Sington getInstance3() {
        if (SINGTON3 == null) {
            SINGTON3 = new Sington();
        }
        return SINGTON3;
    }

    //懒汉模式 ---> 二次判断，性能高
    public static Sington SINGTON4;
    public synchronized static Sington getInstance4() {
        if (SINGTON4 == null) {
            synchronized (Sington.class) {
                if (SINGTON4 == null) {
                    SINGTON4 = new Sington();
                }
            }
        }
        return SINGTON4;
    }
}
