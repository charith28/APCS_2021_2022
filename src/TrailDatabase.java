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
            Scanner in = new Scanner(new File("datafiles/apptrailDB.txt"));
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

    public void printDatabase(){

    }

    public void printDB() {
        for (Waypoint w : database)
            System.out.println(w);
    }



    public void sortDB(WaypointComparator wc){
        Collections.sort(database, new WaypointComparator(6,false));
    }

    public static void main(String[] args) {

    }
}
