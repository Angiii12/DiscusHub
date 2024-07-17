package com.discushub.discusHub.domain.topico;

import com.discushub.discusHub.domain.curso.RegistrarCursoDTO;
import com.discushub.discusHub.domain.usuario.RegistrarUsuarioDTO;

public record ActualizarTopico(String titulo,
                               String mensaje,
                               RegistrarUsuarioDTO usuario,
                               RegistrarCursoDTO curso,
                               Boolean status) {
}
