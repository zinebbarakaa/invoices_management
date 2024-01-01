package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.LigneCommande;
import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.exceptions.ResourceNotFoundException;
import com.fsts.gestion_factures.mappers.LigneCommandeMapper;
import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.LigneCommandeResponse;
import com.fsts.gestion_factures.repository.LigneCommandeRepository;
import com.fsts.gestion_factures.service.LigneCommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LigneCommandeServiceImpl implements LigneCommandeService {
     private  final LigneCommandeRepository ligneCommandeRepository;
    @Override
    public LigneCommandeResponse add(LigneCommandeRequest request) {

        LigneCommande ligneCommande = LigneCommandeMapper.INSTANCE.requestToEntity(request);
        ligneCommande.setProduit(request.getProduit());
        ligneCommandeRepository.save(ligneCommande);
        return LigneCommandeMapper.INSTANCE.entityToResponse(ligneCommande);
    }

    @Override
    public List<LigneCommandeResponse> get() {
        return LigneCommandeMapper.INSTANCE.listToResponseList(ligneCommandeRepository.findAll());
    }

    @Override
    public LigneCommandeResponse update(LigneCommandeRequest request, Long id) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ligneCommande", "id", id.toString()));
        ligneCommande.setProduit(request.getProduit());
        ligneCommande.setQuantite(request.getQuantite());
        ligneCommandeRepository.save(ligneCommande);
        return LigneCommandeMapper.INSTANCE.entityToResponse(ligneCommande);
    }

    @Override
    public void delete(Long id) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ligneCommande", "id", id.toString()));
        ligneCommandeRepository.delete(ligneCommande);
    }

    @Override
    public LigneCommandeResponse get(Long id) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ligneCommande", "id", id.toString()));
        return LigneCommandeMapper.INSTANCE.entityToResponse(ligneCommande);
    }
}
