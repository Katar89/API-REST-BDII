package com.apirest.backend.Repository;

import com.apirest.backend.Model.UsuariosModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuariosRepository extends MongoRepository<UsuariosModel, ObjectId> {
}

