import java.io.File;
import java.util.Scanner;

public class StringInputParser {
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

    public double extractDouble(String value)   {

        return 0.0;
    }

    public String removePuncutation(String value)   {

        return "";
    }

    public static void main(String[] args) {
        StringInputParser obj = new StringInputParser();
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter height in the format ft'in\" ");
            String input = in.nextLine();
            int inches = obj.extractInt(input);
            System.out.println(inches);
        }
        catch(Exception e) {
            System.err.println("error messages here");
        }
    }
}

