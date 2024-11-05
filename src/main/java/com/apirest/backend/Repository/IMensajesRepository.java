package com.apirest.backend.Repository;


import com.apirest.backend.Model.MensajesModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMensajesRepository extends MongoRepository<MensajesModel, ObjectId> {
}
