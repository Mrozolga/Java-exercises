package CSVReader;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

public class CSVReaderTest {
//    @Test
//    public void get() throws Exception {
//        CSVReader reader2 = new CSVReader("with-header.csv", ";", true);
//        reader2.next();
//        assertEquals("2", reader2.get(4));
//    }
//
//    @Test
//    public void get1() throws Exception {
//        CSVReader reader2 = new CSVReader("with-header.csv", ";", true);
//        reader2.next();
//        assertEquals("Kowal", reader2.get("nazwisko"));
//    }

    @Test
    public void getInt() throws Exception {
    }

    @Test
    public void getInt1() throws Exception {
    }

    @Test
    public void getLong() throws Exception {
    }

    @Test
    public void getLong1() throws Exception {
    }

    @Test
    public void getDouble() throws Exception {
    }

    @Test
    public void getDouble1() throws Exception {
    }

    @org.junit.Test
    public void getColumnLabels() throws Exception {
        CSVReader reader2 = new CSVReader("with-header.csv", ";", true);
        List<String> wynik = new ArrayList<>();
        wynik.add("id");
        wynik.add("imi?");
        wynik.add("nazwisko");
        wynik.add("ulica");
        wynik.add("nrdomu");
        wynik.add("nrmieszkania");
        assertEquals(reader2.getColumnLabels(), wynik);
    }


    @org.junit.Test
    public void plik1() throws Exception {
        CSVReader reader2 = new CSVReader("with-header.csv", ";", true);
        while (reader2.next()) {
            int id = reader2.getInt(0);
            String name = reader2.get(1);
            String surname = reader2.get(2);
            String street = reader2.get(3);
            int num_house = reader2.getInt(4);
            int num_flat = reader2.getInt(5);
            System.out.printf(Locale.US, "%d %s %s %s %d %d \n", id, name, surname, street, num_house, num_flat);

        }


    }
}