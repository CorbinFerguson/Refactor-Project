/*
    Main class for Lab 10 part 1, Tornados
    by Zellar and Jitin Ponnam
 */

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean l = true;
        SortedList sortedList = new SortedList();
        String test;
        UserInterface userInterface = new UserInterface();

        //test Tornadoes
        sortedList.recordTornado(2, 2, 2000, "Flint", 4);
        sortedList.recordTornado(2, 2, 2000, "Flint", 4);
        sortedList.recordTornado(2, 3, 2000, "Moon", 3);

        while (l) {
            // Display the main menu and prompt the user for a command
            System.out.println("\nWelcome to Tornado Recorder");
            System.out.println("Choose a command from the list: ");
            System.out.println("Record a Tornado, Print All, Print by Date, Print by Strength, Print by Location, Exit");
            String command = sc.nextLine();
            switch (command) {
                case "Record a Tornado": {
                    // Allow the user to add a plane to the air queue
                    while (true) {
                        System.out.println("\nEnter the Location in which the tornado occurred then press 'enter', type 'back' to leave: ");
                        String location = sc.nextLine();
                        if (Objects.equals(location, "back")) {
                            break;
                        } else {
                            System.out.println("\nEnter the year it occurred (1985 - 2025): ");
                            int year;
                            try {
                                year = Integer.parseInt(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive integer.");
                                continue;
                            }
                            if(year > 1984 && year < 2026) {

                                System.out.println("\nEnter the month it occurred (1-12): ");
                                int month;
                                try {
                                    month = Integer.parseInt(sc.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a positive integer.");
                                    continue;
                                }
                                if(month < 13 && month > 0){

                                    System.out.println("\nEnter the day it occurred (1-31): ");
                                    int day;
                                    try {
                                        day = Integer.parseInt(sc.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a positive integer.");
                                        continue;
                                    }
                                    if(day < 32 && day > 0){

                                        System.out.println("\nEnter the Strength of the Tornado (1-5): ");
                                        int strength;
                                        try {
                                            strength = Integer.parseInt(sc.nextLine());
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter a positive integer.");
                                            continue;
                                        }
                                        if(strength > 0 && strength < 6){

                                            sortedList.recordTornado(day, month, year, location, strength);
                                            System.out.println("Tornado recorded.");
                                        }else {
                                            System.out.println("Improper entry");
                                        }
                                    }else {
                                        System.out.println("Improper entry");
                                    }
                                }else {
                                    System.out.println("Improper entry");
                                }
                            }else {
                                System.out.println("Improper entry");
                            }
                        }
                    }
                    break;
                }

                case "Print All": {
                    sortedList.printAll();
                    break;
                }
                case "Print by Date":{
                    userInterface.printByDate(sc, sortedList);
                    break;
                }
                case "Print by Strength":{
                    System.out.println("Entre the Strength of the Tornadoes you wish to print: ");
                    int strength;
                    try {
                        strength = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a positive integer.");
                        continue;
                    }
                    if(strength > 0 && strength < 6) {
                        sortedList.printStrength(strength);
                        break;
                    }else{
                        System.out.println("Invalid input. Enter a integer 1-5.");
                    }
                    break;
                }
                case "Print by Location": {
                    System.out.println("Entre the Location of the Tornadoes you wish to print: ");
                    test = sc.nextLine();
                    sortedList.printLocation(test);
                    break;
                }
                case "Exit":{
                    l = false;
                    break;
                }
                default:{
                    System.out.println("Invalid command");
                }
            }
        }
    }
}
