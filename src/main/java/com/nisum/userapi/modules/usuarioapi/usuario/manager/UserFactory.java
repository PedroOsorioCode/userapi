package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.entity.UserEntity;

/**
 * Servicio para crear un objeto usuario
 */
public interface UserFactory {
    /**
     * Crea el objeto usuario on UUID, passwordencriptado y token
     * @param userDTO datos del usuario
     * @return
     */
    UserEntity createUser(UserDTO userDTO);
}
