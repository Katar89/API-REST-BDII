package com.apirest.backend.Repository;


import com.apirest.backend.Model.PerfilesUsuariosViews;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPerfilesUsuariosRepository extends MongoRepository<PerfilesUsuariosViews, ObjectId> {
}

