package com.nisum.userapi.core.base.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service("emailValidationManager")
@Log4j2
@RequiredArgsConstructor
public class EmailValidationManagerImpl implements ValidationManager {
    @Override
    public boolean isValid(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.matches(EMAIL_REGEX, email);
    }
}