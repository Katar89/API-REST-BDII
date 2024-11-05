package com.apirest.backend.Repository;

import com.apirest.backend.Model.ComentariosModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IComentariosRepository extends MongoRepository<ComentariosModel, ObjectId> {
    void deleteByProyectoId(ObjectId proyectoId);
}
