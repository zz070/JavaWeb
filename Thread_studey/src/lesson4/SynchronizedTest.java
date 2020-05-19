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

    public static void main(String[] args) {
        //test2在不同线程中是否会同步互斥
        //情况1，不会同步互斥
        new Thread(() -> {
            try {
                new SynchronizedTest().test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new SynchronizedTest().test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //情况2，会同步互斥
        SynchronizedDemo t =new SynchronizedDemo();
        new Thread(() -> {
            t.test2();
        }).start();
        new Thread(() -> {
            t.test2();
        }).start();
    }
}
