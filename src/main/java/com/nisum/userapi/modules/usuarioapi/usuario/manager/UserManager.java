package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserCreatedDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;

/*
 * Servicio para la administracion de informacion de usuarios
 */
public interface UserManager {
    /*
     * Permite crear un nuevo usuario siempre y cuando cumpla con los requerimientos:
     * Formato email
     * Formato password
     * Usuario es unica respecto a su email
     */
    UserCreatedDTO crear(UserDTO UserDTO);
}