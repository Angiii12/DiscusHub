package com.discushub.discusHub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarCursoDTO(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotBlank String categoria
) {
}
