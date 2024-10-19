package com.nisum.userapi.modules.usuarioapi.usuario.manager;


import com.nisum.userapi.core.base.validator.ValidationManager;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.entity.UserEntity;
import com.nisum.userapi.modules.usuarioapi.usuario.repository.PhoneRepository;
import com.nisum.userapi.modules.usuarioapi.usuario.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserManagerImplTest {
    @InjectMocks private UserManagerImpl usuarioManager;
    @Mock private ValidationManager validationManager;
    @Mock private UserFactory userFactory;
    @Mock private UserRepository userRepository;
    @Mock private PhoneRepository phoneRepository;

    @Test public void testCrearUsuarioExito(){
        given(validationManager.isValid(anyString())).willReturn(true);
        given(userRepository.findByEmail(anyString())).willReturn(Optional.empty());
        given(userRepository.save(any())).willReturn(
                UserEntity.builder().id(UUID.fromString(UUID.randomUUID().toString())).build());
        given(phoneRepository.saveAll(any())).willReturn(new ArrayList<>());
        var rs = usuarioManager.crear(this.crearUsuarioRequest());
        assertNotNull(rs);
        assertNotNull(rs.getId());
    }

    @Test public void testCrearUsuarioFallaValidacion(){
        given(validationManager.isValid(anyString())).willReturn(false);
        Executable executable = () -> usuarioManager.crear(this.crearUsuarioRequest());
        assertThrows(ResponseStatusException.class, executable);
    }

    @Test public void testCrearUsuarioEmailRepetido(){
        given(validationManager.isValid(anyString())).willReturn(true);
        given(userRepository.findByEmail(anyString())).willReturn(Optional.of(new UserEntity()));
        Executable executable = () -> usuarioManager.crear(this.crearUsuarioRequest());
        assertThrows(ResponseStatusException.class, executable);
    }

    private UserDTO crearUsuarioRequest(){
        return UserDataBuilder.crearUsuarioRequest();
    }

}
