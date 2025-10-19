package fr.uvsq.cprog.collex;

public class CommandeQuit implements Commande {
    @Override
    public String execute() {
        System.exit(0);
        return ""; // jamais atteint
    }
}
