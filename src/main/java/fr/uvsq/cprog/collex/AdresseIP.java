package fr.uvsq.cprog.collex;

import java.util.Objects;

public class AdresseIP {

    // Attibut
    private final String ip;

    // Constructeur
    public AdresseIP(String ip) {
        if(!isValid(ip)) {
            throw new IllegalArgumentException("Adresse IP invalide : " + ip);
        }
        this.ip = ip;
    }

    // Méthode isValid()
    private boolean isValid(String ip) {
        // Verifier que c'est bien une adresse IPv4 !
        String[] parts = ip.split("\\.");
        if(parts.length != 4) return false;
        for(String part : parts) {
            try {
                int n = Integer.parseInt(part);
                if(n < 0 || n > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    // Getter
    public String getIp() {
        return ip;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return ip;
    }

    // Méthode equals()
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof AdresseIP)) return false;
        AdresseIP adresseIP = (AdresseIP) o;
        return ip.equals(adresseIP.ip);
    }

    // Méthode hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

}
