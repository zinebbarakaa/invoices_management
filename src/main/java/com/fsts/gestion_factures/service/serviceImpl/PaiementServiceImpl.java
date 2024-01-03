package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.exceptions.InvalidInputException;
import com.fsts.gestion_factures.exceptions.ResourceNotFoundException;
import com.fsts.gestion_factures.mappers.FactureMapper;
import com.fsts.gestion_factures.mappers.PaiementMapper;
import com.fsts.gestion_factures.model.request.PaiementRequest;
import com.fsts.gestion_factures.model.response.PaiementResponse;
import com.fsts.gestion_factures.repository.PaiementRepository;
import com.fsts.gestion_factures.service.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {
    private  final PaiementRepository paiementRepository;
    @Override
    public PaiementResponse add(PaiementRequest request) {
        Paiement paiement = PaiementMapper.INSTANCE.requestToEntity(request);
        if(paiement.getFacture().getMontant() > 5000.00 && paiement.getModePaiement().equals("espece")){
            throw new InvalidInputException("the paymmment should be with cheque ");
        }
        List<Paiement> paiementsFactures =  new ArrayList<>();
        paiementsFactures.add(paiement);
        paiement.getFacture().setPaiements(paiementsFactures);
        paiementRepository.save(paiement);
        return PaiementMapper.INSTANCE.entityToResponse(paiement);
    }

    @Override
    public List<PaiementResponse> get() {
        return FactureMapper.INSTANCE.paiementsToResponseList(paiementRepository.findAll());
    }

    @Override
    public PaiementResponse update(PaiementRequest request, Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("paiement", "id", id.toString()));
        paiement.setDatePaiement(request.getDatePaiement());
        paiement.setModePaiement(request.getModePaiement());
        paiement.setClient(request.getClient());
        paiement.setFacture(request.getFacture());
        paiement.setMontant(request.getMontant());
        paiement.setIntituleBanque(request.getIntituleBanque());
        paiement.setNumCheque(request.getNumCheque());
        paiement.setProprietaireCheque(request.getProprietaireCheque());
        paiementRepository.save(paiement);
        return PaiementMapper.INSTANCE.entityToResponse(paiement);
    }

    @Override
    public void delete(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("paiement", "id", id.toString()));
        paiementRepository.delete(paiement);
    }

    @Override
    public PaiementResponse get(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("paiement", "id", id.toString()));
        return PaiementMapper.INSTANCE.entityToResponse(paiement);
    }
}
