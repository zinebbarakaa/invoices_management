package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.LigneCommande;
import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.LigneCommandeResponse;

public interface LigneCommandeService extends CrudService<LigneCommandeRequest, LigneCommandeResponse, LigneCommande,Long> {
}
