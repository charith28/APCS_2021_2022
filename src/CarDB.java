import java.util.*;
import java.io.*;

public class CarDB {
    private ArrayList<Car> database;

    public CarDB(){
        database = new ArrayList<>();
    }
    public void importData(){
        try{
            Scanner in = new Scanner(new File("cars.csv"));
            while(in.hasNext()){
                /*
                 * Car;MPG;Cylinders;Displacement;Horsepower;Weight;Acceleration;Model;Origin
                 * STRING;DOUBLE;INT;DOUBLE;DOUBLE;DOUBLE;DOUBLE;INT;STRING
                 */
                String[] oneline = in.nextLine().split(";");
                Car temp = new Car(oneline[0], Double.parseDouble(oneline[1]), Integer.parseInt(oneline[2]), Double.parseDouble(oneline[3]), Double.parseDouble(oneline[4]), Double.parseDouble(oneline[5]), Double.parseDouble(oneline[6]), Integer.parseInt(oneline[7]), oneline[8]);
                //System.out.println(Arrays.toString(oneline));
                database.add(temp);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printDB(){
        Collections.sort(database);
        for(Car c:database)
            System.out.println(c);
    }
    public static void main(String[] args) {

        CarDB db = new CarDB();
        db.importData();
        db.printDB();
        /*
        ArrayList<Integer> doesThisWork = new ArrayList<>();
        doesThisWork.add(0,12);
        doesThisWork.add(0,-6);
        doesThisWork.add(0,14);
        doesThisWork.add(0,9);
        doesThisWork.add(0,200);
        System.out.println(doesThisWork);
        Collections.sort(doesThisWork);
        System.out.println(doesThisWork);
        */
    }
}
