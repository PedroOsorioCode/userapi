package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.core.base.utils.JwtUtil;
import com.nisum.userapi.core.base.utils.PasswordEncript;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserFactory{
    private final JwtUtil jwtUtil;
    private final PasswordEncript passwordEncript;

    public UserEntity createUser(UserDTO userDTO) {
        String uuid = UUID.randomUUID().toString();
        return UserEntity.builder()
            .id(UUID.fromString(uuid))
            .name(userDTO.getName())
            .email(userDTO.getEmail())
            .password(this.encriptarPassword(userDTO.getPassword()))
            .token(this.generarToken(userDTO))
            .build();
    }

    private String generarToken(UserDTO userDTO){
        return jwtUtil.generateToken(userDTO.getName(), userDTO.getEmail());
    }
    private String encriptarPassword(String password){
        return passwordEncript.encodePassword(password);
    }
}
