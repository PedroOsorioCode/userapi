package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.core.base.utils.JwtUtil;
import com.nisum.userapi.core.base.utils.PasswordEncript;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserFactoryImpl implements UserFactory {
    public UserEntity createUser(UserDTO userDTO) {
        String uuid = UUID.randomUUID().toString();
        return UserEntity.builder()
            .id(UUID.fromString(uuid))
            .name(userDTO.getName())
            .email(userDTO.getEmail())
            .password(this.encriptarPassword(userDTO.getPassword()))
            .token(this.generarToken(userDTO.getEmail()))
            .build();
    }

    private String generarToken(String email){
        return JwtUtil.getInstance().generateToken(email);
    }

    private String encriptarPassword(String password){
        return PasswordEncript.getInstance().encodePassword(password);
    }
}
