package com.apirest.backend.Service;

import com.apirest.backend.DTO.ProyectoDetallesDTO;
import com.apirest.backend.DTO.UsuariosProyectosDTO;
import com.apirest.backend.Model.ProyectosModel;
import com.apirest.backend.Repository.IComentariosRepository;
import com.apirest.backend.Repository.IProyectosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectosServiceImp implements IProyectosService {

    @Autowired
    private IProyectosRepository proyectosRepository;
     @Autowired
    private IComentariosRepository comentariosRepository;
    
    @Override
    public String crearProyecto(ProyectosModel proyecto) {
        proyectosRepository.save(proyecto);
        return String.format("El proyecto '%s' con ID %s ha sido creado con éxito.", proyecto.getTipoCultivo(), proyecto.getId());
    }

    @Override
    public List<ProyectosModel> obtenerProyectos() {
        return proyectosRepository.findAll();
    }

    @Override
    public ProyectosModel obtenerProyectoPorId(ObjectId id) {
        return proyectosRepository.findById(id).orElse(null);
    }

    @Override
    public String eliminarProyecto(ObjectId id) {
        if (proyectosRepository.existsById(id)) {
            // Eliminar todos los comentarios asociados al proyecto
            comentariosRepository.deleteByProyectoId(id);
            // Eliminar el proyecto
            proyectosRepository.deleteById(id);
            return String.format("El proyecto con ID %s y sus comentarios asociados han sido eliminados con éxito.", id.toHexString());
        }
        return String.format("El proyecto con ID %s no existe y no se pudo eliminar.", id.toHexString());
    }

    @Override
    public List<UsuariosProyectosDTO> obtenerUsuariosConSusProyectos() {
        return proyectosRepository.obtenerUsuariosConSusProyectos();
    }

    @Override
    public List<ProyectoDetallesDTO> obtenerDetalleProyectos() {
        return proyectosRepository.obtenerDetalleProyectos();
    }
}

