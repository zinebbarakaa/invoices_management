package com.fsts.gestion_factures.model.request;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class PaiementRequest {
    private Long idPaiement;
    private Double montant;
    private Date datePaiement;
    private String modePaiement;
    private String intituleBanque;
    private String numCheque;
    private String proprietaireCheque;

    private Facture facture;

    private User client;
}
