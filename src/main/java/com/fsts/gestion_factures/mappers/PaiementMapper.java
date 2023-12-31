package com.fsts.gestion_factures.mappers;

import com.fsts.gestion_factures.entities.Paiement;
import com.fsts.gestion_factures.model.request.PaiementRequest;
import com.fsts.gestion_factures.model.response.PaiementResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PaiementMapper extends ApplicationMapper<PaiementRequest, PaiementResponse, Paiement>{
    PaiementMapper INSTANCE = Mappers.getMapper(PaiementMapper.class);

}
