package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.exceptions.ResourceNotFoundException;
import com.fsts.gestion_factures.mappers.FactureMapper;
import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.response.FactureResponse;
import com.fsts.gestion_factures.repository.FactureRepository;
import com.fsts.gestion_factures.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    private final FactureRepository factureRepository;
    @Override
    public FactureResponse add(FactureRequest request) {
        Facture facture = FactureMapper.INSTANCE.requestToEntity(request);
        factureRepository.save(facture);
        return FactureMapper.INSTANCE.entityToResponse(facture);
    }

    @Override
    public List<FactureResponse> get() {
        return FactureMapper.INSTANCE.listToResponseList(factureRepository.findAll());
    }

    @Override
    public FactureResponse update(FactureRequest request, Long id) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("facture", "id", id.toString()));
        Facture newFacture = new Facture();
        newFacture.setReference(facture.getIdFacture());
        newFacture.setDateFacture(facture.getDateFacture());
        newFacture.setMontant(facture.getMontant());
        newFacture.setEtatFacture(facture.getEtatFacture());
        newFacture.setCommande(facture.getCommande());
        newFacture.setPaiements(facture.getPaiements());
        factureRepository.save(newFacture);
        return FactureMapper.INSTANCE.entityToResponse(newFacture);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public FactureResponse get(Long id) {
        return FactureMapper.INSTANCE.entityToResponse(factureRepository.findById(id).get());
    }
}
