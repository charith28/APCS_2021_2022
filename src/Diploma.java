public class Diploma {
    private String name, degree;
    public Diploma(String n, String d){
        name = n;
        degree = d;
    }

    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public String toString(){
        return "This certifies that " + name+ " has earned a degree in " + degree;
    }
}
