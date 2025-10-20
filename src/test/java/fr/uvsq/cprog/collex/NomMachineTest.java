package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class NomMachineTest {

    @Test
    public void testValidNomMachine() {
        NomMachine nom = new NomMachine("www.uvsq.fr");
        assertEquals("www", nom.getNom());
        assertEquals("uvsq.fr", nom.getDomaine());
        assertEquals("www.uvsq.fr", nom.getNomComplet());
    }

    @Test
    public void testToString() {
        NomMachine nom = new NomMachine("test.domain.com");
        assertEquals("test.domain.com", nom.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        NomMachine nom1 = new NomMachine("www.uvsq.fr");
        NomMachine nom2 = new NomMachine("www.uvsq.fr");
        NomMachine nom3 = new NomMachine("test.domain.com");

        assertEquals(nom1, nom2);
        assertNotEquals(nom1, nom3);
        assertEquals(nom1.hashCode(), nom2.hashCode());
    }

    @Test
    public void testIsValid() {
        assertTrue(NomMachine.isValid("www.uvsq.fr"));
        assertFalse(NomMachine.isValid("invalid_domain"));
        assertFalse(NomMachine.isValid(""));
    }
}
