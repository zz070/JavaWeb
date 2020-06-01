import java.util.ArrayList;
import java.util.List;

public class SerializableTest {

    private String name;
    private List<Food> food = new ArrayList<>();

    public static class Food{
        private String name;

        public Food(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        SerializableTest se = new SerializableTest();
        se.name = "快餐店";
        se.food.add(new Food("apple"));
        se.food.add(new Food("beef"));
        se.food.add(new Food("milk"));
    }
}
