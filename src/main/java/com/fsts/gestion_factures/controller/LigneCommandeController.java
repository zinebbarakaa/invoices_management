package com.fsts.gestion_factures.controller;

import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.LigneCommandeResponse;
import com.fsts.gestion_factures.model.response.SuccessResponse;
import com.fsts.gestion_factures.service.LigneCommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LigneCommandeController {
     private final LigneCommandeService ligneCommandeService;

     @PostMapping("/add-ligne-commande")
    public ResponseEntity<LigneCommandeResponse> addLigneCommande(@RequestBody LigneCommandeRequest request){
         return  new ResponseEntity<>(ligneCommandeService.add(request), HttpStatus.CREATED);
     }
    @GetMapping("/get-all-ligne-commande")
    public  ResponseEntity<List<LigneCommandeResponse>> getAllLigneCommande(){
        return  new ResponseEntity<>(ligneCommandeService.get(),HttpStatus.OK);
    }
    @GetMapping("/get-one/{id}")
    public ResponseEntity<LigneCommandeResponse> getUser(@PathVariable Long id){
        return new ResponseEntity<>(ligneCommandeService.get(id),HttpStatus.OK);
    }

    @PutMapping("update-ligne-commande/{id}")
    public ResponseEntity<LigneCommandeResponse> updateLigneCommande(@RequestBody LigneCommandeRequest request, @PathVariable Long id){
        return  new ResponseEntity<>(ligneCommandeService.update(request,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteLigneCommande(@PathVariable Long id){
        ligneCommandeService.delete(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .message("Ligne de commande  deleted successfully")
                .build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

}
