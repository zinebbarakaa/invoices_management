package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.response.FactureResponse;

public interface FactureService extends  CrudService<FactureRequest, FactureResponse, Facture,Long> {
}
