package com.apirest.backend.Controller;

import com.apirest.backend.Exception.RecursoNoEncontrado;
import com.apirest.backend.Model.MensajesModel;
import com.apirest.backend.Service.IMensajesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jardineria/mensajes")
public class MensajesController {

    @Autowired
    private IMensajesService mensajeService;

    // Crear un nuevo mensaje
    @PostMapping
    public ResponseEntity<String> crearMensaje(@RequestBody MensajesModel mensaje) {
        return new ResponseEntity<>(mensajeService.crearMensaje(mensaje), HttpStatus.CREATED);
    }

    // Obtener todos los mensajes
    @GetMapping
    public ResponseEntity<List<MensajesModel>> obtenerMensajes() {
        return new ResponseEntity<>(mensajeService.obtenerMensajes(), HttpStatus.OK);
    }

    // Obtener mensaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMensajePorId(@PathVariable String id) {
        try {
            MensajesModel mensaje = validarIdMensaje(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Eliminar un mensaje
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMensaje(@PathVariable String id) {
        try {
            MensajesModel mensaje = validarIdMensaje(id);
            return new ResponseEntity<>(mensajeService.eliminarMensaje(mensaje.getId()), HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    private MensajesModel validarIdMensaje(String id) throws RecursoNoEncontrado {
        if (!ObjectId.isValid(id)) {
            throw new RecursoNoEncontrado(String.format("El mensaje con id %s no se encontró", id));
        }
        MensajesModel mensaje = mensajeService.obtenerMensajePorId(new ObjectId(id));
        if (mensaje == null) {
            throw new RecursoNoEncontrado(String.format("El mensaje con id %s no se encontró", id));
        }
        return mensaje;
    }
}
