package com.apirest.backend.Service;


import com.apirest.backend.Model.MensajesModel;
import com.apirest.backend.Repository.IMensajesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajesServiceImp implements IMensajesService {

    @Autowired
    private IMensajesRepository mensajesRepository;

    @Override
    public String crearMensaje(MensajesModel mensaje) {
    if (mensaje.getUsuarioReceptorId() == null || mensaje.getUsuarioDestinatarioId() == null || mensaje.getTexto() == null) {
        throw new IllegalArgumentException("Todos los campos obligatorios deben ser proporcionados.");
    }
    mensajesRepository.save(mensaje);
    return String.format("El mensaje ha sido enviado con éxito.", mensaje.getId());
}


    @Override
    public List<MensajesModel> obtenerMensajes() {
        return mensajesRepository.findAll();
    }

    @Override
    public MensajesModel obtenerMensajePorId(ObjectId id) {
        return mensajesRepository.findById(id).orElse(null);
    }

    @Override
    public String eliminarMensaje(ObjectId id) {
        if (mensajesRepository.existsById(id)) {
            mensajesRepository.deleteById(id);
            return String.format("El mensaje con ID %s ha sido eliminado con éxito.", id.toHexString());
        }
        return String.format("El mensaje con ID %s no existe y no se pudo eliminar.", id.toHexString());
    }
}

