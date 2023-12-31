package com.fsts.gestion_factures.repository;

import com.fsts.gestion_factures.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
