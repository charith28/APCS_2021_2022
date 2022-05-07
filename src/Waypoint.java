/**
 * @version April 29 2022
 * @author 23fernando
 * Waypoint is an object representation of each entry in the database
 */
public class Waypoint {
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * parameterized constructor of the Waypoint class
     * @param t - type of Waypoint
     * @param n - name of Waypoint
     * @param s - state of Waypoint
     * @param ts - Distance from Waypoint to Springer
     * @param tk - Distance from Waypoint to Katahdin
     * @param e - elevation of Waypoint
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e){
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    /**
     * unparameterized constructor for Waypoint
     */
    public Waypoint(){
        type = "";
        name = "";
        state = "";
        toSpringer = 0.0;
        toKatahdin = 0.0;
        elevation = 0;
    }

    /**
     * Getter method
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * Getter method
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Getter method
     * @return distance to Springer
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * Getter method
     * @return distance to Katahdin
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * Getter method
     * @return Elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * toString method gives a string representation of the Waypoint object
     * @return - a string that containse all of the information a Waypoint object contains.
     */
    public String toString() {
        return "Waypoint{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", toSpringer=" + toSpringer +
                ", toKatahdin=" + toKatahdin +
                ", elevation=" + elevation +
                '}';
    }

}
