package com.nisum.userapi.modules.usuarioapi.usuario.repository;

import com.nisum.userapi.modules.usuarioapi.usuario.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
