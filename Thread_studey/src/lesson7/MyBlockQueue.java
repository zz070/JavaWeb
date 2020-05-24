package lesson7;
/*
    阻塞式队列
    （1）基于有数组实现的循环队列
    （2）提供一个队列：
            --- 取元素消费时，若队列为空，阻塞等待
            --- 存元素生产时，若队列满了，阻塞等待
     */
public class MyBlockQueue<E> {
    private Object[] table;
    private int putIndex;//存放元素的索引位置
    private int takeIndex;//取元素的索引位置
    private int size;//队列中的元素个数

    public MyBlockQueue(int capacity){
        table = new Object[capacity];
    }
    public synchronized void put(E element) throws InterruptedException {
        while(size == table.length){
            wait();
        }
        table[putIndex] = element;
        putIndex = (putIndex+1)%table.length;
        size++;
        notifyAll();
    }
    public synchronized E take() throws InterruptedException {
        while(size == 0){
            wait();
        }
        Object take = table[takeIndex];
        takeIndex =  (takeIndex+1)%table.length;
        takeIndex--;
        notifyAll();
        return (E)take;
    }

    //模拟使用自定义队列
    /*
    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue();
        for(int i = 0;i<5;i++){
            new Thread(()->{
                //模拟生产面包
                queue.put("面包");
            }).start();
        }
        for(int i = 0;i<20;i++){
            new Thread(()->{
                //模拟消费面包
                queue.take("面包");
            }).start();
        }
    }
    */

}
