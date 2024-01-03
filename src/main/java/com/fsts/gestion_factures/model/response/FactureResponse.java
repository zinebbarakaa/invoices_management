package com.fsts.gestion_factures.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.entities.HistoriqueFacture;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.enums.EtatFacture;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class FactureResponse {
    private Long idFacture;
    private Date dateFacture;
    private Double montant;
    private EtatFacture etatFacture;
    private CommandeResponse commande;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PaiementResponse> paiements;
    private List<HistoriqueFactureResponse> historiqueFactures;
}
