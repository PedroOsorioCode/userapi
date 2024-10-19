package com.nisum.userapi.core.base.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncript {
    @Value("${password.regex}")
    private String hasdPassword;
    private String hashed = BCrypt.hashpw(hasdPassword, BCrypt.gensalt());

    public String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean matches(String password) {
        return BCrypt.checkpw(password, hashed);
    }
}
