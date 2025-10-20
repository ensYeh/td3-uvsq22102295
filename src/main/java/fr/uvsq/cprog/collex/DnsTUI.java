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

        if (parts.length == 1) {
            if (AdresseIP.isValid(parts[0])) {
                AdresseIP ip = new AdresseIP(parts[0]);
                return new CommandeGetNom(dns, ip);
            } else if (NomMachine.isValid(parts[0])) {
                NomMachine nom = new NomMachine(parts[0]);
                return new CommandeGetIp(dns, nom);
            }
        }

        switch (parts[0]) {
            case "add":
                if (parts.length < 3) {
                    throw new IllegalArgumentException(
                            "Commande 'add' invalide. Format attendu : add <adresse IP> <nom de machine>");
                }
                AdresseIP nouvelleIp = new AdresseIP(parts[1]);
                NomMachine nouveauNom = new NomMachine(parts[2]);
                return new CommandeAdd(dns, nouvelleIp, nouveauNom);

            case "ls":
                if (parts.length < 2) {
                    throw new IllegalArgumentException("Commande 'ls' invalide. Format attendu : ls <domaine> ou ls -a <domaine>");
                }

                boolean sortByIp = false;
                String domaine;

                // Vérifie si l'option -a est présente
                if (parts[1].equals("-a")) {
                    if (parts.length < 3) {
                        throw new IllegalArgumentException(
                                "Commande 'ls' invalide. Format attendu : ls [-a] <domaine>");
                    }
                    sortByIp = true;
                    domaine = parts[2];
                } else {
                    domaine = parts[1];
                }

                // Retourne une commande personnalisée pour gérer le tri
                return new CommandeLs(dns, domaine, sortByIp);

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
