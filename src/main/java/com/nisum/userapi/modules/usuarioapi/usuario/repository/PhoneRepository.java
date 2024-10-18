package com.nisum.userapi.modules.usuarioapi.usuario.repository;

import com.nisum.userapi.modules.usuarioapi.usuario.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {
}
