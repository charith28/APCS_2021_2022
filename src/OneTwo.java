import java.util.Scanner;

public class OneTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a number 1-10 (or 0 to quit:) ");
            int num = in.nextInt();
            switch (num) {
                case 0 -> System.out.println("Bye");
                case 1, 2 -> System.out.println("Buckle your shoe");
                case 3, 4 -> System.out.println("Close the door");
                case 5, 6 -> System.out.println("Pickup stics");
                case 7, 8 -> System.out.println("Don\'t be late");
                case 9, 10 -> System.out.println("Do it again");
                default -> System.out.println();
            }
            if(num == 0)
                break;
        }
        }
    }

