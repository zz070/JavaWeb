package lesson4;

public class SynchronizedTest {
    private Object o = new Object();
    private static Object T =SynchronizedDemo.class;
    public static synchronized void test1() throws InterruptedException {
        Thread.sleep(99999999);
    }
    public synchronized void test2() throws InterruptedException {
        Thread.sleep(99999999);
    }
    public void test3() throws InterruptedException {
        synchronized (o){
            Thread.sleep(99999999);
        }
    }
    public void test4() throws InterruptedException {
        synchronized (T){
            Thread.sleep(99999999);
        }
    }
}
