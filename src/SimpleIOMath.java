import java.util.Scanner;

/**
 * SimpleIOMath is a program which gets basic information from a user and manipulates it to provide a summary and interesting facts
 * @version Monday Sep 27, 2021
 * @author 23fernando
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;
    private int smallestPrime(int num){
        for (int i = 2; i < (int)(Math.sqrt(num))+1; i++) {
            if (num%i == 0)
                return i;
        }
        return num;
    }
    private String myExtra(int i){
        return Integer.toBinaryString(i);
    }
    /**
     *promptUser initiates the scanner and asks the user for the initial information
     */
    public void promptUser(){
        Scanner input = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();
    }
    /**
     * printInfo uses a for loop to print out a long array of text and then continues to print out the information provided by the use
     */
    public void printInfo(){
        String[] anArray;
        anArray = new String[] {"I'm gonna teach you how to sing it out", "Come on, come on, come on" , "Let me tell you what it's all about" , "Reading, writing, arithmetic" , "Are the branches of the learning tree"};
        String x;
        for (String s : anArray) {
            x = s;
            System.out.println(x);
        }
        System.out.println("Your name is:"+ name);
        System.out.println("Your age is:"+ age);
        System.out.println("At your next birthday, you will turn:" + (age+1));
        System.out.println("The first prime factor of 47 is:" + (smallestPrime(age)));
        System.out.println("Your favorite number is:" + favNumber);
        System.out.println("Your favorite number squared is:" + Math.round(Math.pow(favNumber,2)));
        System.out.println("Your favorite number in Binary is: " + myExtra(favNumber));
        System.out.println("* end of program *");
    }

    /**
     * Main entry point
     * @param args - if needed
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj=new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
    }

}
