package com.apirest.backend.Repository;


import com.apirest.backend.Model.SolicitudesColaboracionModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISolicitudesColaboracionRepository extends MongoRepository<SolicitudesColaboracionModel, ObjectId> {
}

