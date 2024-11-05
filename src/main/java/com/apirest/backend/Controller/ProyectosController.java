package com.apirest.backend.Controller;


import com.apirest.backend.Exception.RecursoNoEncontrado;
import com.apirest.backend.Model.ProyectosModel;
import com.apirest.backend.Service.IProyectosService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jardineria/proyectos")
public class ProyectosController {

    @Autowired
    private IProyectosService proyectoService;

    @PostMapping
    public ResponseEntity<String> crearProyecto(@RequestBody ProyectosModel proyecto) {
        // Agregar validación si es necesario
        return new ResponseEntity<>(proyectoService.crearProyecto(proyecto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProyectosModel>> obtenerProyectos() {
        return ResponseEntity.ok(proyectoService.obtenerProyectos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectosModel> obtenerProyectoPorId(@PathVariable String id) {
        try {
            ProyectosModel proyecto = validarIdProyecto(id);
            return ResponseEntity.ok(proyecto);
        } catch (RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProyecto(@PathVariable String id) {
        ObjectId proyectoId = new ObjectId(id);
        String responseMessage = proyectoService.eliminarProyecto(proyectoId);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    private ProyectosModel validarIdProyecto(String id) throws RecursoNoEncontrado {
        if (!ObjectId.isValid(id)) {
            throw new RecursoNoEncontrado(String.format("El proyecto con id %s no se encontró", id));
        }
        ProyectosModel proyecto = proyectoService.obtenerProyectoPorId(new ObjectId(id));
        if (proyecto == null) {
            throw new RecursoNoEncontrado(String.format("El proyecto con id %s no se encontró", id));
        }
        return proyecto;
    }
}
