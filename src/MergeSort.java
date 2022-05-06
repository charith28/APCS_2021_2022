import java.util.ArrayList;

public class MergeSort {
    ArrayList<Waypoint> input;
    WaypointComparator wayCo;
    ArrayList<Waypoint> output = new ArrayList<>();

    public MergeSort(ArrayList<Waypoint> in, WaypointComparator wc) {
        input = in;
        wayCo = wc;
    }

    public void mergeSort(ArrayList<Waypoint> in){
        int count = 0;

        if(in.size() == 1){
            return;
        }
        int middle = in.size()/2;
        ArrayList<Waypoint> left = new ArrayList<Waypoint>();
        ArrayList<Waypoint> right = new ArrayList<Waypoint>();
        for(int i = 0; i< middle;i++)
            left.add(in.get(i));
        for(int l = middle; l<in.size();l++){
            right.add(in.get(l));
        }
        System.out.println(count);
        System.out.println("LEFT");
        for (Waypoint w:left) {
            System.out.println(w);
        }
        System.out.println("RIGHT");
        for (Waypoint w:right) {
            System.out.println(w);
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right);

            System.out.println("Begin Iteration");
            printDatabase();
            System.out.println("End Iteration");
    }

    public void merge(ArrayList<Waypoint> left, ArrayList<Waypoint> right){
        int leftSize= left.size();
        int rightSize = right.size();
        int l = 0, r= 0, k=0;
        while(l<leftSize && r< rightSize){
            if (wayCo.compare(left.get(l),right.get(r)) < 0){ // if left is less than right
                System.out.println(left.get(l).getElevation() + " greater than " + right.get(r).getElevation());
                output.set(k++,left.get(l++));
            }
            else{
                System.out.println(left.get(l).getElevation() + " less than " + right.get(r).getElevation());
                output.set(k++,right.get(r++));
            }

        }
        while(l<leftSize){
            output.set(k++, left.get(l++));

        }
        while(r<rightSize){
            output.set(k++, right.get(r++));

        }

    }

    public void printDatabase() {
        for (Waypoint w : output)
            System.out.println(w);
    }
    public void nullArray(){
        for(Waypoint w: input){
            output.add(new Waypoint());
        }
    }

    public static void main(String[] args) {


    }
}


