package com.nisum.userapi.core.base.utils;

public enum MensajesOperativos {
    EMAIL_INVALIDO("Email invalido"),
    PASSWORD_INVALIDO("La contraseña debe tener al menos 8 caracteres, incluir al menos una letra mayúscula, una letra minúscula, un dígito y un carácter especial (@$!%*?&)"),
    EMAIL_YA_EXISTE("El correo ya está registrado");
    private final String mensaje;

    MensajesOperativos(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
