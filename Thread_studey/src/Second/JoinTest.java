package Second;

public class JoinTest {
    //先打印1到19，随机同时打印，最后打印main
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for(int i = 0;i<20;i++){
            final int j = i;
           Thread t = new Thread(()->{
                System.out.println(j);
            });
           t.start();
           threads[i] = t;
        }
        for(int i = 0;i<20;i++){
            threads[i].join();
        }
        System.out.println("main");
    }
}

