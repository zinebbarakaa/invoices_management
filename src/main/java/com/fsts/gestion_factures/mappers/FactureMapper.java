package com.fsts.gestion_factures.mappers;

import com.fsts.gestion_factures.entities.Facture;
import com.fsts.gestion_factures.entities.HistoriqueFacture;
import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.response.FactureResponse;
import com.fsts.gestion_factures.model.response.HistoriqueFactureResponse;
import com.fsts.gestion_factures.model.response.PaiementResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface FactureMapper extends ApplicationMapper<FactureRequest, FactureResponse, Facture>{
    FactureMapper INSTANCE = Mappers.getMapper(FactureMapper.class);
    FactureResponse entityToResponse(Facture facture);

    // Other mapping methods...

    default List<HistoriqueFactureResponse> historiqueToResponseList(List<HistoriqueFacture> historique) {
        return historique.stream()
                .map(HistoriqueFactureMapper.INSTANCE::entityToResponse)
                .collect(Collectors.toList());
    }

    default List<PaiementResponse> paiementsToResponseList(List<Paiement> paiements) {
        return paiements.stream()
                .map(PaiementMapper.INSTANCE::entityToResponse)
                .collect(Collectors.toList());
    }

}
