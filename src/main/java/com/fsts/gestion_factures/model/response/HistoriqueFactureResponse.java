package com.fsts.gestion_factures.model.response;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.enums.EtatFacture;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class HistoriqueFactureResponse {
    private Long idHistoriqueFacture;
    private Long referenceFacture;
    private Date DateModification;
    private Date dateFacture;
    private Double montant;
    private EtatFacture etatFacture;
    private Commande commande;
    private List<Paiement> paiements;
}
