package com.nisum.userapi.modules.usuarioapi.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PhoneEntity> phones;

	@Column(name = "created", nullable = false, updatable = false)
	private LocalDateTime created;

	@Column(name = "modified")
	private LocalDateTime modified;

	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@Column(name = "token")
	private String token;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@PrePersist
	protected void onCreate() {
		this.created = LocalDateTime.now();
		this.modified = LocalDateTime.now();
		this.lastLogin = LocalDateTime.now();
		this.isActive = true;
	}

	@PreUpdate
	protected void onUpdate() {
		this.modified = LocalDateTime.now();
	}
}