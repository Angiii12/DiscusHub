package com.discushub.discusHub.domain.topico;

import com.discushub.discusHub.domain.curso.Curso;
import com.discushub.discusHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record TopicoRespuesta(Long id,
                              String titulo,
                              String mensaje,
                              LocalDateTime fecha,
                              Boolean status,
                              Usuario usuario,
                              Curso curso) {
}
