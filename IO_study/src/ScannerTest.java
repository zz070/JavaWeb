import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        假设要接受的数据是：
        4
        3 5 6 7
         */
        //hasNextXXX(),nextXXX()都是读到IO数据直到满足条件（空格或换行符），否则阻塞等待
        //IO流只能操作一次,hasNextXXX()不操作，只判断；nextXXX()读取一下,IO流就到下一个位置了
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int data = sc.nextInt();
                System.out.println(data);
            }
        }
    }
}
