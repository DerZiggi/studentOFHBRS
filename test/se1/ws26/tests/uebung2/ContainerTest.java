package se1.ws26.tests.uebung2;

import org.hbrs.se1.ws26.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws26.exercises.uebung2.Container;
import org.hbrs.se1.ws26.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws26.exercises.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private Container container;
    private Member m1;
    private Member m2;

    @BeforeEach
    public void setup(){
        container = new Container();
        m1 = new ConcreteMember();
        m2 = new ConcreteMember();
    }

    @Test
    public void testAddMember() throws ContainerException {
        assertEquals(0, container.size());

        container.addMember(m1);
        assertEquals(1, container.size());

        ContainerException exception = assertThrows(ContainerException.class, () -> {
        container.addMember(m1);});
        assertEquals("Das Member-Objekt mit der ID " + m1.getID() + " ist bereits vorhanden!", exception.getMessage());
        assertEquals(1, container.size());
    }

    @Test
    public void testDeleteMember() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(2, container.size());

        assertEquals("Das Member-Objekt mit der ID " + m1.getID() + " wurde entfernt!", container.deleteMember(m1.getID()));
        assertEquals(1, container.size());

        assertEquals("Es konnte kein Member-Objekt mit der ID " + m1.getID() + " entfernt werden!", container.deleteMember(m1.getID()));
        assertEquals(1, container.size());

        assertEquals("Das Member-Objekt mit der ID " + m2.getID() + " wurde entfernt!", container.deleteMember(m2.getID()));
        assertEquals(0, container.size());
    }

    @Test
    public void testDump() throws ContainerException {
        container.dump();
        container.addMember(m1);
        container.addMember(m2);
        container.dump();

        /*
        erwartet ähnliche Ausgabe:
        Member (ID = 101 )
        Member (ID = 102 )
         */
    }
}
