package fr.uvsq.cprog.collex;

import org.junit.Test;
import java.nio.file.*;
import java.util.List;

import static org.junit.Assert.*;

public class DnsTest {

    @Test
    public void testGetItemByIp() throws Exception {
        Path fichier = Paths.get("fichier_dns.txt");
        Dns dns = new Dns(fichier);

        AdresseIP ip = new AdresseIP("193.51.31.90");
        DnsItem item = dns.getItem(ip);

        assertNotNull(item);
        assertEquals("www.uvsq.fr", item.getNomMachine().toString());
    }

    @Test
    public void testGetItemByNom() throws Exception {
        Path fichier = Paths.get("fichier_dns.txt");
        Dns dns = new Dns(fichier);

        NomMachine nom = new NomMachine("www.uvsq.fr");
        DnsItem item = dns.getItem(nom);

        assertNotNull(item);
        assertEquals("193.51.31.90", item.getAdresseIP().toString());
    }

    @Test
    public void testGetItemsByDomaine() throws Exception {
        Path fichier = Paths.get("fichier_dns.txt");
        Dns dns = new Dns(fichier);

        List<DnsItem> items = dns.getItems("uvsq.fr");
        assertEquals(3, items.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemDuplicateIp() throws Exception {
        Path fichier = Paths.get("fichier_dns.txt");
        Dns dns = new Dns(fichier);

        AdresseIP ip = new AdresseIP("193.51.31.90");
        NomMachine nom = new NomMachine("new.uvsq.fr");
        dns.addItem(ip, nom);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemDuplicateNom() throws Exception {
        Path fichier = Paths.get("fichier_dns.txt");
        Dns dns = new Dns(fichier);

        AdresseIP ip = new AdresseIP("10.0.0.1");
        NomMachine nom = new NomMachine("www.uvsq.fr");
        dns.addItem(ip, nom);
    }
}