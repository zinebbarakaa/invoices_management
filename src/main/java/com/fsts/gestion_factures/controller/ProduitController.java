package com.fsts.gestion_factures.controller;

import com.fsts.gestion_factures.model.request.ProduitRequest;
import com.fsts.gestion_factures.model.response.ProduitResponse;
import com.fsts.gestion_factures.model.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fsts.gestion_factures.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("api/v1/produit")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;
    @PostMapping("/add-produit")
    public ResponseEntity<ProduitResponse> add(@RequestBody ProduitRequest request) {
        return new ResponseEntity<>(produitService.add(request), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-produit")
    public ResponseEntity<List<ProduitResponse>> getAllProduit() {
        return new ResponseEntity<>(produitService.get(), HttpStatus.OK);
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<ProduitResponse> getProduit(@PathVariable Long id) {
        return new ResponseEntity<>(produitService.get(id), HttpStatus.OK);
    }

    @PutMapping("update-produit/{id}")
    public ResponseEntity<ProduitResponse> updateProduit(@RequestBody ProduitRequest request, @PathVariable Long id) {
        return new ResponseEntity<>(produitService.update(request, id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<SuccessResponse> deleteProduit(@PathVariable Long id) {
        produitService.delete(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .message("Produit deleted successfully")
                .build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }


}
