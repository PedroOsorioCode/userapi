package com.nisum.userapi.modules.usuarioapi.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "phones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "city_code", nullable = false)
    private String citycode;

    @Column(name = "country_code", nullable = false)
    private String countrycode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public PhoneEntity(String number, String citycode, String countrycode, UserEntity user) {
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
        this.user = user;
    }
}