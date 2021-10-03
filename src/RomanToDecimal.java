import java.util.Scanner;
/**
 * RomanToDecimal is a program which converts both user and args input of Roman Numerals into Integer form, while handling invalid and incorrect input.
 * @version Sunday October 3, 2021
 * @author 23fernando
 */
public class RomanToDecimal {
    /**
     * Takes parameter roman and uses a for loop to determine the number values of each character. It then checks for invariants and subtracts the corresponding amount.
     * The .substring, .toUpperCase, .length, and .indexOf methods are implemented in this method.
     * @param roman - User or args input of a roman numeral. This parameter is parsed through and analyzed for its characters which determine the integer equivalent.
     * @return - Program returns -1 if invalid or the integer format of the Roman Numeral if input is valid
     */
    public static int romanToDecimal(String roman){
        int decimal = 0;

        for(int i = 0;i < roman.length(); i++){
            //System.out.print(roman.substring(i,i+1).toUpperCase());
            String upperChar = roman.substring(i, i + 1).toUpperCase();
            if(upperChar.equals("I")){
                decimal +=1;
            }
            else if (upperChar.equals("V")){
                decimal +=5;
            }
            else if (upperChar.equals("X")){
                decimal +=10;
            }
            else if (upperChar.equals("L")){
                decimal +=50;
            }
            else if (upperChar.equals("C")){
                decimal +=100;
            }
            else if (upperChar.equals("D")){
                decimal +=500;
            }
            else if (upperChar.equals("M")){
                decimal +=1000;
            }
            else{
                return -1;
            }

        }
        if(roman.toUpperCase().indexOf("IV") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("IX") != -1)
            decimal -=2;
        if(roman.toUpperCase().indexOf("XL") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("XC") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("CD") != -1)
            decimal -=200;
        if(roman.toUpperCase().indexOf("CM") != -1) {
            decimal -= 200;
        }
       return isLogVal(roman.toUpperCase(), decimal);
    }

    /**
     * Uses a subtractive for loop and while loop which takes away the largest possible number from value and then adds the corresponding letter(s) to the end of an empty string.
     * @param value - A integer value which is converted into a Roman numeral
     * @return - This method returns a String which is the correct Roman numeral for any value between 1-10000.
     */
    public static String decimalToRoman(int value){
        String logVal = "";
        String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] romval = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        for (int i = 12; i >=0 && value > 0 ; i--) {
            while (value >= romval[i]) {
                value -= romval[i];
                logVal = logVal + rom[i];

            }
        }

        return logVal;
    }

    /**
     * A simple if else statement that checks the equivalency of the user input and the correct roman numeral for a given value.
     * This method is run at the end of decimalToRoman, to filter for invalid roman numerals that have been converted.
     * @param numeral - The user or args input of a roman numeral is put here.
     * @param value - The value calculated by the decimalToRoman method is put here.
     * @return - The method returns -1 if the user/args input is not correct or valid, otherwise returns the value of the conversion.
     */
    public static int isLogVal(String numeral, int value) {
        if (numeral.toUpperCase().equals(decimalToRoman(value))){
            return value;
        }
        else{ return -1;}
    }

    /**
     * Main entry point. Runs the args test set and then handles user inputs.
     * @param args - contain a test set Roman Numerals and invalid inputs.
     */
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        RomanToDecimal obj = new RomanToDecimal();

        for (String temp : args) {
            int val = romanToDecimal(temp);
            if (val == -1) {
                System.out.println("Input: " + temp + " => output: invalid");
            } else {
                System.out.println("Input: " + temp + " => output: " + val);
            }
        }
        System.out.println("Type a roman numeral for a conversion. Type STOP to terminate the program.");
        String uinp = user.nextLine();
        int udec = romanToDecimal(uinp);
        while(!uinp.equalsIgnoreCase("stop")) {
            if (uinp.equalsIgnoreCase("stop")) {
                System.out.print("Thanks!");
            }else if(udec == -1){
                System.out.print("Input: "+ uinp.toUpperCase() + " => output: invalid");
                uinp = user.nextLine();
            } else {
                System.out.print("Input: "+ uinp.toUpperCase() + " => output: " + udec);
                uinp = user.nextLine();
            }
        }
    }
}
