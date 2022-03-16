import java.util.ArrayList;

public class Kennel {
    private ArrayList<Pet> petList;

    public Kennel(){
        petList = new ArrayList<>();

    }
    public void addPet(Pet p){
        petList.add(p);
    }

    public void allSpeak(){
        for (Pet p: petList){
            System.out.println("The " + p.getClass().toString().substring(6) + " says " + p.speak());
        }
    }

    public static void main(String[] args) {
        Kennel k = new Kennel();
        k.addPet(new Dog("Fido"));
        k.addPet(new Cat("Deuce"));
        k.addPet(new LoudDog("Hans"));
        k.allSpeak();
    }
}
