package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.model.request.PaiementRequest;
import com.fsts.gestion_factures.model.response.PaiementResponse;

public interface PaiementService extends CrudService<PaiementRequest, PaiementResponse, Paiement,Long> {
}
