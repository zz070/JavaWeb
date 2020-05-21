package lesson5;

public class SingtonRun {

    public static void main(String[] args) {
        new Thread(()->{
            Sington.getInstance();
        }).start();
        Sington.getInstance();
    }
}
