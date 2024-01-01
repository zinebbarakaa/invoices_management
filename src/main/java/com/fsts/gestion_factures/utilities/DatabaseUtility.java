package com.fsts.gestion_factures.utilities;

import com.fsts.gestion_factures.entities.Produit;
import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.repository.ProduitRepository;
import com.fsts.gestion_factures.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class DatabaseUtility {




    private final UserRepository userRepository;
     private final ProduitRepository produitRepository;

    public void initDatabase() {
        Logger.getLogger("Database utility").info("Seeding database ...");
        initUser();
        initProduits();
        Logger.getLogger("Database utility").info("Database seeding complete");
    }





    public void initUser() {

//        Check table is empty
        if (userRepository.count() > 0) return;
        userRepository.deleteAll();

        User user = User.builder()
                .idUser(1L)
                .nom("zineb")
                .tel("09766534")
                .email("zineb@gmail.com")
                .build();
        userRepository.save(user);

    } public void initProduits() {

//        Check table is empty
        if (produitRepository.count() > 0) return;
        produitRepository.deleteAll();

        User fournisseur = User.builder()
                .nom("Doe")
                .prenom("John")
                .adresse("123 Rue de l'Exemple")
                .email("john.doe@example.com")
                .tel("123-456-7890").build();
        userRepository.save(fournisseur);

        Produit produit = Produit.builder()
                .nomProduit("Sample Product")
                .description("A sample product description")
                .prix(50.00)
                .stockQuantite(100)
                .type("Electronics")
                .fournisseur(fournisseur)
                .build();
        produitRepository.save(produit);

    }






}

