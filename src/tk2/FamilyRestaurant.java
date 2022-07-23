package tk2;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author raufmazzidan
 */
class Menu {

    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    protected String code, name, firstChar = "R";
    protected int price;

    protected void inputCode() {
        String tempCode;
        boolean validateInput;

        do {
            System.out.printf("input menu code [%s...]: ", firstChar);
            tempCode = scan.next();

            validateInput = tempCode.length() == 4 && tempCode.startsWith(firstChar);

            if (validateInput) {
                code = tempCode;
            }
        } while (!validateInput);
    }

    protected void inputName() {
        String tempName;
        boolean validateInput;

        do {
            System.out.print("input menu name [5-20]: ");
            tempName = scan.next();

            validateInput = tempName.length() >= 5 && tempName.length() <= 20;

            if (validateInput) {
                name = tempName;
            }
        } while (!validateInput);
    }

    protected void inputPrice() {
        int tempPrice;
        boolean validateInput;

        do {
            System.out.print("input menu price [10000-100000]: ");
            tempPrice = scan.nextInt();

            validateInput = tempPrice >= 10000 && tempPrice <= 100000;

            if (validateInput) {
                price = tempPrice;
            }
        } while (!validateInput);
    }

    public void input() {
        inputCode();
        inputName();
        inputPrice();
        System.out.println("Add Success!");
    }

    public void show() {
        System.out.println(code);
        System.out.println(name);
        System.out.println(price);
    }
}

class MenuSpecial extends Menu {

    protected int discount;

    MenuSpecial() {
        firstChar = "S";
    }

    protected void inputDiscount() {
        int tempDiscount;
        boolean validateInput;

        do {
            System.out.print("input menu discount [10% | 25% | 50%]: ");
            tempDiscount = scan.nextInt();

            validateInput = tempDiscount == 10 || tempDiscount == 25 || tempDiscount == 50;

            if (validateInput) {
                discount = tempDiscount;
            }
        } while (!validateInput);
    }

    @Override
    public void input() {
        inputCode();
        inputName();
        inputPrice();
        inputDiscount();
        System.out.println("Add Success!");
    }

    @Override
    public void show() {
        System.out.println(code);
        System.out.println(name);
        System.out.println(price);
        System.out.println(discount);
    }

}

public class FamilyRestaurant {

    static void showAllMenu(ArrayList<Menu> menuRegular, ArrayList<MenuSpecial> menuSpecial) {
        System.out.println("\nReguler Menu");
        System.out.println("==============================================");
        System.out.printf("| %2s | %4s | %20s | %7s |", "No", "Kode", "Nama", "Harga");
        System.out.println();
        System.out.println("==============================================");
        for (int i = 0; i < menuRegular.size(); i++) {
            Menu m = menuRegular.get(i);
            System.out.format("| %2d | %4s | %20s | %7d |", i+1, m.code, m.name, m.price);
            System.out.println();
        }
        System.out.println("==============================================");
        
        System.out.println("\nSpecial Menu");
        System.out.println("=======================================================");
        System.out.printf("| %2s | %4s | %20s | %7s | %6s |", "No", "Kode", "Nama", "Harga", "Diskon");
        System.out.println();
        System.out.println("=======================================================");
         for (int i = 0; i < menuSpecial.size(); i++) {
            MenuSpecial m = menuSpecial.get(i);
            System.out.format("| %2d | %4s | %20s | %7d | %5s%% |", i+1, m.code, m.name, m.price, m.discount);
            System.out.println();
        }
        System.out.println("=======================================================");
    }
    
    static int findMenuIndex(String code, ArrayList<MenuSpecial> menu) {
        int res = -1;
        
        for (int i = 0; i < menu.size(); i++) {
            Menu m = menu.get(i);
            if (m.code.equals(code)) {
                res = i;
            }
        }
        
        return res;
    }
    
    static void deleteMenu(ArrayList menu, String firstChar) {
        String tempCode;
        Scanner scan = new Scanner(System.in);
        
        System.out.printf("\nDelete %s Menu", firstChar.equals("R")? "Reguler" : "Special");
        System.out.println("\n==============================================");
        
        System.out.printf("input menu code [%s...]: ", firstChar);
        tempCode = scan.next();
        
        int index = findMenuIndex(tempCode, menu);
        
        try {
            menu.remove(index);
            System.out.println("Delete Success!");
        } catch (Exception e) {
            System.out.println("Code is Wrong");
        }
    }

    public static void main(String[] args) {
        String action;
        Scanner scan = new Scanner(System.in);
        ArrayList<Menu> menuRegular = new ArrayList<>();
        ArrayList<MenuSpecial> menuSpecial = new ArrayList<>();
        do {

            System.out.println("Family Restaurant");
            System.out.println("==============================\n");

            System.out.println("1. Add Regular Menu");
            System.out.println("2. Add Special Menu");
            System.out.println("3. Show All Menu");
            System.out.println("4. Delete Regular Menu");
            System.out.println("5. Delete Special Menu");
            System.out.println("6. Exit");

            do {
                System.out.print("Choice [1-6]: ");
                action = scan.next();

                if (action.equals("1")) {
                    Menu m = new Menu();
                    m.input();
                    menuRegular.add(m);
                } else if (action.equals("2")) {
                    MenuSpecial ms = new MenuSpecial();
                    ms.input();
                    menuSpecial.add(ms);
                } else if (action.equals("3")) {
                    showAllMenu(menuRegular, menuSpecial);
                } else if (action.equals("4")) {
                    deleteMenu(menuRegular, "R");
                } else if (action.equals("5")) {
                    deleteMenu(menuSpecial, "S");
                } else {

                }

            } while (!action.matches("^[1-6]$"));
            System.out.print("\n");
        } while (!action.equals("6"));
    }
}
