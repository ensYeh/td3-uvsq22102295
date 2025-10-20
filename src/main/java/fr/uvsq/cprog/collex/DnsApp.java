package fr.uvsq.cprog.collex;

import java.nio.file.*;

public class DnsApp {

    private final DnsTUI tui;
    private boolean running = true;

    public DnsApp(DnsTUI tui) {
        this.tui = tui;
    }

    public void run() {
        while (running) {

            // Récupère la prochaine commande depuis le TUI
            Commande cmd = tui.nextCommande();

            // Si la commande est celle pour quitter, on arrête la boucle
            if (cmd instanceof CommandeQuit) {
                running = false;
                tui.affiche("Au revoir !");
                continue;
            }

            // Exécute la commande et affiche le résultat
            String resultat = cmd.execute();
            tui.affiche(resultat);
        }
    }

    public static void main(String[] args) {
        try {
            Path fichier = Paths.get("fichier_dns.txt");
            Dns dns = new Dns(fichier);
            DnsTUI tui = new DnsTUI(dns);
            DnsApp app = new DnsApp(tui);
            app.run();
        } catch (Exception e) {
            System.err.println("Erreur au démarrage de l'application : " + e.getMessage());
        }
    }
}
