import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainTests {
    
    @Test
    public void testrecordTornadoDetails() {
        // Test: recordTornado should create a Tornado record and
        // store the provided details. find(1) should return the
        // newly created Tornado with matching fields.
        SortedList sl = new SortedList();
        sl.recordTornado(5, 6, 2000, "TestCity", 4);
        Tornado t = sl.find(1);
        assertNotNull(t);
        assertEquals(5, t.getDay());
        assertEquals(6, t.getMonth());
        assertEquals(2000, t.getYear());
        assertEquals("TestCity", t.getName());
        assertEquals(4, t.getStrength());
    }

    @Test
    public void testprintAll() {
        // Test: printAll should print information for all stored
        // tornado records to System.out. Capture output and assert
        // it contains the expected location names.
        SortedList sl = new SortedList();
        sl.recordTornado(1, 1, 2000, "CityA", 2);
        sl.recordTornado(2, 2, 2001, "CityB", 3);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            sl.printAll();
            ps.flush();
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();
        assertTrue(out.contains("CityA"));
        assertTrue(out.contains("CityB"));
    }

    @Test
    public void testprintByDate() {
        // Test: printDate should only print tornadoes that exactly
        // match the provided day/month/year. Capture output and
        // assert that matching records appear and non-matching ones do not.
        SortedList sl = new SortedList();
        sl.recordTornado(10, 7, 2010, "X", 1);
        sl.recordTornado(11, 8, 2011, "Y", 2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            sl.printDate(10, 7, 2010);
            ps.flush();
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();
        assertTrue(out.contains("X"));
        assertFalse(out.contains("Y"));
    }

    @Test
    public void testprintByStrength() {
        // Test: printStrength should print tornadoes that match the
        // given strength value. Capture output and verify presence
        // and absence of expected records.
        SortedList sl = new SortedList();
        sl.recordTornado(3, 3, 2003, "A", 5);
        sl.recordTornado(4, 4, 2004, "B", 2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            sl.printStrength(5);
            ps.flush();
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();
        assertTrue(out.contains("A"));
        assertFalse(out.contains("B"));
    }

    @Test
    public void testprintByLocation() {
        // Test: printLocation should print only tornadoes from the
        // specified location. Capture output and assert correct filtering.
        SortedList sl = new SortedList();
        sl.recordTornado(7, 7, 2007, "Home", 1);
        sl.recordTornado(8, 8, 2008, "Away", 2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            sl.printLocation("Home");
            ps.flush();
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();
        assertTrue(out.contains("Home"));
        assertFalse(out.contains("Away"));
    }
    
    @Test
    public void tornadoLinkedList() {
        // Test: verify the sorted linked-list insertion order and
        // the correctness of next/previous pointers after inserts.
        SortedList sl = new SortedList();
        sl.insert(3);
        sl.insert(1);
        sl.insert(2);

        Tornado one = sl.find(1);
        Tornado two = sl.find(2);
        Tornado three = sl.find(3);

        assertNotNull(one);
        assertNotNull(two);
        assertNotNull(three);

        assertEquals(2, one.getNext().getID());
        assertEquals(1, two.getPrevious().getID());
        assertEquals(3, two.getNext().getID());
        assertEquals(2, three.getPrevious().getID());
    }

    @Test
    public void recordTornadoAddsToLinkedList() {
        // Test: recordTornado should increase list size and add a
        // node accessible via find(id).
        SortedList sl = new SortedList();
        assertEquals(0, sl.getSize());
        sl.recordTornado(9, 9, 1999, "Z", 3);
        assertEquals(1, sl.getSize());
        assertNotNull(sl.find(1));
    }

    @Test
    public void getDateReceivesValidDate() {
        // Test: UserInterface.getDate should parse valid numeric
        // input from a Scanner and return [day, month, year].
        UserInterface ui = new UserInterface();
        Scanner sc = new Scanner("2000\n6\n5\n");
        int[] date = ui.getDate(sc, false);
        assertNotNull(date);
        assertEquals(5, date[0]);
        assertEquals(6, date[1]);
        assertEquals(2000, date[2]);
    }
}
