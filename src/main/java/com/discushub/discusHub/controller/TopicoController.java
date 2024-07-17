package com.discushub.discusHub.controller;


import com.discushub.discusHub.domain.curso.Curso;
import com.discushub.discusHub.domain.curso.CursoRepository;
import com.discushub.discusHub.domain.topico.*;
import com.discushub.discusHub.domain.usuario.Usuario;
import com.discushub.discusHub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<TopicoRespuesta> registrarTopico(@RequestBody @Valid TopicoRegistro topicoRegistro,
                                          UriComponentsBuilder uriBuilder) {;
        Topico topico = topicoRepository.save(new Topico(topicoRegistro));
        cursoRepository.save(new Curso(topicoRegistro.curso()));
        TopicoRespuesta respuesta = new TopicoRespuesta(topico.getId() ,topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getStatus(), topico.getAutor(), topico.getCurso());
        URI url = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoListado>> listadoTopicos(@PageableDefault(size = 10) Pageable paginacion){
        Pageable paginacionOrdenada = PageRequest.of(
                paginacion.getPageNumber(), paginacion.getPageSize(), Sort.by("fecha").ascending()
        );
        return ResponseEntity.ok(topicoRepository.findAll(paginacionOrdenada).map(TopicoListado::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id,@RequestBody @Valid ActualizarTopico topicoActualizar) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(topicoActualizar);
        topicoRepository.save(topico);
        return ResponseEntity.ok(new TopicoRespuesta(topico.getId() ,topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getStatus(), topico.getAutor(), topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        // Buscar el tópico por ID
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity retornaDatosTopico(@PathVariable Long id){
        // Buscar el tópico por ID
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicoRespuesta(topico.getId() ,topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getStatus(), topico.getAutor(), topico.getCurso()));
    }
}

