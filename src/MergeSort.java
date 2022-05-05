import java.util.ArrayList;

public class MergeSort {
    ArrayList<Waypoint> input;
    WaypointComparator wayCo;

    public MergeSort(ArrayList<Waypoint> input, WaypointComparator wc) {
        this.input = input;
        wayCo = wc;
    }

    public void mergeSort(ArrayList<Waypoint> in){
        int debug = 0;
        if(in.size()<2){
            return;
        }
        int middle = in.size()/2;
        ArrayList<Waypoint> left = new ArrayList<Waypoint>();
        ArrayList<Waypoint> right = new ArrayList<Waypoint>();
        for(Waypoint w: in){
            if(in.indexOf(w) < middle)
                left.add(w);
            else
                right.add(w);
        }
        //System.out.println(left.size());
        //System.out.println(right.size());
        mergeSort(left);
        System.out.println("debug"+debug);
        mergeSort(right);
        merge(left,right,wayCo);

    }

    public void merge(ArrayList<Waypoint> left, ArrayList<Waypoint> right, WaypointComparator wc){
        int leftSize= left.size();
        int rightSize = right.size();
        int i = 0, j= 0, k=0;
        while(i<leftSize && j< rightSize){
            if (wc.compare(left.get(i),right.get(j))<0){
                input.set(k,left.get(i));
                i++;
            }
            else{
                input.set(k,right.get(k));
                j++;
            }
            k++;
        }
        while(i<leftSize){
            input.set(k,left.get(i));
            i++;
            k++;
        }
        while(j<rightSize){
            input.set(k, left.get(j));
            j++;
            k++;
        }

    }

    public void printDatabase() {
        for (Waypoint w : input)
            System.out.println(w);
    }

    public static void main(String[] args) {


    }
}


