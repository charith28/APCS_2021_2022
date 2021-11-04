import java.util.Random;
import java.lang.*;
/**
 * Simple object representation.
 * @version 11/15/2021
 * @author 23fernando
 */
public class Lars {
    //instance variables, class variables, object variables, object data
    private boolean brain;
    private String label;
    private int id;
    private Double cashMoney;

    /**
     * Default parameterized constuctor for lars
     */
    public Lars(){
        brain = false;
        label = new String();
        id = 0;
        cashMoney = 0.0;
    }
    /**
     * Parameterized constructor for lars
     * @param b A boolean value for hasBrain
     * @param l A string value for label
     * @param i A int value supplied for id
     */
    public Lars(boolean b, String l, int i){
        brain = b;
        label = l;
        id = i;

    }

    //ACCESOR METHODS
    public boolean HasBrain(){ return false;}
    public String getLabel() { return label;}
    public int getId(){ return id;}

    /**
     *
     * @param b
     */
    //MUTATOR METHOD
    public void setBrain(boolean b){
        brain = b;
    }

    public void setLabel(String l) {
        label = l;
    }

    public void setId(int i) {
        id = i;
    }
    public String toString(){
        return "LARS" + brain + "|" + label + "|" + id;
    }

    public void randPop(){
        Random rand  = new Random();
        int randIndex = rand.nextInt(getLabel().length() - 1);
        StringBuilder sb = new StringBuilder(getLabel());
        sb.deleteCharAt(randIndex);
        label =  sb.toString();
    }
    public static int swapOnesAndTens(int num){
        //return num + (num %10 - (num-(num%10))/10%10)*10 - (num %10 - (num-(num%10))/10%10);
        return num-(num/10%10- num %10) * 10+ num/10%10-num%10;
        // num%10 = ones
        //num/10%10 = tens

        //return (num-num%100) + num%10*10 +num/10%10;
    }

    public static double maxOf3(double x,double y,double z){
        return Math.max(z, Math.max(x,y));
    }
    public static void main(String[] args) {
        Lars l1 = new Lars();
        Lars l2 = new Lars(true,"CHARITHFERNANDO", 123);
        l2.randPop();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(swapOnesAndTens(6549));
        int x =3,a =2,b = 1 ,y=5;


        if ((x+2 > a || x-2 < b) && y >= 0){


        }

        final double g = 16.0;
        double t = 35.5;
        System.out.print("ans:");
        System.out.println(1/2.0*(g*t*t));
    }
}
