package com.fsts.gestion_factures.mappers;

import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.model.request.UserRequest;
import com.fsts.gestion_factures.model.response.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper extends ApplicationMapper<UserRequest, UserResponse, User>
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);



}
