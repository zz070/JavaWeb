import org.junit.Assert;
import org.junit.Test;

public class PrintWriteTest {
    @Test
    public void t1(){
        try {
            int i =  1/0;
            System.out.println("1/0");
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("t1");
    }
}
