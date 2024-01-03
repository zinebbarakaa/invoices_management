package com.fsts.gestion_factures;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.HistoriqueFacture;
import com.fsts.gestion_factures.repository.FactureRepository;
import com.fsts.gestion_factures.utilities.DatabaseUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class GestionFacturesApplication implements CommandLineRunner {
	private final DatabaseUtility databaseUtility;
	private final FactureRepository factureRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionFacturesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		databaseUtility.initDatabase();
//		yourMethod();
	}
//	@Transactional
//	public void yourMethod() {
//		Optional<Facture> facture = factureRepository.findById(2L);
//		List<HistoriqueFacture> historiqueFactures = facture.get().getHistorique();
//		System.out.println(historiqueFactures);
//	}
}
