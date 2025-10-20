package fr.uvsq.cprog.collex;

import java.util.*;
import java.io.IOException;
import java.nio.file.*;

public class Dns {
    
    // Attributs
    private final Map<AdresseIP, DnsItem> ipMap = new HashMap<>();
    private final Map<NomMachine, DnsItem> nomMap = new HashMap<>();
    private final Path fichierBase;

    // Constructeur, lit toutes les lignes et crée les DnsItem
    public Dns(Path fichierBase) throws IOException {
        this.fichierBase = fichierBase;
        List<String> lignes = Files.readAllLines(fichierBase);

        for(String ligne : lignes) {
            if(ligne.trim().isEmpty()) continue; // on supprime les espaces début et fin
            String[] parts = ligne.split("\\s+"); // découpe la ligne en morceaux séparés par 1 ou plusieurs espaces
            if(parts.length != 2) continue; // si on a pas 2 elt (nom et IP) on ignore

            AdresseIP ip = new AdresseIP(parts[0]);
            NomMachine nom = new NomMachine(parts[1]);
            DnsItem item = new DnsItem(ip, nom);

            ipMap.put(ip, item);
            nomMap.put(nom, item);
        }
    }

    // retourne un item à partir d'une adresse IP
    public DnsItem getItem(AdresseIP ip) {
        return ipMap.get(ip);
    }

    // retourne un item à partir d'un NomMachine
    public DnsItem getItem(NomMachine nom) {
        return nomMap.get(nom);
    }

    // retourne tous les items(noms de machine) d'un domaine
    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> result = new ArrayList<>();
        for(DnsItem item : nomMap.values()) {
            if(item.getNomMachine().getDomaine().equals(domaine)) { // on compare le nom de domaine du nom de machine avec celui en param
                result.add(item);
            }
        }
        return result;
    }

    // ajoute un item dans la base, erreur si l'adresse ou nom existe déjà(doublons)
    public void addItem(AdresseIP ip, NomMachine nom) throws IllegalArgumentException, IOException {
        if(ipMap.containsKey(ip)) {
            throw new IllegalArgumentException("ERREUR : L'adresse IP existe déjà !");
        }
        if(nomMap.containsKey(nom)) {
            throw new IllegalArgumentException("ERREUR : Le nom de machine existe déjà !");
        }

        DnsItem item = new DnsItem(ip, nom);
        ipMap.put(ip,item);
        nomMap.put(nom, item);

        // Ajoute une nouvelle ligne avant d'écrire
        String ligne = "\n" + nom.toString() + " " + ip.toString();
        Files.write(fichierBase, ligne.getBytes(), StandardOpenOption.APPEND); // convertit la chaine en tab d'octets (car Files.write ecrit en otctet) et on ajoute la ligne à la fin sans remplacer tout (APPEND)
    }

}
