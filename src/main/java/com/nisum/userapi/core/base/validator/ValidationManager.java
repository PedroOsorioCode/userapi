package com.nisum.userapi.core.base.validator;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/*
 * Servicio para aplicar validaciones
 */
public interface ValidationManager {
    /*
     * Determina si cumple la regla de validacion
     */
    boolean isValid(String value);

}