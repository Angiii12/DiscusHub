package com.discushub.discusHub.domain.topico;

import com.discushub.discusHub.domain.curso.Curso;
import com.discushub.discusHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
//
//    @OneToMany(mappedBy = "topico")
//    private List<Respuesta> respuestas;

    public Topico(TopicoRegistro paramtero) {
        this.titulo = paramtero.titulo();
        this.mensaje = paramtero.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = paramtero.status();
        this.autor = new Usuario(paramtero.usuario());
        this.curso = new Curso(paramtero.curso());
    }

    public void actualizarDatos(ActualizarTopico datosActualizarTopico){
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.status() != null){
            this.status = datosActualizarTopico.status();
        }
        if(datosActualizarTopico.usuario() != null){
            this.autor = autor.actualizarDatos(datosActualizarTopico.usuario());
        }
        if(datosActualizarTopico.curso() != null){
            this.curso = curso.actualizarDatos(datosActualizarTopico.curso());
        }
    }
}
