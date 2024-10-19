package com.nisum.userapi.modules.usuarioapi.usuario.controller;

import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserCreatedDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.manager.UserManager;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {
    private final UserManager userManager;

    @Operation(summary = "Permite agregar un nuevo usuario")
    @PostMapping("/guardar")
    public ResponseEntity<UserCreatedDTO> registrarUsuario(
            @RequestBody @Valid UserDTO userNew) {

        return new ResponseEntity<>(userManager.crear(userNew), HttpStatus.OK);
    }
}