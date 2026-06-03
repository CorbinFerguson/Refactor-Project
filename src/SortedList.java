/* SortedList.java
    by zellar & Jitin Ponnam

    has been customized for particular use
 */

import java.util.Objects;

public class SortedList {
    private int size; // Number of items in the list
    private Tornado head; // Reference to the head node

    //Insert method
    public void insert(int ID) {
        Tornado newNode = new Tornado(ID);

        if (head == null) { // Case 1: Inserting into an empty list
            head = newNode; // Set the newNode as the head node
        }
        else if (ID < head.getID()) {// Case 2: Insert at the beginning if the new value is smaller than the head value
            newNode.setNext(head); // Link the new node to the current head
            head.setPrevious(newNode); // Update the current head's previous pointer
            head = newNode; // Set the new node as the head
        }
        else { // Case 3: Insert at the correct position in the middle or end
            Tornado current = head;

            // Traverse the list to find the appropriate position
            while (current.getNext() != null && current.getNext().getID() < ID) {
                current = current.getNext();
            }

            // Insert the new node between current and current's next
            newNode.setNext(current.getNext()); // Link newNode's next to current's next
            newNode.setPrevious(current);// Link newNode's previous to current

            // If the new node is not being inserted at the end, update links for the next node
            if (current.getNext() != null) {
                current.getNext().setPrevious(newNode);
            }

            // Link current node's next pointer to the new node
            current.setNext(newNode);
        }

        size++; // Increment the size of the list
    }


    // Constructor to initialize an empty list
    public SortedList() {
        this.size = 0; // Initialize size to zero
        this.head = null; // Initialize head as null
    }

    // Method to get the current size of the list
    public int getSize() {
        return size;
    }

    //Method to record Tornado
    public void recordTornado(int day,int months,int year,String location,int strength) {

        int IDnum = 0;
        //finds available open id slot, creates the new account and assigns the new ID to the var ID
        for (int i = 1; 0 < i; i++) {
            if (find(i) == null){
                insert(i);
                IDnum = i;
                break;
            }
        }
        Tornado current = find(IDnum);

        current.setDay(day);
        current.setMonth(months);
        current.setYear(year);
        current.setLocation(location);
        current.setStrength(strength);
        current.setID(IDnum);

    }

    //Method to find a user's node based on their ID
    public Tornado find(int target) {
        Tornado current = head;  // Start from the head of the list

        // Traverse nodes until the target value is found or the end of the list is reached
        while (current != null) {
            if (current.getID() == target) {
                return current; // Return the node if value matches the target
            }
            current = current.getNext(); // Move to the next node
        }

        // If value is not found, return null
        return null;
    }

    // prints all tornadoes of the given date
    public void printDate(int day,int month,int year){
        Tornado current = head;
        Tornado temp = null;
        while (current != null) {
            if (current.getDay() == day) {
                if (current.getMonth() == month){
                    if (current.getYear() == year) {
                        System.out.println("Location: " + current.getName() + " date: " + current.getDay() + "/" + current.getMonth() + "/" + current.getYear() + " Strength: " + current.getStrength());
                        // Return the node if value matches the target
                    }
                }
            }
            current = current.getNext(); // Move to the next node
        }

    }

    // prints all tornadoes of the Strength
    public void printLocation(String target){
        Tornado current = head;
        Tornado temp = null;
        while (current != null) {
            if (Objects.equals(current.getName(), target)) {
                System.out.println("Location: " + current.getName() + " date: " +  current.getDay() + "/" + current.getMonth() + "/" + current.getYear() + " Strength: " + current.getStrength());
                // Return the node if value matches the target
            }
            current = current.getNext(); // Move to the next node
        }

    }

    // prints all tornadoes of the Location
    public void printStrength(int target){
        Tornado current = head;
        Tornado temp = null;
        while (current != null) {
            if (current.getStrength() == target) {
                System.out.println("Location: " + current.getName() + " date: " +  current.getDay() + "/" + current.getMonth() + "/" + current.getYear() + " Strength: " + current.getStrength());
                // Return the node if value matches the target
            }
            current = current.getNext(); // Move to the next node
        }

    }

    // prints all tornadoes
    public void printAll(){
        Tornado current = head;
        Tornado temp = null;
        while (current != null) {
            System.out.println("Location: " + current.getName() + " date: " +  current.getDay() + "/" + current.getMonth() + "/" + current.getYear() + " Strength: " + current.getStrength());
            current = current.getNext(); // Move to the next node
        }
    }
}
