package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.response.FactureResponse;
import com.fsts.gestion_factures.model.response.HistoriqueFactureResponse;

import java.util.List;

public interface FactureService extends  CrudService<FactureRequest, FactureResponse, Facture,Long> {
    public List<HistoriqueFactureResponse> getHistoriqueFacture(Long id) ;


    }