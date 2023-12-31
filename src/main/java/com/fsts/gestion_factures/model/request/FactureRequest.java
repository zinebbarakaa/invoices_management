package com.fsts.gestion_factures.model.request;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.enums.EtatFacture;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FactureRequest {
    private Long idFacture;
    private Date dateFacture;
    private Double montant;
    private EtatFacture etatFacture;
    private Commande commande;
    private List<Paiement> paiements;
}
