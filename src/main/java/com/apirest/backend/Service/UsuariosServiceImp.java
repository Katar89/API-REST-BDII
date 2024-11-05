package com.apirest.backend.Service;


import com.apirest.backend.Model.PerfilesUsuariosViews;
import com.apirest.backend.Model.UsuariosModel;
import com.apirest.backend.Repository.IPerfilesUsuariosRepository;
import com.apirest.backend.Repository.IUsuariosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImp implements IUsuariosService {

    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private IPerfilesUsuariosRepository perfilesUsuarioRepository;

    @Override
    public String crearUsuario(UsuariosModel usuario) {
        usuariosRepository.save(usuario);
        return String.format("El usuario %s con ID %s ha sido creado con éxito.", usuario.getNombreCompleto(), usuario.getId());
    }

    @Override
    public List<UsuariosModel> obtenerUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public UsuariosModel obtenerUsuarioPorId(ObjectId id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public List<PerfilesUsuariosViews> obtenerPerfilesUsuario() {
        return perfilesUsuarioRepository.findAll();
    }

    @Override
    public String eliminarUsuario(ObjectId id) {
        if (usuariosRepository.existsById(id)) {
            usuariosRepository.deleteById(id);
            return String.format("El usuario con ID %s ha sido eliminado con éxito.", id.toHexString());
        }
        return String.format("El usuario con ID %s no existe y no se pudo eliminar.", id.toHexString());
    }

    @Override
    public String quitarUsuarioDeAmistades(ObjectId id) {
        Query query = new Query();  // Sin filtros para actualizar todos los documentos
        Update update = new Update().pull("amigos", id);
        mongoTemplate.updateMulti(query, update, UsuariosModel.class);
        return String.format("El usuario con ID %s ha sido eliminado de las listas de amigos.", id.toHexString());
    }
}
