package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRpository extends JpaRepository<Produit,Long> {
}
