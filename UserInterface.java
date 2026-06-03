import java.util.Scanner;
import java.util.Objects;

public class UserInterface {
    public int[] getDate(Scanner sc) {
        //Get date from user, return as int array of day, month, year. Return null if invalid input
        System.out.println("\nEnter the year you wish to search by (1985 - 2025): ");
        int year;
        try {
            year = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return null;
        }
        if(year > 1984 && year < 2026) {

            System.out.println("\nEnter the month you wish to search by (1-12): ");
            int month;
            try {
                month = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                return null;
            }
            if(month < 13 && month > 0){

                System.out.println("\nEnter the day you wish to search by (1-31): ");
                int day;
                try {
                    day = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    return null;
                }
                if(day < 32 && day > 0){
                    int[] date = new int[]{day, month, year};
                    return date;
                }else {
                    System.out.println("Improper entry");
                    return null;
                }
            }else {
                System.out.println("Improper entry");
                return null;
            }
        }else {
            System.out.println("Improper entry");
            return null;
        }
    }

    public String getString(Scanner sc) {
        // get and return a string from the user
        return sc.nextLine();
    }

    public int getStrength(Scanner sc) {
        // temp for compiling TODO
        return -1;
    }

    public void insertRecord(Scanner sc) {

    }

    public void printAll(SortedList sortedList) {
        sortedList.printAll();
    }

    public void printByDate(Scanner sc, SortedList sortedList) {
        int[] date = getDate(sc);
        if (date != null) {
            sortedList.printDate(date[0], date[1], date[2]);
        }
    }

    public void printByStrength(Scanner sc, SortedList sortedList) {

    }

    public void printByLocation(Scanner sc, SortedList sortedList) {

    }
}
