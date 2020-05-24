package lesson7;

    /**
     *三个线程
     * 第一个只打印A，第二个只打印B，第三个只打印C
     * 要求
     * （1）同时执行
     * （2）打印结果：ABC
     * 解决：使用join();
     */
public class SequencePrint {

    private static class Print implements Runnable{
        private String content;
        private Thread t;

        public Print(String content,Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if(t != null){
                    t.join();
                }
                System.out.print(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void print1(){
        Thread t1 = new Thread(new Print("A",null));
        Thread t2 = new Thread(new Print("B",t1));
        Thread t3 = new Thread(new Print("C",t2));
        t1.start();
        t2.start();
        t3.start();
    }
    public static void main(String[] args) {
        print2();
    }
        /**
         * 升级版的要求：
         * （1）同时执行
         * （2）打印结果：ABC，循环 10 次
         * 思路：每个线程循环10次，打印ABC
         */
//        public static void print2(){
//            Thread t1 = new Thread(new Print2("A"));
//            Thread t2 = new Thread(new Print2("B"));
//            Thread t3 = new Thread(new Print2("C"));
//            t1.start();
//            t2.start();
//            t3.start();
//        }
        public static void print2(){
            for(int i=0; i<Print2.ARRAY.length; i++){
                new Thread(new Print2(i)).start();
            }
        }
        private static class Print2 implements Runnable{
//            private String content;
//            private static String[] ARRAY  ={"A","B","C"};
//            private static int INDEX;


//            public Print2(String content) {
//                this.content = content;
//            }

            private int idx;
            public static String[] ARRAY = {"A", "B", "C", "D", "E"};
            private static int INDEX;
            public Print2(int idx) {
                this.idx = idx;
            }
            @Override
            public void run() {
                try {
                    for(int i =0 ;i < 10;i++) {
                        synchronized (ARRAY) {
                            while (!ARRAY[INDEX].equals(ARRAY[idx])) {
                                ARRAY.wait();
                            }
                            System.out.print(ARRAY[idx]);
                            if(ARRAY.length-1 == INDEX){
                                System.out.println();
                            }
                            INDEX = (INDEX+1)%ARRAY.length;
                            ARRAY.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
