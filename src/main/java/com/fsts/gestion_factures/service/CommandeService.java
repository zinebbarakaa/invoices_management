package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.model.request.CommandeRequest;
import com.fsts.gestion_factures.model.response.CommandeResponse;

public interface CommandeService extends CrudService<CommandeRequest, CommandeResponse, Commande,Long> {
}
