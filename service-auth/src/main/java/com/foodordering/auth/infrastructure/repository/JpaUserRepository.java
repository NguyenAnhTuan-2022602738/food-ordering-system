package com.foodordering.auth.infrastructure.repository;

import com.foodordering.auth.domain.model.User;
import com.foodordering.auth.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<User, UUID>, UserRepository {

    @Override
    Optional<User> findByEmail(String email);

    @Override
    default boolean existsByEmail(String email) {
        return findByEmail(email).isPresent();
    }
}