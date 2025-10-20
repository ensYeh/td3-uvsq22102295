package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdresseIPTest {

    @Test
    public void testValidAdresseIP() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        assertEquals("192.168.0.1", ip.getIp());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAdresseIP() {
        new AdresseIP("999.999.999.999");
    }

    @Test
    public void testToString() {
        AdresseIP ip = new AdresseIP("10.0.0.1");
        assertEquals("10.0.0.1", ip.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        AdresseIP ip1 = new AdresseIP("192.168.1.1");
        AdresseIP ip2 = new AdresseIP("192.168.1.1");
        AdresseIP ip3 = new AdresseIP("10.0.0.1");

        assertEquals(ip1, ip2);
        assertNotEquals(ip1, ip3);
        assertEquals(ip1.hashCode(), ip2.hashCode());
    }

    @Test
    public void testToNumeric() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        assertEquals(3232235521L, ip.toNumeric());
    }
}
