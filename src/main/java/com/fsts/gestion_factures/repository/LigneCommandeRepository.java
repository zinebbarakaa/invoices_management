package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
