package com.fsts.gestion_factures.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fsts.gestion_factures.enums.EtatFacture;
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
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private Date dateFacture;
    private Double montant;
    private EtatFacture etatFacture;
    @OneToOne(mappedBy = "facture")
    private Commande commande;
    @OneToMany(mappedBy = "facture", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Paiement> paiements;
    @OneToMany(mappedBy = "facturePrecedente", fetch = FetchType.EAGER)
    private List<HistoriqueFacture> historique = new ArrayList<>();
}
