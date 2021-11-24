import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * Base converter opens a data file, converts numbers, prints the converted outputs
 * @version Thursday 11/18/2021
 * @author 23fernando
 */
public class BaseConverter {
    private String alpha = "0123456789ABCDEF";
    /**
     * Empty constructor for class.
     */
    public BaseConverter(){}
    /**
     *  Convert a String num in fromBase to base-10 int.
     * @param num - A string that represents number that needs to be converted
     * @param fromBase - A string that represents the base which the number given is in
     * @return - The converted int value of num in base-10.
     */
    public int strToInt(String num, String fromBase){
        int base = Integer.parseInt(fromBase);

        int sum = 0, exp = 0;
        for (int i = num.length()-1; i >= 0; i--) {
            sum += alpha.indexOf(""+num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }
    // Convert a base-10 int to a String number of base toBase.

    /**
     *Takes base 10 integer and converts into base of user's choice
     * @param num a base 10 integer which is being converted to another base
     * @param toBase - The base to which num is being converted to
     * @return - The converted value of num in base toBase.
     */
    public String intToStr(int num, int toBase){
        String toNum = "";
        while(num >0){
            toNum = alpha.charAt(num%toBase) + toNum;
            num /= toBase;
        }
        if(toNum.equals(""))
            return "0";
        return toNum;
    }
    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite(){
        boolean user = false;
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File(jFile()));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if (fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase);
                } else if (toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base " + toBase);
                } else {
                    System.out.print(line[0]+ " base " + line[1] + " = " + intToStr(strToInt(line[0],line[1]),Integer.parseInt(line[2])) + " base " + line[2]);
                    pw.print(line[0]+ "\t" + line[1] + "\t" + intToStr(strToInt(line[0],line[1]),Integer.parseInt(line[2])) + "\t" + line[2]);
                    System.out.println();
                    pw.println();

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(sc!= null)
            sc.close();
        if (pw!=null)
            pw.close();
    }

    /**
     * EXTRA
     * creates a JFileChooser and allows user to choose only .dat files to convert.
     * @return The file path of the selected file
     */
    public static String jFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat File (*.dat)", "dat");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile().getAbsolutePath();
    }

    /**
     * Main method for class BaseConverter. creates instanec of BaseConverter and then runs methods.
     * @param args - args if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
