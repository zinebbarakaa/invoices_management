package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.Produit;
import com.fsts.gestion_factures.exceptions.ResourceNotFoundException;
import com.fsts.gestion_factures.mappers.ProduitMapper;
import com.fsts.gestion_factures.model.request.ProduitRequest;
import com.fsts.gestion_factures.model.response.ProduitResponse;
import com.fsts.gestion_factures.repository.ProduitRepository;
import com.fsts.gestion_factures.service.ProduitService;

import java.util.List;

public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public ProduitResponse add(ProduitRequest request) {
        Produit produit = ProduitMapper.INSTANCE.requestToEntity(request);
        produitRepository.save(produit);
        return ProduitMapper.INSTANCE.entityToResponse(produit);
    }
    @Override
    public List<ProduitResponse> get() {
        List<Produit> produits = produitRepository.findAll();
        return ProduitMapper.INSTANCE.listToResponseList(produits);
    }
    @Override
    public ProduitResponse update(ProduitRequest request, Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("produit", "id", id.toString()));
        // Update entity
        ProduitMapper.INSTANCE.updateEntityFromRequest(request, produit);
        // Save changes
        produitRepository.save(produit);
        // Prepare and return the response
        return ProduitMapper.INSTANCE.entityToResponse(produit);
    }

    @Override
    public void delete(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("produit", "id", id.toString()));

        produitRepository.delete(produit);
    }

    @Override
    public ProduitResponse get(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("produit", "id", id.toString()));

        return ProduitMapper.INSTANCE.entityToResponse(produit);
    }
}
