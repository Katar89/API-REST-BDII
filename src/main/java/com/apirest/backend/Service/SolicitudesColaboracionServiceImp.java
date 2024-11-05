package com.apirest.backend.Service;



import com.apirest.backend.Exception.RecursoNoEncontrado;
import com.apirest.backend.Model.SolicitudesColaboracionModel;
import com.apirest.backend.Repository.ISolicitudesColaboracionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudesColaboracionServiceImp implements ISolicitudesColaboracionService {

    @Autowired
    private ISolicitudesColaboracionRepository colaboracionRepository;
    
    @Override
    public String crearSolicitudColaboracion(SolicitudesColaboracionModel solicitud) {
        colaboracionRepository.save(solicitud);
        return String.format("La solicitud de colaboración para el proyecto con ID %s ha sido creada.", solicitud.getProyectoId());
    }

    @Override
    public List<SolicitudesColaboracionModel> obtenerSolicitudesColaboracion() {
        return colaboracionRepository.findAll();
    }

    @Override
    public SolicitudesColaboracionModel obtenerSolicitudPorId(ObjectId id) {
        return colaboracionRepository.findById(id).orElse(null);
    }

    @Override
    public String actualizarSolicitudColaboracion(ObjectId id, SolicitudesColaboracionModel solicitudActualizada) {
    if (!colaboracionRepository.existsById(id)) {
        throw new RecursoNoEncontrado(String.format("La solicitud con ID %s no existe.", id.toHexString()));
    }
    solicitudActualizada.setId(id); // Asegúrate de que el ID de la solicitud a actualizar se mantenga
    colaboracionRepository.save(solicitudActualizada); // Guarda la actualización
    return String.format("La solicitud con ID %s ha sido actualizada con éxito.", id.toHexString());
}


    @Override
    public String eliminarSolicitudColaboracion(ObjectId id) {
        if (colaboracionRepository.existsById(id)) {
            colaboracionRepository.deleteById(id);
            return String.format("La solicitud de colaboración con ID %s ha sido eliminada.", id.toHexString());
        }
        return String.format("La solicitud con ID %s no se encontró.", id.toHexString());
    }
}

