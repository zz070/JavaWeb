package lesson1;

public class Second {
    public static void main(String[] args) throws InterruptedException {

        //第一段代码：观察main线程阻塞
        Thread.sleep(999999999999999L);


        //第二段代码：观察子线程阻塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"第一个线程").start();

        //第三段代码：观察main和子线程同时阻塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"第一个线程").start();
        Thread.sleep(999999999999999L);

        //第四段代码：main线程运行run方法
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"第一个线程");
        t.run();

        //第五段代码:main()和子线程同时运行，并打印观察执行顺序
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"第一个线程").start();
        System.out.println("main");
    }
}
