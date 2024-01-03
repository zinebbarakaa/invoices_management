package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.HistoriqueFacture;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.exceptions.ResourceNotFoundException;
import com.fsts.gestion_factures.mappers.FactureMapper;
import com.fsts.gestion_factures.mappers.HistoriqueFactureMapper;
import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.response.FactureResponse;
import com.fsts.gestion_factures.model.response.HistoriqueFactureResponse;
import com.fsts.gestion_factures.repository.CommandeRepository;
import com.fsts.gestion_factures.repository.FactureRepository;
import com.fsts.gestion_factures.repository.HistoriqueFactureRepository;
import com.fsts.gestion_factures.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    private final FactureRepository factureRepository;
    private final HistoriqueFactureRepository historiqueFactureRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public FactureResponse add(FactureRequest request) {
        Facture facture = FactureMapper.INSTANCE.requestToEntity(request);
        factureRepository.save(facture);
        return FactureMapper.INSTANCE.entityToResponse(facture);
    }

    @Override
    public List<FactureResponse> get() {
        List<Facture> factureResponses = factureRepository.findAll()
                .stream()
                .map(facture -> {
                    facture.setPaiements(facture.getPaiements().stream().toList());
                    return facture;
                })
                .collect(Collectors.toList());

        return FactureMapper.INSTANCE.listToResponseList(factureResponses);

    }

    //    @Override
//    public FactureResponse update(FactureRequest request, Long id) {
//        Facture facture = factureRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("facture", "id", id.toString()));
//        // Create a historical record for the old Facture
//        HistoriqueFacture oldFacture = HistoriqueFacture.builder()
//                .referenceFacture(id)
//                .DateModification(new Date())
//                .montant(facture.getMontant())
//                .etatFacture(facture.getEtatFacture())
//                .dateFacture(facture.getDateFacture())
//                .facturePrecedente(facture)
//                .build();
//        historiqueFactureRepository.save(oldFacture);
//
//        List<Paiement> newPaiements = facture.getPaiements().stream()
//                .map(paiement -> Paiement.builder()
//                        .montant(paiement.getMontant())
//                        .datePaiement(paiement.getDatePaiement())
//                        .numCheque(paiement.getNumCheque())
//                        .build())
//                .collect(Collectors.toList());
//        List<HistoriqueFacture> historiqueFactures = facture.getHistorique().stream()
//                .map(historiqueFacture -> HistoriqueFacture.builder()
//                        .etatFacture(historiqueFacture.getEtatFacture())
//                        .dateFacture(historiqueFacture.getDateFacture())
//                        .facturePrecedente(historiqueFacture.getFacturePrecedente())
//                        .DateModification(historiqueFacture.getDateModification())
//                        .montant(historiqueFacture.getMontant()) .build())
//                        .collect(Collectors.toList());
////        List<HistoriqueFacture> historiqueFactures =  facture.getHistorique();
//        historiqueFactures.add(oldFacture);
//        // Create a new version of the Facture
////        Optional<Commande> commande = commandeRepository.findById(request.getCommande_id());
//        Facture newFacture = Facture.builder()
//                .reference(request.getIdFacture())
//                .dateFacture(request.getDateFacture())
//                .montant(request.getMontant())
//                .etatFacture(request.getEtatFacture())
////                .commande(commande.get())
//                .paiements(newPaiements)
//                .historique(historiqueFactures)
//                .build();
//
//        factureRepository.save(newFacture);
//
//        return FactureMapper.INSTANCE.entityToResponse(newFacture);
//    }
    @Override
    public FactureResponse update(FactureRequest request, Long id) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("facture", "id", id.toString()));
        // Create a historical record for the old Facture
        HistoriqueFacture oldFacture = HistoriqueFacture.builder()
                .referenceFacture(id)
                .DateModification(new Date())
                .montant(facture.getMontant())
                .etatFacture(facture.getEtatFacture())
                .dateFacture(facture.getDateFacture())
                .facturePrecedente(facture)
                .build();
        historiqueFactureRepository.save(oldFacture);

        List<Paiement> newPaiements = facture.getPaiements().stream()
                .map(paiement -> Paiement.builder()
                        .montant(paiement.getMontant())
                        .datePaiement(paiement.getDatePaiement())
                        .numCheque(paiement.getNumCheque())
                        .build())
                .collect(Collectors.toList());

        // Create a new set of historical records for the new Facture
        List<HistoriqueFacture> historiqueFactures = facture.getHistorique().stream()
                .map(historiqueFacture -> HistoriqueFacture.builder()
                        .referenceFacture(historiqueFacture.getReferenceFacture())
                        .etatFacture(historiqueFacture.getEtatFacture())
                        .dateFacture(historiqueFacture.getDateFacture())
                        .facturePrecedente(historiqueFacture.getFacturePrecedente())
                        .DateModification(historiqueFacture.getDateModification())
                        .montant(historiqueFacture.getMontant())
                        .build())
                .collect(Collectors.toList());

        historiqueFactures.add(oldFacture);

        // Create a new version of the Facture
        Facture newFacture = Facture.builder()
                .dateFacture(request.getDateFacture())
                .montant(request.getMontant())
                .etatFacture(request.getEtatFacture())
                .paiements(newPaiements)
                .historique(historiqueFactures) // Set the new set of historical records
                .build();
        factureRepository.save(newFacture);
        return FactureMapper.INSTANCE.entityToResponse(newFacture);
    }

    @Override
    public void delete(Long aLong) {

    }

    public List<HistoriqueFactureResponse> getHistoriqueFacture(Long id) {
        // Fetch the Facture entity with the given id
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("facture", "id", id.toString()));

        // Access the historical records from the Facture entity
        List<HistoriqueFacture> historiqueFactures = facture.getHistorique();

        // Convert the historical records to the response DTOs
        List<HistoriqueFactureResponse> historiqueResponses = historiqueFactures.stream()
                .map(HistoriqueFactureMapper.INSTANCE::entityToResponse)
                .collect(Collectors.toList());
        return historiqueResponses;
    }


    @Override
    public FactureResponse get(Long id) {
        return FactureMapper.INSTANCE.entityToResponse(factureRepository.findById(id).get());
    }
}
