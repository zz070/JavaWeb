package lesson5;

public class SafeSington {
    //双重校验锁的单例模式
    public static SafeSington SAFESINGTON;
    public static SafeSington getInstance(){
        //多个线程进入代码块，按序执行
        if(SAFESINGTON == null){
            synchronized (SafeSington.class){
                //第一个进入的线程初始化对象，后序进入的直接退出
                //后续的线程并发的执行getInstance(),不会进入if代码，直接返回已实例的对象
                //效率非常高
                if(SAFESINGTON == null){
                    SAFESINGTON = new SafeSington();
                    /*
                    SAFESINGTON = new SafeSington()分解为
                    （1）分配对象的内存空间
                    （2）初始化对象
                    （3）对象赋值给变量
                     */
                }
            }
        }
        return SAFESINGTON;
    }
}
