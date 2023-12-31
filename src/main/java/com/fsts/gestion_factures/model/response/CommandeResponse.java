package com.fsts.gestion_factures.model.response;

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

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CommandeResponse {
    private Date dateCommande;
    private Double montant;
    private EtatCommande etatCommande;
    @OneToOne
    private Facture facture;
    @OneToMany(mappedBy = "ligneCommande")
    private List<LigneCommande> produits;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User client;

}
