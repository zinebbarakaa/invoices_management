package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
