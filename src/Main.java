/*
    Main class for Lab 10 part 1, Tornados
    by Zellar and Jitin Ponnam
 */

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        SortedList sortedList = new SortedList();
        UserInterface userInterface = new UserInterface();

        //test Tornadoes
        sortedList.recordTornado(2, 2, 2000, "Flint", 4);
        sortedList.recordTornado(2, 2, 2000, "Flint", 4);
        sortedList.recordTornado(2, 3, 2000, "Moon", 3);

        while (loop) {
            // Display the main menu and prompt the user for a command
            System.out.println("\nWelcome to Tornado Recorder");
            System.out.println("Choose a command from the list: ");
            System.out.println("Record a Tornado, Print All, Print by Date, Print by Strength, Print by Location, Exit");
            String command = sc.nextLine();
            
            //Process the command
            switch (command) {
                case "Record a Tornado": {
                    userInterface.insertRecord(sc, sortedList);
                    break;
                }

                case "Print All": {
                    userInterface.printAll(sortedList);
                    break;
                }
                case "Print by Date":{
                    userInterface.printByDate(sc, sortedList);
                    break;
                }
                case "Print by Strength":{
                    userInterface.printByStrength(sc, sortedList);
                    break;
                }
                case "Print by Location": {
                    userInterface.printByLocation(sc, sortedList);
                    break;
                }
                case "Exit":{
                    loop = false;
                    break;
                }
                default:{
                    System.out.println("Invalid command");
                }
            }
        }
    }
}
