package com.apirest.backend.Service;

import com.apirest.backend.DTO.ProyectoDetallesDTO;
import com.apirest.backend.DTO.UsuariosProyectosDTO;
import com.apirest.backend.Model.ProyectosModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IProyectosService {
    String crearProyecto(ProyectosModel proyecto);                        // Crear un nuevo proyecto
    List<ProyectosModel> obtenerProyectos();                              // Obtener todos los proyectos
    ProyectosModel obtenerProyectoPorId(ObjectId id);                     // Obtener un proyecto por ID
    String eliminarProyecto(ObjectId id);                                 // Eliminar un proyecto por ID
    List<UsuariosProyectosDTO> obtenerUsuariosConSusProyectos();       // Obtener usuarios con sus proyectos
    List<ProyectoDetallesDTO> obtenerDetalleProyectos();             // Obtener proyectos con detalles específicos

}