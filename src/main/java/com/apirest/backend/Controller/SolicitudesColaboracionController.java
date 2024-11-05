package com.apirest.backend.Controller;

import com.apirest.backend.Exception.RecursoNoEncontrado;
import com.apirest.backend.Model.SolicitudesColaboracionModel;
import com.apirest.backend.Service.ISolicitudesColaboracionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jardineria/solicitudes-colaboracion")
public class SolicitudesColaboracionController {

    @Autowired
    private ISolicitudesColaboracionService solicitudesService;

    @PostMapping
    public ResponseEntity<String> crearSolicitudColaboracion(@RequestBody SolicitudesColaboracionModel solicitud) {
        return new ResponseEntity<>(solicitudesService.crearSolicitudColaboracion(solicitud), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudesColaboracionModel>> obtenerSolicitudesColaboracion() {
        return new ResponseEntity<>(solicitudesService.obtenerSolicitudesColaboracion(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerSolicitudColaboracionPorId(@PathVariable String id) {
        try {
            SolicitudesColaboracionModel solicitudRecuperada = validarIdEntrada(id);
            return new ResponseEntity<>(solicitudRecuperada, HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSolicitudColaboracion(@PathVariable String id) {
        try {
            SolicitudesColaboracionModel solicitudRecuperada = validarIdEntrada(id);
            return new ResponseEntity<>(solicitudesService.eliminarSolicitudColaboracion(solicitudRecuperada.getId()), HttpStatus.OK);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
public ResponseEntity<String> actualizarSolicitudColaboracion(@PathVariable String id, @RequestBody SolicitudesColaboracionModel solicitud) {
    try {
        SolicitudesColaboracionModel solicitudRecuperada = validarIdEntrada(id);
        return new ResponseEntity<>(solicitudesService.actualizarSolicitudColaboracion(solicitudRecuperada.getId(), solicitud), HttpStatus.OK);
    } catch (RecursoNoEncontrado e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}


    private SolicitudesColaboracionModel validarIdEntrada(String id) throws RecursoNoEncontrado {
        if (!ObjectId.isValid(id)) {
            throw new RecursoNoEncontrado(String.format("La solicitud con ID %s no se encontró", id));
        }
        SolicitudesColaboracionModel solicitud = solicitudesService.obtenerSolicitudPorId(new ObjectId(id));
        if (solicitud == null) {
            throw new RecursoNoEncontrado(String.format("La solicitud con ID %s no se encontró", id));
        }
        return solicitud;
    }
}