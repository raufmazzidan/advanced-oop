package tp1;

import java.util.Scanner;

/**
 *
 * @author raufmazzidan
 */
public class Three {

    public static void main(String[] args) {
        int num;

        Scanner scan = new Scanner(System.in);
        System.out.print("Input : ");

        try {
            num = scan.nextInt();
            System.out.println("Number : " + num);
        } catch (Exception e) {
            System.err.println("Invalid Number");
        }
    }
}
