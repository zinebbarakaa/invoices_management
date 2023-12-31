package com.fsts.gestion_factures.model.response;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PaiementResponse {


    private Double montant;
    private Date datePaiement;
    private String modePaiement;
    private String intituleBanque;
    private String numCheque;
    private String proprietaireCheque;
    private Facture facture;
    private User client;
}
