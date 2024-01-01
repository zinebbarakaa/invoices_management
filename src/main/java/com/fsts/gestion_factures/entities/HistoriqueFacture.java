package com.fsts.gestion_factures.entities;

import com.fsts.gestion_factures.enums.EtatFacture;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriqueFacture;
    private Long referenceFacture;
    private Date DateModification;
    private Date dateFacture;
    private Double montant;
    private EtatFacture etatFacture;
    private Commande commande;
    private List<Paiement> paiements;
    @ManyToOne
    @JoinColumn(name = "facture_precedente_id")
    private Facture facturePrecedente;
    @OneToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
