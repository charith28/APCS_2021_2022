import java.util.ArrayList;

/**
 * @version April 29 2022
 * @author 23fernando
 * A MergeSort algorithm wiht n Log (n) efficiency that sorts ArrayLists of Waypoints using the perviously defined WayPoint comparator.
 */
public class MergeSort {
    ArrayList<Waypoint> input;
    WaypointComparator wayCo;
    ArrayList<Waypoint> output = new ArrayList<>();

    /**
     * parameterized constructor for a MergeSort object which defines the input ArrayList and WayPoint comparator
     * @param in
     * @param wc
     */
    public MergeSort(ArrayList<Waypoint> in, WaypointComparator wc) {
        input = in;
        wayCo = wc;
    }

    /**
     * Splits the input list in half until it is one element. Then uses the merge method to put the list back together in a sorted manner.
     * @param in - input ArrayList
     */
    public void mergeSort(ArrayList<Waypoint> in){
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

        mergeSort(left);
        mergeSort(right);
        merge(in,left,right);


    }

    /**
     * Merging algorithm for MergeSort. Compares the contents of two lists and adds them to a combined Arraylist based on the desired order.
     * @param in- input ArrayList
     * @param left - left half to merge
     * @param right - right hald to merge
     */
    public void merge(ArrayList<Waypoint> in, ArrayList<Waypoint> left, ArrayList<Waypoint> right){
        int leftSize= left.size();
        int rightSize = right.size();
        int l = 0, r= 0, k=0;
        while(l<leftSize && r< rightSize){
            if (wayCo.compare(left.get(l),right.get(r)) < 0){
                in.set(k++,left.get(l++));
            }
            else{
                in.set(k++,right.get(r++));
            }
        }
        while(l<leftSize){
            in.set(k++, left.get(l++));
        }
        while(r<rightSize){
            in.set(k++, right.get(r++));
        }
    }

}


