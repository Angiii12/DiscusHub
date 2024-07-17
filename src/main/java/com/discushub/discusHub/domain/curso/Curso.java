package com.discushub.discusHub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    private String categoria;

    public Curso(Long id) {
        this.id = id;
    }

    public Curso(RegistrarCursoDTO course) {
        this.id = course.id();
        this.nombre = course.nombre();
        this.categoria = course.categoria();
    }

    public Curso actualizarDatos(RegistrarCursoDTO curso) {
        this.id = curso.id();
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
        return this;
    }
}
