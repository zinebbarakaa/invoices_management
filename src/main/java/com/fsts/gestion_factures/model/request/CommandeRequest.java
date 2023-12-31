package com.fsts.gestion_factures.model.request;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.LigneCommande;
import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.enums.EtatCommande;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CommandeRequest {
    private Long idCommande;
    private Date dateCommande;
    private Double montant;
    private EtatCommande etatCommande;
    private Facture facture;
    private List<LigneCommande> produits;
    private User client;

}
