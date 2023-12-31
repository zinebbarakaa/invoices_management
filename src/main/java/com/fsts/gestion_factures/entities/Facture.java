package com.fsts.gestion_factures.entities;

import com.fsts.gestion_factures.enums.EtatFacture;
import jakarta.persistence.*;
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
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private Date dateFacture;
    private Double montant;
    private EtatFacture etatFacture;

    @OneToOne(mappedBy = "facture")
    private Commande commande;
    @OneToMany(mappedBy = "facture")
    private List<Paiement> paiements;

}
