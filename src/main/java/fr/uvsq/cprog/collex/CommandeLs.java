package fr.uvsq.cprog.collex;

import java.util.*;
import java.util.stream.Collectors;

public class CommandeLs implements Commande {
    private final Dns dns;
    private final String domaine;

    public CommandeLs(Dns dns, String domaine) {
        this.dns = dns;
        this.domaine = domaine;
    }

    @Override
    public String execute() {
        List<DnsItem> items = dns.getItems(domaine);
        return items.stream()
                .map(item -> item.toString())
                .sorted()
                .collect(Collectors.joining("\n"));
    }
}
