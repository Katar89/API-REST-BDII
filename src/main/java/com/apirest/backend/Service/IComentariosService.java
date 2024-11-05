package com.apirest.backend.Service;


import com.apirest.backend.Model.ComentariosModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IComentariosService {
    String crearComentario(ComentariosModel comentario);              // Crear un nuevo comentario
    List<ComentariosModel> obtenerComentarios();                      // Obtener todos los comentarios
    ComentariosModel obtenerComentarioPorId(ObjectId id);             // Obtener un comentario por ID
    String eliminarComentario(ObjectId id);                           // Eliminar un comentario por ID
}
