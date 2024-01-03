package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.HistoriqueFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueFactureRepository extends JpaRepository<HistoriqueFacture,Long> {
}
