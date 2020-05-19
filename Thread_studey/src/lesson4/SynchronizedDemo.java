package lesson4;

//演示synchronized关键字
public class SynchronizedDemo {
    //1、静态方法：静态同步方法
    public static synchronized void test1(){

    }
    //同tset1()
    public static void test1_2(){
        synchronized (SynchronizedDemo.class){

        }
    }
    //2、实例方法：实例同步方法
    public synchronized void test2(){

    }
    //同test2()
    public synchronized void test2_2(){
        synchronized (this){

        }
    }


    public static void main(String[] args) {
        Object o = new Object();
        /**
         * 1、对象锁：每个对象都有对象头，包含锁
         * 2、synchronized是获取对象锁的操作
         *      （1）申请对象锁成功
         *              1）持有对象锁，进入代码块
         *              2）执行代码
         *              3）退出代码块，归还对象锁
         *                  --- JVM会将竞争失败的线程唤醒
         *                  --- 唤醒的线程重新竞争
         *                  --- 循环（1）和（2）的逻辑
         *      （2）申请对象锁失败：线程进入下一个同步队列阻塞
         *              1） JVM管理synchronized竞争失败
         *                  --- 由运行态转变成阻塞态的方式
         *                  --- 将线程放到一个同步队列的数据结构中
         *                  --- 对象锁再次可用，将所有竞争该对象锁失败的线程唤醒（阻塞转变为被唤醒）
         * 3、对象：普通Java对象，类对象
         * 4、注意事项：
         *      （1）只有多个线程对同一个对象申请对象锁时，才会有同步互斥现象
         *               --- 同步互斥：同步代码块，在一个时间点，只有一个线程运行
         *      （2）多个线程竞争不同对象的对象锁时，不会有同步互斥现象
         *5、静态同步方法 、实例同步方法都可以转换为同步代码块
         */

        //3、同步代码块
        synchronized (o){

        }
    }
}
