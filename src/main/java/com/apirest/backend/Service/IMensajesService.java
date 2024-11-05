package com.apirest.backend.Service;


import com.apirest.backend.Model.MensajesModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IMensajesService {
    String crearMensaje(MensajesModel mensaje);              // Crear un nuevo mensaje
    List<MensajesModel> obtenerMensajes();                   // Obtener todos los mensajes
    MensajesModel obtenerMensajePorId(ObjectId id);          // Obtener un mensaje por ID
    String eliminarMensaje(ObjectId id);                     // Eliminar un mensaje por ID
}

