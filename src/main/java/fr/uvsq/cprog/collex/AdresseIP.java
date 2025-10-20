package fr.uvsq.cprog.collex;

public class AdresseIP {

    // Attibut
    private final String ip;

    // Constructeur
    public AdresseIP(String ip) {
        if (!isValid(ip)) {
            throw new IllegalArgumentException("Adresse IP invalide : " + ip);
        }
        this.ip = ip;
    }

    // Méthode isValid()
    public static boolean isValid(String ip) {
        // Verifier que c'est bien une adresse IPv4 !
        String[] parts = ip.split("\\.");
        if (parts.length != 4)
            return false;
        for (String part : parts) {
            try {
                int n = Integer.parseInt(part);
                if (n < 0 || n > 255)
                    return false;
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
        if (this == o)
            return true;
        if (!(o instanceof AdresseIP))
            return false;
        AdresseIP other = (AdresseIP) o;
        return ip.equals(other.ip);
    }

    // Méthode hashCode()
    @Override
    public int hashCode() {
        return ip.hashCode();
    }

    // conrtit une adresse IP en une valeur numérique pour le tri (ls -a)
    public long toNumeric() {
        String[] parts = this.ip.split("\\.");
        return (Long.parseLong(parts[0]) << 24)
                | (Long.parseLong(parts[1]) << 16)
                | (Long.parseLong(parts[2]) << 8)
                | Long.parseLong(parts[3]);
    }
}
