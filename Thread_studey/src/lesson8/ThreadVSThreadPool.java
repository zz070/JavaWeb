package lesson8;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadVSThreadPool {
    public static void main(String[] args) {

        /**
         * 1、没使用线程送快递
         * 自己送快递，在干自己的事情
         */
        System.out.println("送到上海");    //模拟送快递，可能送快递比较耗时
        System.out.println("送到重庆");
        System.out.println("处理自己的事情");

        /**
         * 2、手动创建线程，送快递
         * 雇佣两个人送快递，同时干自己的事情
         */

        new Thread(()->{
            System.out.println("送到上海");
        }).start();
        new Thread(()->{
            System.out.println("送到重庆");
        }).start();
        System.out.println("处理自己的事情");

        /**
         *3、使用JDK线程池来送快递
         */
        //创建线程池对象：开了一家快递公司，专门处理送快递的任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,    //核心线程数 -->  快递公司的员工数  -->  线程
                10, //最大线程数  --> 总员工数 = 正式工+临时工 --> 线程
                //临时工+时间表示：正式员工数量不足以处理任务时，招聘临时工，临时工超过空闲时间就解雇
                60, //空闲时间数
                TimeUnit.SECONDS, //时间单位
                new ArrayBlockingQueue<>(1000), //阻塞队列：快递公司的仓库，用于保存包裹 --> 存放线程的容器
                new ThreadFactory() {   //匿名内部类
                    @Override
                    public Thread newThread(Runnable r) {  //线程的工厂类：快递公司招聘标准 --> 创建线程的方式
                        return null;
                    }
                },
                //拒绝策略：接收到新的快递单，但此时仓库容量不够存放新的包裹
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        pool.execute(()->{
            System.out.println("送到上海");
        });
        pool.execute(()->{
            System.out.println("送到重庆");
        });
        System.out.println("处理自己的事情");
    }
}
