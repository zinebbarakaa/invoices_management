package com.fsts.gestion_factures.mappers;

import com.fsts.gestion_factures.entities.HistoriqueFacture;
import com.fsts.gestion_factures.model.request.HistoriqueFactureRequest;
import com.fsts.gestion_factures.model.response.HistoriqueFactureResponse;
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
public interface HistoriqueFactureMapper extends ApplicationMapper<HistoriqueFactureRequest, HistoriqueFactureResponse, HistoriqueFacture>{

    HistoriqueFactureMapper INSTANCE = Mappers.getMapper(HistoriqueFactureMapper.class);

}
