package com.fsts.gestion_factures.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idProduit;
    private Double prix;
    private String nomProduit;
    private String description;
    private Double stockQuantite;
    private String type;
    @ManyToOne
    @JoinColumn(name ="idUser")
    private User fournisseur;

}
