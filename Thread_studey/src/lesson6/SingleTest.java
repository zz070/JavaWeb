package lesson6;

public class SingleTest {
    /**
     * 假设面包店有面包师傅生产面包，消费者买面包
     * 1、面包师傅有五个，可以一直生产面包，一次上产3个
     * 2、消费者有20个，可以一直消费，一次买一个
     * 3、面包店库存的上限 100 个，下限  0 个
     */
    private static int SUM; //库存

    public static void main(String[] args) {
        //5个面包师傅,同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SingleTest.class){
                            if(SUM+3>100){
                                SingleTest.class.wait();
                            }else{
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName()+"生产面包,库存"+SUM);
                                SingleTest.class.notify();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"面包师傅【"+i+"】").start();
        }
        //20个消费者，同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SingleTest.class){
                            if(SUM <= 0){
                                SingleTest.class.wait();
                            }else{
                                SUM --;
                                System.out.println(Thread.currentThread().getName()+"消费面包,库存"+SUM);
                                SingleTest.class.notify();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"消费者【"+i+"】").start();
        }
    }
}
