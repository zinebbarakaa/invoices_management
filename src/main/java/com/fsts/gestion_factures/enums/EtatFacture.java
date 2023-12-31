package com.fsts.gestion_factures.enums;

import lombok.Data;


public enum EtatFacture {
    PAID("paid"),
    PARTIALLY_PAID("partially paid"),
    NOT_PAID("not paid");
     private final String etat;
    EtatFacture(String etat){
        this.etat = etat;
    }

}
