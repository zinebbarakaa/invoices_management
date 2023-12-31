package com.fsts.gestion_factures;

import com.fsts.gestion_factures.utilities.DatabaseUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GestionFacturesApplication implements CommandLineRunner {
	private final DatabaseUtility databaseUtility;

	public static void main(String[] args) {
		SpringApplication.run(GestionFacturesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		databaseUtility.initDatabase();
	}
}
