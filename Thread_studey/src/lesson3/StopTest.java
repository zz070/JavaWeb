package lesson3;

public class StopTest {
    private volatile static boolean IS_STOP;

    public static void main(String[] args) throws InterruptedException {
        //第一段代码：在子线程sleep阻塞的时候，中断它
        Thread t = new Thread(()->{
            try {
                while (!Thread.interrupted()){//判断当前线程是否被中断--->判断中断的标志位
                    System.out.println(Thread.currentThread().getName());
                    //sleep线程阻塞时，也可以中断，是以抛出InterruptedException来中断的
                    Thread.sleep(100000000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(2000);
        //特殊情况出现，要中断子线程
        t.interrupt();

        //第二段代码：
        //（1）线程初始时，中断标志位=false
        //（2）调用线程的interrupt()方法，该线程的中断标志位=true
        //（3）如果线程处于阻塞态，中断抛出InterruptedException时，会重置线程的中断标志位
//        Thread t = new Thread(()->{//isInterrupted=false;
//            while (!Thread.interrupted()){
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000000);
//                } catch (InterruptedException e) {
//                    //线程阻塞的时候，抛出InterruptedException中断线程，isInterrupted=false;
//                    e.printStackTrace();
//                }
//            }
//        });
//        t.start();
//        Thread.sleep(3000);
//        //特殊情况出现，要中断子线程
//        t.interrupt();//t.isInterrupted=true

        // 第三段代码：Thread.interrupted()作用
//        Thread t = new Thread(()->{//isInterrupted=true;
//            for(int i=0; i<10; i++) {
//                //Thread.interrupted()：返回当前的中断标志位，并重置标志位
//                //（1）boolean tmp = isInterrupted;
//                //（2）isInterrupted=false;
//                //（3）return tmp;
//                System.out.println(Thread.interrupted());
//            }
//        });
//        t.start();//t.isInterrupted=false;
//        //特殊情况出现，要中断子线程
//        t.interrupt();//t.isInterrupted=true

        //第四段代码：线程对象.isInterrupted()作用：只返回中断标志位，不做任何修改
//        Thread t = new Thread(()->{//isInterrupted=true;
//            for(int i=0; i<10; i++) {
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
//        });
//        t.start();//t.isInterrupted=false;
//        //特殊情况出现，要中断子线程
//        t.interrupt();//t.isInterrupted=true
    }
}
