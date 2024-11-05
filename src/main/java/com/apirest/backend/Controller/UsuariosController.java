package com.apirest.backend.Controller;

// import com.apirest.backend.DTO.UsuariosProyectosDTO;
import com.apirest.backend.Exception.RecursoNoEncontrado;
import com.apirest.backend.Model.UsuariosModel;
import com.apirest.backend.Service.IUsuariosService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jardineria/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuariosService usuarioService;

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody UsuariosModel usuario) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuariosModel>> obtenerUsuarios() {
        return new ResponseEntity<>(usuarioService.obtenerUsuarios(), HttpStatus.OK);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable String id) {
        try {
            UsuariosModel usuario = validarIdUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String id) {
        try {
            UsuariosModel usuario = validarIdUsuario(id);
            return new ResponseEntity<>(usuarioService.eliminarUsuario(usuario.getId()), HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    private UsuariosModel validarIdUsuario(String id) throws RecursoNoEncontrado {
        if (!ObjectId.isValid(id)) {
            throw new RecursoNoEncontrado(String.format("El usuario con id %s no se encontró", id));
        }
        UsuariosModel usuario = usuarioService.obtenerUsuarioPorId(new ObjectId(id));
        if (usuario == null) {
            throw new RecursoNoEncontrado(String.format("El usuario con id %s no se encontró", id));
        }
        return usuario;
    }
}
