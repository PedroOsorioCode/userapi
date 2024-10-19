package com.nisum.userapi.core.base.validator;

/*
 * Servicio para aplicar validaciones
 */
public interface ValidationManager {
    /*
     * Determina si cumple la regla de validacion
     */
    boolean isValid(String value);

}