package fr.uvsq.cprog.collex;

public class CommandeGetIp implements Commande {

    private final Dns dns;
    private final NomMachine nomMachine;

    public CommandeGetIp(Dns dns, NomMachine nomMachine) {
        this.dns = dns;
        this.nomMachine = nomMachine;
    }

    @Override
    public String execute() {
        try {
            DnsItem item = dns.getItem(nomMachine);
            return item.getAdresseIP().toString();
        } catch (Exception e ) {
            return "ERREUR : " + e.getMessage();
        }
    }
    
}
