package com.discushub.discusHub.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String password;
//    @ManyToMany
//    @JoinTable(name = "perfil",
//    joinColumns = @JoinColumn(name = "usuario_id"),
//    inverseJoinColumns = @JoinColumn(name = "perfil_id"))
//    private List<Perfil> perfiles;

    public Usuario(RegistrarUsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.id();
        this.nombre = usuarioDTO.nombre();
        this.correo = usuarioDTO.correo();
        this.password = usuarioDTO.contrasena();
    }

    public Usuario actualizarDatos(RegistrarUsuarioDTO datosActualizarTopico) {
        this.id = datosActualizarTopico.id();
        this.nombre = datosActualizarTopico.nombre();
        this.correo = datosActualizarTopico.correo();
        this.password = datosActualizarTopico.contrasena();
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
