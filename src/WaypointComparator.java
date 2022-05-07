import java.util.Comparator;

/**
 * @version April 29 2022
 * @author 23fernando
 * Comparator class for waypoints
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * parameterized constructor for a waypoint comparator
     * @param c - category of comparing
     * @param a - boolean representing ascending or descending order of comparing
     */
    public WaypointComparator(int c, boolean a){
        category = c;
        asc = a;
    }

    /**
     * parameterized constructor for a waypoint comparator
     * @param c - category of comparing
     */
    public WaypointComparator(int c){
        category = c;
        asc= true;
    }

    /**
     * unparameterized constructor of the waypoint comparator
     */
    public WaypointComparator(){
        category = 4;
        asc = true;
    }

    /**
     * comparer method that takes two waypoints and returns their difference in a certain category
     * @param one - the first waypoint to be compared
     * @param two - the second waypoint to be compared
     * @return - the difference between two waypoints
     */
    public int compare(Waypoint one, Waypoint two){
        int diff = 0;
        if(category ==1){
            diff = one.getType().compareTo(two.getType());
        }
        else if(category == 2){
            diff = one.getName().compareTo(two.getName());
        }
        else if(category == 3){
            diff = one.getState().compareTo(two.getState());
        }
        else if(category == 4){
            Double d1= one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        }
        else if(category == 5){
            Double d1= one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        else if(category == 6){
            diff = one.getElevation()- two.getElevation();
        }

        return(asc)? diff: -diff;
    }
}
