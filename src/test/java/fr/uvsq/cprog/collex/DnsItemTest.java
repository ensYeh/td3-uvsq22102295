package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class DnsItemTest {

    @Test
    public void testDnsItemCreation() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        NomMachine nom = new NomMachine("www.uvsq.fr");
        DnsItem item = new DnsItem(ip, nom);

        assertEquals(ip, item.getAdresseIP());
        assertEquals(nom, item.getNomMachine());
    }

    @Test
    public void testToString() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        NomMachine nom = new NomMachine("www.uvsq.fr");
        DnsItem item = new DnsItem(ip, nom);

        assertEquals("192.168.0.1 www.uvsq.fr", item.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        AdresseIP ip1 = new AdresseIP("192.168.0.1");
        NomMachine nom1 = new NomMachine("www.uvsq.fr");
        DnsItem item1 = new DnsItem(ip1, nom1);

        AdresseIP ip2 = new AdresseIP("192.168.0.1");
        NomMachine nom2 = new NomMachine("www.uvsq.fr");
        DnsItem item2 = new DnsItem(ip2, nom2);

        AdresseIP ip3 = new AdresseIP("10.0.0.1");
        NomMachine nom3 = new NomMachine("test.domain.com");
        DnsItem item3 = new DnsItem(ip3, nom3);

        assertEquals(item1, item2);
        assertNotEquals(item1, item3);
        assertEquals(item1.hashCode(), item2.hashCode());
    }
}
