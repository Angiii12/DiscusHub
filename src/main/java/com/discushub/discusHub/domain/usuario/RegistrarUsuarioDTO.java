package com.discushub.discusHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarUsuarioDTO(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotBlank String correo,
        @NotBlank String contrasena
) {
}
