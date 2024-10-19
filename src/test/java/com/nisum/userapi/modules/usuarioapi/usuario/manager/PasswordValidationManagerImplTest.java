package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.core.base.validator.PasswordValidationManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(properties = "password.regex=^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
public class PasswordValidationManagerImplTest {
    @InjectMocks PasswordValidationManagerImpl passwordValidationManager;

    @Test public void testPassIncorrecto(){
        var rs = passwordValidationManager.isValid("texto");
        assertFalse(rs);
    }
}
