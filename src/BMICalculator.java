import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author 23fernando
 * @version November 9 2021
 * This class takes in user input, sanitizes it, and then runs it through a method tha returns the user's BMI from the numbers inputted.
 */
public class BMICalculator {
    public static double computeBMI(int inches, int pounds){
        if(inches <= 0 || pounds <= 0)
            return 0;
        return pounds*.454 / Math.pow(inches*0.0254,2);
    }

    /**
     * This method looks for a single quote and double quote and uses the substrings before them to determine the number values of a user's height.
     * @param value - a String that is to be analyzed for its integer values, which determines the user's height in inches.
     * @return - returns -1 if invalid or zero otherwise returns how many inches tall the user is.
     */
    public static int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1)
            return -1;
        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos+1, dblQtPos));
        if(inches < 0 || inches > 11 || feet < 0)
            return -1;
        return (feet*12 + inches == 0) ? -1 : feet*12+inches;
    }

    /**
     * Takes user input and implements the methods to return the users BMI. Also runs a for loop to check if the user whants to run another computation or terminate the program.
     * @param args - args if needed
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            System.out.print("Enter height in the format ft'in\": ");
            String input = in.next();
            int uInches = extractInches(input);
            System.out.print("Enter weight in lbs: ");
            int uWeight = in.nextInt();
            System.out.println("Your BMI is: " + df.format(computeBMI(uInches, uWeight)));
            System.out.print("Continue (Y/N): ");
            String cont = in.next();
            if(!cont.toLowerCase().equals("y"))
                break;
        }
        System.out.println("End of program");
        }

}

