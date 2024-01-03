package com.fsts.gestion_factures.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    private Double montant;
    private Date datePaiement;
    private String modePaiement;
    private String intituleBanque;
    private String numCheque;
    private String proprietaireCheque;
    @ManyToOne
    @JoinColumn(name = "idFacture")
    @JsonBackReference
    private Facture facture;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User client;

}
