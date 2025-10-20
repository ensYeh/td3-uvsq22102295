package fr.uvsq.cprog.collex;

import java.util.*;
import java.util.stream.Collectors;

public class CommandeLs implements Commande {
    private final Dns dns;
    private final String domaine;
    private final boolean sortByIp;

    public CommandeLs(Dns dns, String domaine, boolean sortByIp) {
        this.dns = dns;
        this.domaine = domaine;
        this.sortByIp = sortByIp;
    }

    @Override
    public String execute() {
        // Cast explicite pour s'assurer que les éléments sont de type DnsItem
        List<DnsItem> items = new ArrayList<>(dns.getItems(domaine));

        // Trie les résultats en fonction de sortByIp
        if (sortByIp) {
            // Tri par adresse IP (numériquement)
            items.sort(Comparator.comparing(item -> item.getAdresseIP().toNumeric()));
        } else {
            // Tri par nom de machine (lexicographiquement)
            items.sort(Comparator.comparing(item -> item.getNomMachine().getNomComplet()));
        }

        return items.stream()
                .map(DnsItem::toString)
                .collect(Collectors.joining("\n"));
    }
}
