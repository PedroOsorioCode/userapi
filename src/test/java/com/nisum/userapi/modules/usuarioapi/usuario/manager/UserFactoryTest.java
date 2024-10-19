package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.core.base.utils.JwtUtil;
import com.nisum.userapi.core.base.utils.PasswordEncript;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserFactoryTest {
    @InjectMocks UserFactory userFactory;
    @Mock private JwtUtil jwtUtil;
    @Mock private PasswordEncript passwordEncript;

    @Test public void testCrearUsuario(){
        var rs = userFactory.createUser(UserDataBuilder.crearUsuarioRequest());
        assertNotNull(rs);
        assertNotNull(rs.getId());
    }
}
