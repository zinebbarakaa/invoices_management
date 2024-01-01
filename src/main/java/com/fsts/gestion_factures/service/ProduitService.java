package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.Produit;
import com.fsts.gestion_factures.model.request.ProduitRequest;
import com.fsts.gestion_factures.model.response.ProduitResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProduitService extends CrudService<ProduitRequest, ProduitResponse, Produit,Long> {
}
