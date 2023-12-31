package com.fsts.gestion_factures.entities;

import com.fsts.gestion_factures.enums.EtatCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Date dateCommande;
    private Double montant;
    private EtatCommande etatCommande;
    @OneToOne
    private Facture facture;
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommande> produits= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User client;

}
