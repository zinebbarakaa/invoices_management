package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.model.request.CommandeRequest;
import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.CommandeResponse;

import java.util.List;

public interface CommandeService extends CrudService<CommandeRequest, CommandeResponse, Commande,Long> {
     void addLignesCommandeToCommande(Long idCommande, List<LigneCommandeRequest> ligneCommandeRequest) ;
     void confirmCommande(Long idCommande) ;
     double getTotalAmount(Long idCommande) ;

    }
