package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.entities.LigneCommande;
import com.fsts.gestion_factures.enums.EtatCommande;
import com.fsts.gestion_factures.exceptions.InvalidInputException;
import com.fsts.gestion_factures.mappers.CommandeMapper;
import com.fsts.gestion_factures.mappers.LigneCommandeMapper;
import com.fsts.gestion_factures.model.request.CommandeRequest;
import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.CommandeResponse;
import com.fsts.gestion_factures.repository.CommandeRepository;
import com.fsts.gestion_factures.service.CommandeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;
    @Override
    @Transactional
    public CommandeResponse add(CommandeRequest request) {
        Commande nouvelleCommande = CommandeMapper.INSTANCE.requestToEntity(request);
        nouvelleCommande.setEtatCommande(EtatCommande.PENDING);
        updateTotalAmount(nouvelleCommande.getIdCommande());
        Commande savedCommande = commandeRepository.save(nouvelleCommande);
        return CommandeMapper.INSTANCE.entityToResponse(savedCommande);
    }

    @Override
    public List<CommandeResponse> get() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandes.stream()
                .map(CommandeMapper.INSTANCE::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CommandeResponse update(CommandeRequest request, Long idCommande) {
        Commande existingCommande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new EntityNotFoundException("Commande not found with ID: " + idCommande));
        CommandeMapper.INSTANCE.updateEntityFromRequest(request, existingCommande);

        Commande updatedCommande = commandeRepository.save(existingCommande);
        return CommandeMapper.INSTANCE.entityToResponse(updatedCommande);
    }

    @Override
    @Transactional
    public void delete(Long idCommande) {
        Commande existingCommande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new EntityNotFoundException("Commande not found with ID: " + idCommande));

        commandeRepository.delete(existingCommande);
    }

    @Override
    public CommandeResponse get(Long idCommande) {
        Optional<Commande> optionalCommande = commandeRepository.findById(idCommande);
        return optionalCommande.map(CommandeMapper.INSTANCE::entityToResponse).orElse(null);
    }

    @Override
    public void addLigneCommandeToCommande(Long idCommande, LigneCommandeRequest ligneCommandeRequest) {
        Commande commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new EntityNotFoundException("Commande not found with ID: " + idCommande));

        if (commande.getEtatCommande() != EtatCommande.PENDING) {
            throw new IllegalStateException("La commande ne peut pas recevoir de nouvelles lignes de commande car elle n'est pas en attente.");
        }

        if (ligneCommandeRequest.getQuantite() <= 0) {
            throw new InvalidInputException("La quantité du produit doit être supérieure à zéro.");
        }
        LigneCommande nouvelleLigneCommande = LigneCommandeMapper.INSTANCE.requestToEntity(ligneCommandeRequest);
        nouvelleLigneCommande.setCommande(commande);
        commande.getProduits().add(nouvelleLigneCommande);
        updateTotalAmount(commande.getIdCommande());
        commandeRepository.save(commande);
    }

    @Override
    public void confirmCommande(Long idCommande) {
        Commande commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new EntityNotFoundException("Commande not found with ID: " + idCommande));
        if (commande.getEtatCommande() != EtatCommande.PENDING) {
            throw new IllegalStateException("La commande ne peut pas être confirmée car elle n'est pas en attente.");
        }
        commande.setEtatCommande(EtatCommande.CONFIRMED);
        commandeRepository.save(commande);
    }

    @Transactional
    public void updateTotalAmount(Long idCommande) {
        Commande commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new EntityNotFoundException("Commande not found with ID: " + idCommande));

        double totalAmount = commande.getProduits().stream()
                .mapToDouble(ligneCommande -> ligneCommande.getProduit().getPrix() * ligneCommande.getQuantite())
                .sum();

        commande.setMontant(totalAmount);
        commandeRepository.save(commande);
    }

}
