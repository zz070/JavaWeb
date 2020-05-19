package lesson4;

public class SafeThread {
    //启动20个线程，每个线程执行10000次,每次循环将共享变量+1
    private static int SUM;
    public static synchronized  void increment(int n){
        SUM++;
    }
    public static void main(String[] args) {
        for(int i = 0;i<20;i++){
            new Thread(()->{
                for(int j = 0;j<10000;j++){
                  increment(j);
                }
            }).start();
        }
        //所有线程运行完毕打印SUM
        while(Thread.activeCount()>1)//用debug运行，run的话>2
            Thread.yield();//当前线程有运行态转化为就绪态
        System.out.println(SUM);
    }
}
