package lesson9;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static ExecutorService FIXED_POOL = Executors.newFixedThreadPool(4);

    private static ScheduledExecutorService SCHEDULED_POOL = Executors.newScheduledThreadPool(4);

    public static void runFixedThreadPool(Runnable task){
        FIXED_POOL.execute(task);
    }

    public static void main(String[] args) {
//        runFixedThreadPool(()->{
//            System.out.println("送快递到北京");
//        });
//        runFixedThreadPool(()->{
//            System.out.println("送快递到上海");
//        });
//        System.out.println("干自己的活");

        SCHEDULED_POOL.scheduleAtFixedRate(()->{//延迟多少秒之后执行一次，再每间隔多少秒执行一次
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(d));
        }, 1, 1, TimeUnit.SECONDS);
        SCHEDULED_POOL.scheduleAtFixedRate(()->{//延迟多少秒之后执行一次，再每间隔多少秒执行一次
            System.out.println("abc");
        }, 0, 2, TimeUnit.SECONDS);
    }
}
