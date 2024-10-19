package com.nisum.userapi.modules.usuarioapi.usuario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.PhoneDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserCreatedDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.manager.UserManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.nisum.userapi.core.base.utils.JsonUtil.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private UserManager userManager;

    @Test
    void testCrearUsuario() throws Exception {
        given(userManager.crear(this.crearUsuarioRequest())).willReturn(new UserCreatedDTO());
        this.mockMvc.perform(post("/api/usuario/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(this.crearUsuarioRequest())))
                .andExpect(status().isOk());

        verify(userManager).crear(this.crearUsuarioRequest());
    }

    private UserDTO crearUsuarioRequest(){
        return UserDTO.builder()
                .name("name")
                .email("email")
                .password("password")
                .phones(List.of(new PhoneDTO("+57123", "citycode", "countrycod")))
                .build();

    }
}
