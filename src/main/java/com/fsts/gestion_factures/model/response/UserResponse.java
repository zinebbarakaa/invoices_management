package com.fsts.gestion_factures.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tel;
}
