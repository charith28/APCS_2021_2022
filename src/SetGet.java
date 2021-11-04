public class SetGet {
    private String name;
   private int age;

    public void setAge(int agi) {
        age = agi;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
       SetGet a = new SetGet();
       a.age = 16;
        System.out.println(a.age);
        SetGet b = new SetGet();
        System.out.println(b.age);
    }
}
