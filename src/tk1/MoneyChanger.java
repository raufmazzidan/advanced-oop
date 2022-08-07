package tk1;

import java.util.Scanner;

/**
 *
 * @author raufmazzidan
 */
public class MoneyChanger {

  static final double USD_RATE = 12000;
  static final double EURO_RATE = 15000;
  static final double POUNDS_RATE = 17500;

  public static void main(String[] args) {
    String currency;
    int nominalOrigin;
    double nominalResult;

    Scanner scan = new Scanner(System.in);

    System.out.println("Money Changer - ForeignerMoney");
    System.out.println("==============================\n");

    do {
      System.out.print("Masukkan Jenis Mata Uang Asing [USD : Euro : Pounds] : ");
      currency = scan.next();

      System.out.print("Masukkan Nominal Uang yang akan ditukarkan : Rp");
      nominalOrigin = scan.nextInt();

      if (currency.equals("USD")) {
        nominalResult = nominalOrigin / USD_RATE;
        System.out.printf("Dengan Rp %d anda memperoleh $%.2f USD", nominalOrigin, nominalResult);
      } else if (currency.equals("Euro")) {
        nominalResult = nominalOrigin / EURO_RATE;
        System.out.printf("Dengan Rp %d anda memperoleh \u20AC%.2f Euro", nominalOrigin, nominalResult);
      } else if (currency.equals("Pounds")) {
        nominalResult = nominalOrigin / POUNDS_RATE;
        System.out.printf("Dengan Rp %d anda memperoleh \u00A3%.2f Pounds", nominalOrigin, nominalResult);
      } else {
        System.out.println("Mata Uang Yang Anda Masukkan Salah, Silahkan Coba Kembali!\n");
      }

    } while (!(currency.equals("USD") || currency.equals("Euro") || currency.equals("Pounds")));
  }
}
