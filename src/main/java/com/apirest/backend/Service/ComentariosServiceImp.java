package com.apirest.backend.Service;

import com.apirest.backend.Model.ComentariosModel;
import com.apirest.backend.Repository.IComentariosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentariosServiceImp implements IComentariosService {

    @Autowired
    private IComentariosRepository comentariosRepository;

    @Override
    public String crearComentario(ComentariosModel comentario) {
        comentariosRepository.save(comentario);
        return String.format("El comentario '%s' con ID %s ha sido creado con éxito.", comentario.getTexto(), comentario.getId());
    }

    @Override
    public List<ComentariosModel> obtenerComentarios() {
        return comentariosRepository.findAll();
    }

    @Override
    public ComentariosModel obtenerComentarioPorId(ObjectId id) {
        return comentariosRepository.findById(id).orElse(null);
    }

    @Override
    public String eliminarComentario(ObjectId id) {
        if (comentariosRepository.existsById(id)) {
            comentariosRepository.deleteById(id);
            return String.format("El comentario con ID %s ha sido eliminado con éxito.", id.toHexString());
        }
        return String.format("El comentario con ID %s no existe y no se pudo eliminar.", id.toHexString());
    }
}

