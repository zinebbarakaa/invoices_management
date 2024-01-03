package com.fsts.gestion_factures.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommande;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCommande")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    private int quantite;
}
