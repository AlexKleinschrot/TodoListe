import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;





public class TestListe {
   ToDoListe toDoListe = new ToDoListe();

    @Test
    void TestAddNull(){
        assertThrows(NullPointerException.class, () -> {
            toDoListe.add(null);
        });

    }


    @Test
    void TestAddToDo() {

        ToDo netzwerkfehler = new ToDo("Behebe Netzwerkfehler.", ToDo.Prioritaet.Medium);

        toDoListe.add(netzwerkfehler);
        assertTrue(toDoListe.get(0) == netzwerkfehler);
    }

    @Test
    void TestRemoveEmptyList(){
        ToDo wichtigerFehler = new ToDo("Fehler auf Produktionssystem.", ToDo.Prioritaet.High);
        assertThrows(RuntimeException.class, () -> {
            toDoListe.remove(wichtigerFehler);
        });

    }


    @Test
    void TestRemoveToDO() {
        ToDo netzwerkfehler = new ToDo("Behebe Netzwerkfehler.", ToDo.Prioritaet.Medium);
        toDoListe.add(netzwerkfehler);
        ToDo wichtigerFehler = new ToDo("Fehler auf Produktionssystem.", ToDo.Prioritaet.High);
        toDoListe.add(wichtigerFehler);
        assertFalse(toDoListe.isEmpty());
        assertTrue(toDoListe.size()==2);

        toDoListe.remove(netzwerkfehler);

        assertTrue(toDoListe.get(0)==wichtigerFehler);
        assertTrue(toDoListe.size()==1);

    }

    @Test
    void TestRemoveEinrückung() {
        ToDo netzwerkfehler = new ToDo("Behebe Netzwerkfehler.", ToDo.Prioritaet.Medium);
        toDoListe.add(netzwerkfehler);
        ToDo kabelVerlegen = new ToDo("Kabel verlegen.", ToDo.Prioritaet.Low);
        toDoListe.add(kabelVerlegen);
        toDoListe.remove(netzwerkfehler);

        assertTrue(toDoListe.get(0)== kabelVerlegen);
        toDoListe.remove(kabelVerlegen);
        assertTrue(toDoListe.isEmpty());
        assertTrue(toDoListe.size()==0);
    }
    @Test
    void TestAnzahlOffenerEinträgeLeereListe(){
        assertTrue(toDoListe.anzahlOffenerEintraege()== 0);
    }
    @Test
    void TestAnzahlOffenerEinträge(){
        ToDo netzwerkfehler = new ToDo("Behebe Netzwerkfehler.", ToDo.Prioritaet.Medium);
        ToDo kabelVerlegen = new ToDo("Kabel verlegen.", ToDo.Prioritaet.Low);
        ToDo wichtigerFehler = new ToDo("Fehler auf Produktionssystem.", ToDo.Prioritaet.High);
        toDoListe.add(wichtigerFehler);
        toDoListe.add(netzwerkfehler);
        toDoListe.add(kabelVerlegen);

        netzwerkfehler.setStatusinArbeit();
        kabelVerlegen.setStatusOffen();
        wichtigerFehler.setStatusBeendet();
        assertTrue(toDoListe.anzahlOffenerEintraege()== 1);

    }
    @Test
    void TestSpeicherundLadeListe(){
        assertThrows(org.opentest4j.AssertionFailedError.class, () -> {
        assertThrows(java.io.FileNotFoundException.class, () -> {
        assertThrows(java.io.IOException.class, () -> {
            ToDo netzwerkfehler = new ToDo("Behebe Netzwerkfehler.", ToDo.Prioritaet.Medium);
            ToDo kabelVerlegen = new ToDo("Kabel verlegen.", ToDo.Prioritaet.Low);
            ToDo wichtigerFehler = new ToDo("Fehler auf Produktionssystem.", ToDo.Prioritaet.High);
        toDoListe.add(wichtigerFehler);
        toDoListe.add(netzwerkfehler);
        toDoListe.add(kabelVerlegen);
        toDoListe.speicherListeInDatei();

        ToDoListe neueToDoListe = new ToDoListe();


        neueToDoListe.liesToDoListeAusDatei();


        assertFalse(neueToDoListe.isEmpty());
        assertTrue(neueToDoListe.size()==3);

        assertEquals(wichtigerFehler.getName(),neueToDoListe.get(0).getName());
        assertEquals(netzwerkfehler.getName(),neueToDoListe.get(1).getName());
        assertEquals(kabelVerlegen.getName(),neueToDoListe.get(2).getName());
        assertEquals(wichtigerFehler.getPrioritaet(),neueToDoListe.get(0).getPrioritaet());
        assertEquals(netzwerkfehler.getPrioritaet(),neueToDoListe.get(1).getPrioritaet());
        assertEquals(kabelVerlegen.getPrioritaet(),neueToDoListe.get(2).getPrioritaet());
        });
        });
        });

    }
    @Test
    void TestListeSortieren(){
        ToDo netzwerkfehler = new ToDo("Netzwerkfehler.", ToDo.Prioritaet.Medium);
        ToDo wichtigerFehler = new ToDo("Fehler auf Produktiossystem.", ToDo.Prioritaet.High);
        ToDo kabelVerlegen = new ToDo("Kabel verlegen.", ToDo.Prioritaet.Low);

        toDoListe.add(netzwerkfehler);
        toDoListe.add(wichtigerFehler);
        toDoListe.add(kabelVerlegen);
        toDoListe.sort();


        assertEquals(toDoListe.get(0), wichtigerFehler);
        assertEquals(toDoListe.get(1), netzwerkfehler);
        assertEquals(toDoListe.get(2), kabelVerlegen);

    }



}
