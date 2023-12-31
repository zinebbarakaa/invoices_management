package com.fsts.gestion_factures.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private Long idUser;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tel;
}
