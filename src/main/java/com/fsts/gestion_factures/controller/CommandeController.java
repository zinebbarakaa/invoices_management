package com.fsts.gestion_factures.controller;

import com.fsts.gestion_factures.model.request.CommandeRequest;
import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.CommandeResponse;
import com.fsts.gestion_factures.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commandes")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping("/add")
    public ResponseEntity<CommandeResponse> addCommande(@RequestBody CommandeRequest request) {
        CommandeResponse response = commandeService.add(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CommandeResponse>> getAllCommandes() {
        List<CommandeResponse> responses = commandeService.get();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CommandeResponse> getCommandeById(@PathVariable Long id) {
        CommandeResponse response = commandeService.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CommandeResponse> updateCommande(@PathVariable Long id, @RequestBody CommandeRequest request) {
        CommandeResponse response = commandeService.update(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/add-lignes-commande")
    public ResponseEntity<Void> addLigneCommandeToCommande(@PathVariable Long id, @RequestBody LigneCommandeRequest ligneCommandeRequest) {
        commandeService.addLigneCommandeToCommande(id, ligneCommandeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Void> confirmCommande(@PathVariable Long id) {
        commandeService.confirmCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/total-amount")
    public ResponseEntity<Double> calculateTotalAmount(@PathVariable Long id) {
         commandeService.updateTotalAmount(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
