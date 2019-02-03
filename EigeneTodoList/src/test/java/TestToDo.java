
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;



public class TestToDo {
    ToDo todo = new ToDo("Checke Wissensdatenbank!", ToDo.Prioritaet.Medium);

    @Test
    void testType(){
        assertTrue(todo instanceof ToDo);
    }

    @Test
    void testGetName() {
        assertEquals("Checke Wissensdatenbank!",todo.getName());

    }
    @Test
    void testStatus(){

        assertEquals("Offen",todo.getStatus());
        todo.setStatusinArbeit();
        assertEquals("In Arbeit",todo.getStatus());
        todo.setStatusBeendet();
        assertEquals("Beendet",todo.getStatus());
        todo.setStatusOffen();
        assertEquals("Beendet",todo.getStatus());


    }



}
