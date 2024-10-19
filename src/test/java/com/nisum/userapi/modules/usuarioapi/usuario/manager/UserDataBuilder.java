package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.modules.usuarioapi.usuario.dto.PhoneDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;

import java.util.Collections;
import java.util.List;

public class UserDataBuilder {
    public static UserDTO crearUsuarioRequest() {
        return UserDTO.builder()
                .name("name1")
                .email("emailcorrecto1@abc.com")
                .password("PassCorrw123*")
                .phones(createValidPhoneDTOList())
                .build();
    }

    public static List<PhoneDTO> createValidPhoneDTOList() {
        return Collections.singletonList(new PhoneDTO("+57123", "citycode", "countrycod"));
    }
}
