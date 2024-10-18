package com.nisum.userapi.modules.usuarioapi.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String number;
    private String citycode;
    private String countrycode;
}