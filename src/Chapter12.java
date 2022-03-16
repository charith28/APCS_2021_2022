import java.util.ArrayList;

public class Chapter12 {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cow("bovine", true, 4,"female", "Jersey"));
        animals.add(new Chicken("avian", true, 2, "male", "Bantam"));
        animals.add(new Pig("porcine", true, 4, "female", "Hampshire"));
        animals.add(new Chicken("avian", false, 2, "male", "Leghorn"));
        for (Animal a:animals) {
            System.out.println();

        }
    }

}
