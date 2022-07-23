package tp1;

import java.util.Scanner;

/**
 *
 * @author raufmazzidan
 */
public class Two {
    public static void main(String[] args) {
        int i = 2, res = 0, n;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan N : ");
        n = scan.nextInt();
        
        System.out.print("Deret : ");
        while(n > 0) {
            int totalFactor = 0;
            
            for (int k = 1; k <= i; k++) {
                if (i % k == 0) {
                    totalFactor++;
                }
            }
            if (totalFactor == 2) {
                System.out.print(i + ", ");
                n--;
                res += i;
            }
            i++;
        }
       
        System.out.println("\nTotal : " + res);
    }
}
