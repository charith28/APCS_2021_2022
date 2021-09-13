
import java.util.Scanner;
public class BasicIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Name:");
        String name = input.nextLine();
        System.out.println("Hello " + name + ", nice to meet you!");
        System.out.print("Enter your age:");
        int age = input.nextInt();
        System.out.println("Your age is: " + age);
        System.out.println("Your age squared is: " + Math.pow(age,2));

    }
}
