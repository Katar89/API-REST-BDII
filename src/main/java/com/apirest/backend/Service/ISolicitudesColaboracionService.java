package com.apirest.backend.Service;



import com.apirest.backend.Model.SolicitudesColaboracionModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface ISolicitudesColaboracionService {
    String crearSolicitudColaboracion(SolicitudesColaboracionModel solicitud);
    List<SolicitudesColaboracionModel> obtenerSolicitudesColaboracion();
    SolicitudesColaboracionModel obtenerSolicitudPorId(ObjectId id);
    String actualizarSolicitudColaboracion(ObjectId id, SolicitudesColaboracionModel solicitud);
    String eliminarSolicitudColaboracion(ObjectId id);
}

