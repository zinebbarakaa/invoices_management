package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
