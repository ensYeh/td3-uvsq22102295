package fr.uvsq.cprog.collex;

public class CommandeAdd implements Commande {
    private final Dns dns;
    private final AdresseIP ip;
    private final NomMachine nom;

    public CommandeAdd(Dns dns, AdresseIP ip, NomMachine nom) {
        this.dns = dns;
        this.ip = ip;
        this.nom = nom;
    }

    @Override
    public String execute() {
        try {
            dns.addItem(ip, nom);
            return "Ajout effectué !";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
