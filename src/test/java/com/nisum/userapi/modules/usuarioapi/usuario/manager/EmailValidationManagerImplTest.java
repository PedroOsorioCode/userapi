package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.core.base.validator.EmailValidationManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmailValidationManagerImplTest {
    @InjectMocks EmailValidationManagerImpl emailValidationManager;

    @Test public void testEmailIncorrecto(){
        var rs = emailValidationManager.isValid("correoerror");
        assertFalse(rs);
    }

    @Test public void testEmailCorrecto(){
        var rs = emailValidationManager.isValid("correok@abc.com");
        assertTrue(rs);
    }
}
