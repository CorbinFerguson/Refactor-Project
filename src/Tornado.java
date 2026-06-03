/*
by zellar & Jitin Ponnam
*/
public class Tornado {

    private int ID;
    private Tornado next;
    private Tornado previous;

    private int Day;
    private int Month;
    private int Year;
    private int strength;
    private String location;


    //Constructer
    public Tornado(int ID) {
        this.ID = ID;
        this.next = null;
        this.previous = null;
    }

    public Tornado getNext() {
        return next;
    }
    public Tornado getPrevious() {
        return previous;
    }

    //Accessors
    public int getDay() {
        return Day;
    }
    public int getMonth() {
        return Month;
    }
    public int getYear() {
        return Year;
    }
    public String getName() {
        return location;
    }
    public int getStrength() {
        return strength;
    }
    public int getID() {
        return ID;
    }


    // Location Mutators
    public void setNext(Tornado next) {
        this.next = next;
    }
    public void setPrevious(Tornado previous) {
        this.previous = previous;
    }

    // Mutators
    public void setDay(int Day) {
        this.Day = Day;
    }
    public void setMonth(int Month) {
        this.Month = Month;
    }
    public void setYear(int Year) {
        this.Year = Year;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
