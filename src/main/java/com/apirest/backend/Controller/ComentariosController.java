package com.apirest.backend.Controller;


import com.apirest.backend.Exception.RecursoNoEncontrado;
import com.apirest.backend.Model.ComentariosModel;
import com.apirest.backend.Service.IComentariosService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jardineria/comentarios")
public class ComentariosController {

    @Autowired
    private IComentariosService comentarioService;

    // Crear un nuevo comentario
    @PostMapping("")
    public ResponseEntity<String> crearComentario(@RequestBody ComentariosModel comentario) {
        return new ResponseEntity<>(comentarioService.crearComentario(comentario), HttpStatus.CREATED);
    }

    // Obtener todos los comentarios
    @GetMapping("")
    public ResponseEntity<List<ComentariosModel>> obtenerComentarios() {
        return new ResponseEntity<>(comentarioService.obtenerComentarios(), HttpStatus.OK);
    }

    // Obtener comentario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerComentarioPorId(@PathVariable String id) {
        try {
            ComentariosModel comentario = validarIdComentario(id);
            return new ResponseEntity<>(comentario, HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Eliminar un comentario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable String id) {
        try {
            ComentariosModel comentario = validarIdComentario(id);
            return new ResponseEntity<>(comentarioService.eliminarComentario(comentario.getId()), HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    private ComentariosModel validarIdComentario(String id) throws RecursoNoEncontrado {
        if (!ObjectId.isValid(id)) {
            throw new RecursoNoEncontrado(String.format("El comentario con id %s no se encontró", id));
        }
        ComentariosModel comentario = comentarioService.obtenerComentarioPorId(new ObjectId(id));
        if (comentario == null) {
            throw new RecursoNoEncontrado(String.format("El comentario con id %s no se encontró", id));
        }
        return comentario;
    }
}

