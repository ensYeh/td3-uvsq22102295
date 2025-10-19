package fr.uvsq.cprog.collex;

public class CommandeGetNom implements Commande {
    private final Dns dns;
    private final AdresseIP ip;

    public CommandeGetNom(Dns dns, AdresseIP ip) {
        this.dns = dns;
        this.ip = ip;
    }

    @Override
    public String execute() {
        try {
            DnsItem item = dns.getItem(ip);
            return item.getNomMachine().toString();
        } catch (Exception e) {
            return "ERREUR : " + e.getMessage();
        }
    }
}
