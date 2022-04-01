import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CoinSorterMachine {
    private int pennyCount;
    private int nickelCount;
    private int dimeCount;
    private int quarterCount;
    private int dollarCount;
    private int halfCount;
    private ArrayList<Coin> coins;
    private ArrayList<Coin> coinMap;
    private int[] typeCounts;

    /**
     * Fills out the ArrayLists coinMap and coins
     */
    public CoinSorterMachine(){
        coinMap = new ArrayList<>();
        coins = new ArrayList<>();
        coinMap.add(new Penny());
        coinMap.add(new Nickel());
        coinMap.add(new Dime());
        coinMap.add(new Quarter());
        coinMap.add(new HalfDollar());
        coinMap.add(new Dollar());
        typeCounts = new int[6];
    }
    private Coin makeCoin(double value){
        for(Coin c: coinMap){
            if(c.getValue() == value)
                return c;
        }
        return null;
    }

    /**
     * Uses two scanner objects to prompt user for file path and scan file path for all of its coin values.
     * Handles Diabolic values using a try catch
     */

    public void depositCoins(){
        System.out.println("Depositing coins...");
        try{
            Scanner fsel = new Scanner(System.in);
            System.out.print("Enter file path here: ");
            String path = fsel.nextLine();
            Scanner fhand = new Scanner(new File("coins1.txt") );
            while(fhand.hasNext()) {
                int number = fhand.nextInt();
                Coin c = makeCoin(number/100.);
                if(c== null)
                    System.out.println("Coin value " + number + " is not recognized");
                else{
                    if(c instanceof Penny) {
                        typeCounts[0]++;
                        coins.add(c);
                    }
                    if(c instanceof Nickel) {
                        typeCounts[1]++;
                        coins.add(c);
                    }
                    if(c instanceof Dime) {
                        typeCounts[2]++;
                        coins.add(c);
                    }
                    if(c instanceof Quarter) {
                        typeCounts[3]++;
                        coins.add(c);
                    }
                    if(c instanceof HalfDollar) {
                        typeCounts[4]++;
                        coins.add(c);
                    }
                    if(c instanceof Dollar) {
                        typeCounts[5]++;
                        coins.add(c);
                    }

                }
            }
            fhand.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Prints deposit summary using a DecimalFormat object to correctly format objects
     * Implements getTotalValue method to sum coins
     */

    public void printDepositSummary(){
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of deposit: ");
        for(int i = 0; i<typeCounts.length; i++){
            if (typeCounts[i] == 1)
                System.out.println("\t" + typeCounts[i]+ " "+ coinMap.get(i).getName()+ " "+ df.format(typeCounts[i]*coinMap.get(i).getValue()));
            else
                System.out.println("\t" + typeCounts[i]+ " "+ coinMap.get(i).getPluralName()+ " "+df.format(typeCounts[i]*coinMap.get(i).getValue()));
        }
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     * totals the value of the coins in the coins ArrayList
     * @return total value of coins in file
     */
    public double getTotalValue(){
        double total = 0.0;
        for(Coin c: coins)
            total += c.getValue();
        return total;
    }

    /**
     * creates new CoinSorterMachine object
     * @param args if needed
     */
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
