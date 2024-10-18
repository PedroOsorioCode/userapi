package com.nisum.userapi.core.base.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service("passwordValidationManager")
@Log4j2
@RequiredArgsConstructor
public class PasswordValidationManagerImpl implements ValidationManager {
	@Value("${password.regex}")
	private String passwordRegex;

	@Override
	public boolean isValid(String password) {
		return Pattern.matches(passwordRegex, password);
	}

}