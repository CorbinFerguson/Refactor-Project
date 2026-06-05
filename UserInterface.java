import java.util.Scanner;
import java.util.Objects;

public class UserInterface {
    public int[] getDate(Scanner sc, boolean fromPrint) {
        //Get date from user, return as int array of day, month, year. Return null if invalid input
        
        // Prompt user for year (different prompt if from printing or from recording)
        if (fromPrint) {
            System.out.println("\nEnter the year you wish to search by (1985 - 2025): ");
        } else {
            System.out.println("\nEnter the year it occurred (1985 - 2025): ");
        }
        int year;
        
        // Get year from user
        try {
            // Try to parse the input as an integer
            year = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            // Input not a valid integer, print error message and return null
            System.out.println("Invalid input. Please enter a positive integer.");
            return null;
        }
        if(year > 1984 && year < 2026) {
            // Valid input, do nothing
        }
        else {
            // Invalid input, print error message and return null
            System.out.println("Improper entry");
            return null;
        }


        // Prompt user for month (different prompt if from printing or from recording)
        if (fromPrint) {
            System.out.println("\nEnter the month you wish to search by (1-12): ");
        } else {
            System.out.println("\nEnter the month it occurred (1-12): ");
        }
        int month;
        
        // Get month from user
        try {
            // Try to parse the input as an integer
            month = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            // Input not a valid integer, print error message and return null
            System.out.println("Invalid input. Please enter a positive integer.");
            return null;
        }
        if(month < 13 && month > 0){
            // Valid input, do nothing
        }else {
            // Invalid input, print error message and return null
            System.out.println("Improper entry");
            return null;
        }


        // Prompt user for day (different prompt if from printing or from recording)
        if (fromPrint) {
            System.out.println("\nEnter the day you wish to search by (1-31): ");
        } else {
            System.out.println("\nEnter the day it occurred (1-31): ");
        }
        int day;

        // Get day from user
        try {
            // Try to parse the input as an integer
            day = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            // Input not a valid integer, print error message and return null
            System.out.println("Invalid input. Please enter a positive integer.");
            return null;
        }
        if(day < 32 && day > 0){
            // Valid input, return the date as an int array
            int[] date = new int[]{day, month, year};
            return date;
        }else {
            // Invalid input, print error message and return null
            System.out.println("Improper entry");
            return null;
        }
    }

    public String getString(Scanner sc) {
        // get and return a string from the user
        return sc.nextLine();
    }

    public int getStrength(Scanner sc, boolean fromPrint) {
        // prompt user for strength (different prompt if from printing or from recording)
        if (fromPrint) {
            System.out.println("Enter the Strength of the Tornadoes you wish to print: ");
        } else {
            System.out.println("\nEnter the Strength of the Tornado (1-5): ");
        }
        int strength;

        // Get strength from user
        try {
            // Try to parse the input as an integer
            strength = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            // Input not a valid integer, print error message and return invalid response
            System.out.println("Invalid input. Please enter a positive integer.");
            return -1;
        }

        // Check if the strength is valid
        if(strength > 0 && strength < 6) {
            // Valid input, return the strength
            return strength;
        }else{
            // Invalid input, print error message (different message if from printing or from recording)
            if (fromPrint) {
                System.out.println("Invalid input. Enter a integer 1-5.");
            } else {
                System.out.println("Improper entry");
            }

            // Return invalid response
            return -1;
        }
    }

    public void insertRecord(Scanner sc, SortedList sortedList) {
        // Allow the user to add a tornado to the records
        
        // Loop till user wants to stop adding tornadoes
        while (true) {
            // Get tornado information
            
            // Location/exit command
            // Get location or exit command
            System.out.println("\nEnter the Location in which the tornado occurred then press 'enter', type 'back' to leave: ");
            String location = getString(sc);
            
            // check location for exit condition
            if (Objects.equals(location, "back")) {
                break;
            }

            //Date
            // Get the date
            int[] date = getDate(sc, false);

            // If date is invalid, skip rest of loop and start over
            if (date == null) {
                continue;
            }

            // Strength
            // Get the strength
            int strength = getStrength(sc, false);
            
            // If invalid strength, skip rest of loop and start over
            if(strength == -1){
                continue;
            }
            
            // If all input is valid, record the tornado
            sortedList.recordTornado(date[0], date[1], date[2], location, strength);
            System.out.println("Tornado recorded.");
        }
    }

    public void printAll(SortedList sortedList) {
        sortedList.printAll();
    }

    public void printByDate(Scanner sc, SortedList sortedList) {
        // Get the date
        int[] date = getDate(sc, true);
        
        // If found
        if (date != null) {
            // Print tornadoes of that date
            sortedList.printDate(date[0], date[1], date[2]);
        }
    }

    public void printByStrength(Scanner sc, SortedList sortedList) {
        // Get the strength
        int strength = getStrength(sc, true);
        
        // If found
        if (strength != -1) {
            // Print tornadoes of that strength
            sortedList.printStrength(strength);
        }
    }

    public void printByLocation(Scanner sc, SortedList sortedList) {
        // Ask for location
        System.out.println("Enter the Location of the Tornadoes you wish to print: ");
        
        // Get answer (will always get something)
        String location = getString(sc);

        // Print tornadoes of that location
        sortedList.printLocation(location);
    }
}
