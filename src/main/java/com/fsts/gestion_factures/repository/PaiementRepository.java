package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
