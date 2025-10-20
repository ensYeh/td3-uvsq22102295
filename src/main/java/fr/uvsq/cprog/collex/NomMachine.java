package fr.uvsq.cprog.collex;

public class NomMachine {

    // Attributs
    private final String nomComplet;
    private final String nom;
    private final String domaine;

    // Constructeur
    public NomMachine(String nomComplet) {
        this.nomComplet = nomComplet;
        String[] parts = nomComplet.split("\\.", 2); // découpe la chaîne en 2 sur le 1er point
        this.nom = parts[0];
        this.domaine = parts.length > 1 ? parts[1] : ""; // on stocke si un domaine existe sinon chaîne vide
    }

    // Getters
    public String getNom() {
        return this.nom;
    }

    public String getDomaine() {
        return this.domaine;
    }

    public String getNomComplet() {
        return this.nomComplet;
    }

    // Méthodes 
    @Override
    public String toString() {
        return nomComplet;
    }

    public static boolean isValid(String string) {
        // Vérifie si la chaîne est non nulle et non vide
        if (string == null || string.isEmpty()) {
            return false;
        }

        // Vérifie si la chaîne contient un point pour séparer le nom et le domaine
        String[] parts = string.split("\\.", 2);
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false;
        }

        // Vérifie que la première partie (nom) est alphanumérique avec des tirets
        String nameRegex = "^[a-zA-Z0-9-]+$";
        if (!parts[0].matches(nameRegex)) {
            return false;
        }

        // Vérifie que la deuxième partie (domaine) est un domaine valide (peut contenir des points)
        String domainRegex = "^[a-zA-Z0-9.-]+$";
        return parts[1].matches(domainRegex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NomMachine)) return false;
        NomMachine other = (NomMachine) o;
        return nomComplet.equals(other.nomComplet);
    }

    @Override
    public int hashCode() {
        return nomComplet.hashCode();
    }

}