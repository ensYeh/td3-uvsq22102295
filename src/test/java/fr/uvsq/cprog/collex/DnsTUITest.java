package fr.uvsq.cprog.collex;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.*;
import static org.junit.Assert.*;

public class DnsTUITest {

    @Test
    public void testNextCommandeGetNom() throws Exception {
        Path fichier = Paths.get("fichier_dns.txt");
        Dns dns = new Dns(fichier);

        // Simule une entrée utilisateur
        String simulatedInput = "193.51.31.90\nquit\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        DnsTUI tui = new DnsTUI(dns);

        // Teste la commande "getNom"
        Commande cmd = tui.nextCommande();
        assertNotNull(cmd);
        assertTrue(cmd instanceof CommandeGetNom);

        // Teste la commande "quit"
        cmd = tui.nextCommande();
        assertNotNull(cmd);
        assertTrue(cmd instanceof CommandeQuit);
    }

    
}