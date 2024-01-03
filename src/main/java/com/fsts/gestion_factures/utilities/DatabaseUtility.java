package com.fsts.gestion_factures.utilities;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.entities.Produit;
import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.enums.EtatCommande;
import com.fsts.gestion_factures.repository.CommandeRepository;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.repository.PaiementRepository;
import com.fsts.gestion_factures.repository.ProduitRepository;
import com.fsts.gestion_factures.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class DatabaseUtility {

    private final UserRepository userRepository;
     private final ProduitRepository produitRepository;
     private final CommandeRepository commandeRepository;
     private final PaiementRepository paiementRepository;

    public void initDatabase() {
        Logger.getLogger("Database utility").info("Seeding database ...");
        initUser();
        initProduits();
        initPaiement();
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
        User savedUser =userRepository.save(user);
            initCommande(savedUser);
    }
    public void initCommande(User user) {

//        Check table is empty
        if (commandeRepository.count() > 0) return;
        commandeRepository.deleteAll();
        Commande commande = Commande.builder()
                .idCommande(1L)
                .etatCommande(EtatCommande.PENDING)
                .dateCommande(new Date())
                .client(user)
                .build();
        commandeRepository.save(commande);

    }
    public void initProduits() {

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
public void initPaiement() {

//        Check table is empty
        if (paiementRepository.count() > 0) return;
        paiementRepository.deleteAll();

        User proprietaire = User.builder()
                .nom("Doe")
                .prenom("John")
                .adresse("123 Rue de l'Exemple")
                .email("john.doe@example.com")
                .tel("123-456-7890").build();
        userRepository.save(proprietaire);

    Paiement paiement = Paiement.builder()
            .idPaiement(1L)
            .numCheque("1111")
            .montant(500.00)
            .client(proprietaire)
            .build();
    paiementRepository.save(paiement);

    }






}

