package com.discushub.discusHub.domain.topico;

import com.discushub.discusHub.domain.curso.RegistrarCursoDTO;
import com.discushub.discusHub.domain.usuario.RegistrarUsuarioDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRegistro(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull @Valid RegistrarUsuarioDTO usuario,
        @NotNull @Valid RegistrarCursoDTO curso,
        @NotNull Boolean status
) {}
