package com.fsts.gestion_factures.model.request;

import com.fsts.gestion_factures.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitRequest {

    private Long idProduit;
    private Double prix;
    private String nomProduit;
    private String description;
    private Double stockQuantite;
    private String type;
    private User fournisseur;
}
