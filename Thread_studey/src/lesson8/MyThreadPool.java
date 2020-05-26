package lesson8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    private BlockingQueue<Runnable> queue;

    public MyThreadPool(int corePoolSize,int capacity){
        queue = new ArrayBlockingQueue<>(capacity);
        for(int i = 0;i<corePoolSize;i++){
            new MyThread(queue).start();
        }
    }

    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private class MyThread extends Thread{
        private BlockingQueue<Runnable> queue;

        public MyThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }
        @Override
        public void run(){
            try {
                while (true){
                    Runnable take = queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

