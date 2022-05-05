import org.w3c.dom.CDATASection;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;

    public TrailDatabase(){
        database = new ArrayList<>();
        populateDatabase();
    }
    public void populateDatabase(){
        try{
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while(in.hasNext()){
                String[] data = in.nextLine().split("\t");
                database.add(new Waypoint(data[0], data[1], data[2], Double.parseDouble(data[5]), Double.parseDouble(data[6]), Integer.parseInt(data[7])));
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error opening file...");
        }
    }


    public void getSearchTerms(){
        System.out.println("*** Welcome to the Appalachian Trail Database ***\n \t+ Menu of search terms to use for sorting waypoints +\n \tTY: by name\n \tNA: by name\n \tST: by state\n \tDS: by distance to Springer\n \tDK: by distance to Katahdin\n \tEL: by elevation");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        //
    }




    public void printDatabase() {
        for (Waypoint w : database)
            System.out.println(w);
    }

    public void sortDB(WaypointComparator wc){
        Collections.sort(database, wc);
    }

    public static void main(String[] args) {
        TrailDatabase t1 = new TrailDatabase();
        MergeSort m1 = new MergeSort(t1.database, new WaypointComparator(5,false));
        t1.sortDB(new WaypointComparator(5,false));
        t1.printDatabase();
        m1.mergeSort(t1.database);
        m1.printDatabase();

    }
}
