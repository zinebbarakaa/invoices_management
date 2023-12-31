package com.fsts.gestion_factures.enums;

public enum EtatCommande {
    PENDING("Commande en attente"),
    CONFIRMED("commande confirmee");

    private final String etat;
    EtatCommande(String etat){
        this.etat = etat;
    }
}
