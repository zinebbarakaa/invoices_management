package com.fsts.gestion_factures.service;

import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.model.request.UserRequest;
import com.fsts.gestion_factures.model.response.UserResponse;

public interface UserService extends CrudService<UserRequest, UserResponse, User,Long>{
}
