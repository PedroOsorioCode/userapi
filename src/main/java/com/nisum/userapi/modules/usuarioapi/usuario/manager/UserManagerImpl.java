package com.nisum.userapi.modules.usuarioapi.usuario.manager;

import com.nisum.userapi.core.base.utils.MensajesOperativos;
import com.nisum.userapi.core.base.validator.ValidationManager;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.PhoneDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserCreatedDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.dto.UserDTO;
import com.nisum.userapi.modules.usuarioapi.usuario.entity.PhoneEntity;
import com.nisum.userapi.modules.usuarioapi.usuario.entity.UserEntity;
import com.nisum.userapi.modules.usuarioapi.usuario.repository.PhoneRepository;
import com.nisum.userapi.modules.usuarioapi.usuario.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {
    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    @Qualifier("emailValidationManager")
    private final ValidationManager emailValidationManager;
    @Qualifier("passwordValidationManager")
    private final ValidationManager passwordValidationManager;
    private final UserFactory userFactory;

    @Override
    public UserCreatedDTO crear(UserDTO userDTO) {
        this.validarInformacionUsuario(userDTO);

        UserEntity userCurrent = userRepository.save(userFactory.createUser(userDTO));
        phoneRepository.saveAll(createPhones(userDTO.getPhones(), userCurrent));
        return UserCreatedDTO.builder()
                .id(userCurrent.getId().toString())
                .created(userCurrent.getCreated())
                .modified(userCurrent.getModified())
                .token(userCurrent.getToken())
                .lastLogin(userCurrent.getLastLogin())
                .isActive(userCurrent.isActive())
                .build();
    }

    private List<PhoneEntity> createPhones(List<PhoneDTO> phonesDTO, UserEntity user) {
        return phonesDTO.stream()
                .map(d -> new PhoneEntity(d.getNumber(), d.getCitycode(), d.getCountrycode(), user))
                .toList();
    }

    private void validarInformacionUsuario(UserDTO userDTO){
        if (!emailValidationManager.isValid(userDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, MensajesOperativos.EMAIL_INVALIDO.getMensaje());
        }

        if (!passwordValidationManager.isValid(userDTO.getPassword())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, MensajesOperativos.PASSWORD_INVALIDO.getMensaje());
        }

        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, MensajesOperativos.EMAIL_YA_EXISTE.getMensaje());
        }
    }

}