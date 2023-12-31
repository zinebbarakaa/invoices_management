package com.fsts.gestion_factures.mappers;

import com.fsts.gestion_factures.entities.Produit;
import com.fsts.gestion_factures.model.request.ProduitRequest;
import com.fsts.gestion_factures.model.response.ProduitResponse;
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
public interface ProduitMapper extends ApplicationMapper<ProduitRequest, ProduitResponse, Produit>{

    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);

}
