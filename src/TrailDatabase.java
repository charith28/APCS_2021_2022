import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version April 29 2022
 * @author 23fernando
 * Imports and parses through database file.
 * Sorts data using a MergeSort algorithm
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    /**
     * constructor to initialize the database arrayList and populate it with the contents of the .txt file
     */
    public TrailDatabase(){
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * uses a scanner object to parse lines of the apptrailDB.txt file and uses the string information to create a waypoint object
     * adds the waypoint object into the database arrayList.
     */
    public void populateDatabase(){
        try{
            Scanner in = new Scanner(new File("apptrailDB.txt"));

                String[] data = in.nextLine().split("\t");
                database.add(new Waypoint(data[0], data[1], data[2], Double.parseDouble(data[5]), Double.parseDouble(data[6]), Integer.parseInt(data[7])));
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error opening file...");
        }
    }

    /**
     * prompts the user as to which category mergeSort should use to order the database.
     */
    public void getSearchTerms(){
        System.out.println("*** Welcome to the Appalachian Trail Database ***\n \t+ Menu of search terms to use for sorting waypoints +\n \tTY: by name\n \tNA: by name\n \tST: by state\n \tDS: by distance to Springer\n \tDK: by distance to Katahdin\n \tEL: by elevation");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.toUpperCase().equals("TY"))
            searchTerm = 1;
        else if(term.toUpperCase().equals("NA"))
            searchTerm = 2;
        else if(term.toUpperCase().equals("ST"))
            searchTerm = 3;
        else if(term.toUpperCase().equals("DS"))
            searchTerm = 4;
        else if(term.toUpperCase().equals("DK"))
            searchTerm = 5;
        else if(term.toUpperCase().equals("EL"))
            searchTerm = 6;
        else if(term.toUpperCase().equals("Q"))
            searchTerm = 100;
        else{
            System.out.println("Invalid input. Defaulting to distance to Katahdin.");
            searchTerm = 5;
        }
        if (searchTerm >=1 && searchTerm <=6 ) {
            System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals("a"));
        }
    }

    /**
     * prints the contents of the database arraylist using a for-each loop
     */
    public void printDatabase() {
        for (Waypoint w : database)
            System.out.println(w);
    }

    /**
     * implements the MergeSort and WaypointComparator classes to sort the database
     */
    public void sortDB(){
        WaypointComparator wc = new WaypointComparator(searchTerm,asc);
        MergeSort m1 = new MergeSort(database, wc);
        m1.mergeSort(database);
    }

    /**
     * prompts user until the user decides to quit. Implements the print and sort database methods.
     * @param args - if needed
     */
    public static void main(String[] args) {
        TrailDatabase t1 = new TrailDatabase();
        while(t1.searchTerm!=100){
            t1.getSearchTerms();
            if(t1.searchTerm==100)
                break;
            t1.sortDB();
            t1.printDatabase();
        }
    }
}
