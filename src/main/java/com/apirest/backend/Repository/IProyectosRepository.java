package com.apirest.backend.Repository;
import com.apirest.backend.DTO.ProyectoDetallesDTO;
import com.apirest.backend.DTO.UsuariosProyectosDTO;
import com.apirest.backend.Model.ProyectosModel;
import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IProyectosRepository extends MongoRepository<ProyectosModel, ObjectId> {

    @Aggregation(pipeline = {
            "{ $group: {_id: '$usuarioId', proyectos: { $push: '$$ROOT' }}}",
            "{ $lookup: { from: 'Usuarios', localField: '_id', foreignField: '_id', as: 'result'}}",
            "{ $unwind: { path: '$result' } }",
            "{ $project: {_id: 0, usuario: '$result.credenciales.username', fotoPerfil: '$result.fotoPerfil', nombre: '$result.nombreCompleto', descripcion: '$result.descripcion', proyectos: 1}}"
    })
    List<UsuariosProyectosDTO> obtenerUsuariosConSusProyectos();

 
    @Aggregation(pipeline = {
            "{ $lookup: { from: 'Usuarios', localField: 'usuarioId', foreignField: '_id', as: 'usuario' }}",
            "{ $unwind: '$usuario' }",
            "{ $project: {_id: 0, tipoCultivo: 1, estado: 1, multimedia: 1, colaboradores: 1, descripcion: 1, usuario: {nombre: '$usuario.nombreCompleto', fotoPerfil: '$usuario.fotoPerfil'}}}"
    })
    List<ProyectoDetallesDTO> obtenerDetalleProyectos();
}

