package com.fsts.gestion_factures.mappers;

import com.fsts.gestion_factures.entities.Commande;
import com.fsts.gestion_factures.model.request.CommandeRequest;
import com.fsts.gestion_factures.model.response.CommandeResponse;
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
public interface CommandeMapper extends ApplicationMapper<CommandeRequest, CommandeResponse, Commande>{
    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);

}
