package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {
    private final Scanner scanner = new Scanner(System.in);
    private final Dns dns;

    public DnsTUI(Dns dns) {
        this.dns = dns;
    }

    public Commande nextCommande() {
        System.out.print("Entrez une commande : ");
        String saisie = scanner.nextLine();
        String[] parts = saisie.split("\\s+");

        switch (parts[0]) {
            case "getIp":
                // Conversion String -> NomMachine
                NomMachine nomMachine = new NomMachine(parts[1]);
                return new CommandeGetIp(dns, nomMachine);

            case "getNom":
                // Conversion String -> AdresseIP
                AdresseIP ip = new AdresseIP(parts[1]);
                return new CommandeGetNom(dns, ip);

            case "addItem":
                AdresseIP nouvelleIp = new AdresseIP(parts[1]);
                NomMachine nouveauNom = new NomMachine(parts[2]);
                return new CommandeAdd(dns, nouvelleIp, nouveauNom);

            case "quit":
                return new CommandeQuit();

            default:
                throw new IllegalArgumentException("Commande inconnue : " + saisie);

        }
    }

    public void affiche(String message) {
        System.out.println(message);
    }
}
