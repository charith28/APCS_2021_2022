public class Pig extends Animal{
    private String type;
    public Pig(String s, boolean a, int l, String g, String t){
        super(s,a,l,g);
        type = t;
    }
    public String speak(){
        return "Oink Oink";
    }
}
