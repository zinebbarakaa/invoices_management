package com.fsts.gestion_factures.model.response;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.entities.Produit;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeResponse {

    private Commande commande;
    private Produit produit;
    private int quantite;
}
