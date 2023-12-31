package com.fsts.gestion_factures.model.response;

import com.fsts.gestion_factures.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitResponse {
    private Double prix;
    private String nomProduit;
    private String description;
    private Double stockQuantite;
    private String type;
    private User fournisseur;
}
