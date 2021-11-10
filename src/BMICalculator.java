import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class BMICalculator {
    public static double computeBMI(int inches, int pounds){
        if(inches <= 0 || pounds <= 0)
            return 0;
        return pounds*.454 / Math.pow(inches*0.0254,2);
    }
    public static int extractInt(String value) {
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


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            System.out.print("Enter height in the format ft'in\": ");
            String input = in.next();
            int uInches = extractInt(input);
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

