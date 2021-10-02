import java.util.Scanner;
public class RomanToDecimal {
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
        if(roman.toUpperCase().indexOf("CM") != -1)
            decimal -= 200;
        return decimal;
    }
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

    public static boolean isLogVal(String numeral, int value) {
        return decimalToRoman(value) == numeral;
    }


    public static void main(String[] args) {
        Scanner user =  new Scanner(System.in);
        RomanToDecimal obj = new RomanToDecimal();

        for (String temp: args){
            int val = romanToDecimal(temp);
            if(val == -1){
                System.out.println("Input: " + temp + " => output: invalid");
            }
            else if (!isLogVal(temp.toUpperCase(),val)){
                System.out.println("Input: " + temp + " => output: invalid form");
            }
            else{
                System.out.println("Input: " + temp + " => output: " + val);
            }
        }
    }
}
