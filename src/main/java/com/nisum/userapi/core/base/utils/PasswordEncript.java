package com.nisum.userapi.core.base.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncript {
    private static PasswordEncript instance;
    private String hashed = BCrypt.hashpw("password", BCrypt.gensalt());

    private PasswordEncript() { }

    public static synchronized PasswordEncript getInstance() {
        return instance == null ? new PasswordEncript() : instance;
    }

    public String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean matches(String password, String encodedPassword) {
        return BCrypt.checkpw(password, hashed);
    }
}
