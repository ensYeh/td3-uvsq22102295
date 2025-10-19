package fr.uvsq.cprog.collex;

import java.util.Objects;

public class DnsItem {

    // Attributs
    private final AdresseIP adresseIP;
    private final NomMachine nomMachine;

    // Constructeur
    public DnsItem(AdresseIP ip, NomMachine m) {
        this.adresseIP = ip;
        this.nomMachine = m;
    }

    // Getters 
    public AdresseIP getAdresseIP() {
        return this.adresseIP;
    }

    public NomMachine getNomMachine() {
        return this.nomMachine;
    }

    // Méthodes 
    @Override
    public String toString() {
        return this.adresseIP + " " + this.nomMachine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnsItem)) return false;
        DnsItem other = (DnsItem) o;
        return adresseIP.equals(other.adresseIP) && nomMachine.equals(other.nomMachine);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(adresseIP, nomMachine);
    }
}
