package com.fsts.gestion_factures.controller;

import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.request.PaiementRequest;
import com.fsts.gestion_factures.model.response.FactureResponse;
import com.fsts.gestion_factures.model.response.HistoriqueFactureResponse;
import com.fsts.gestion_factures.model.response.PaiementResponse;
import com.fsts.gestion_factures.model.response.SuccessResponse;
import com.fsts.gestion_factures.service.FactureService;
import com.fsts.gestion_factures.service.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paiement")
@RequiredArgsConstructor
public class PaimementController {
    private final PaiementService paiementService;
    @PostMapping("/add-paiement")
    public ResponseEntity<PaiementResponse> addPaiement(@RequestBody PaiementRequest request){
        return  new ResponseEntity<>(paiementService.add(request), HttpStatus.CREATED);
    }
    @GetMapping("/get-all-paiement")
    public  ResponseEntity<List<PaiementResponse>> getAllPaiement(){
        return  new ResponseEntity<>(paiementService.get(),HttpStatus.OK);
    }
    @GetMapping("/get-paiement/{id}")
    public ResponseEntity<PaiementResponse> getPaiment(@PathVariable Long id){
        return new ResponseEntity<>(paiementService.get(id),HttpStatus.OK);
    }

    @PutMapping("update-paiement/{id}")
    public ResponseEntity<PaiementResponse> updatePaiment(@RequestBody PaiementRequest request, @PathVariable Long id){
        return  new ResponseEntity<>(paiementService.update(request,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deletePaiment(@PathVariable Long id){
        paiementService.delete(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .message("Paiement  deleted successfully")
                .build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

}
