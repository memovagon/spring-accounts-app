package com.accounts.app.models.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.app.models.entity.User;

/**
 *  @Repository AutorizationServerConfig Interface
 *  Users repository for CRUD operations.  
 */

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}