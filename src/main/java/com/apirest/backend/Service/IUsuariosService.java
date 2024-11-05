package com.apirest.backend.Service;

import com.apirest.backend.Model.PerfilesUsuariosViews;
import com.apirest.backend.Model.UsuariosModel;
import org.bson.types.ObjectId;
import java.util.List;

public interface IUsuariosService {
    
    String crearUsuario(UsuariosModel usuario);                    // Crear un nuevo usuario
    List<UsuariosModel> obtenerUsuarios();                         // Obtener todos los usuarios
    UsuariosModel obtenerUsuarioPorId(ObjectId id);                // Obtener un usuario por ID
    List<PerfilesUsuariosViews> obtenerPerfilesUsuario();            // Obtener todos los perfiles de usuario
    String eliminarUsuario(ObjectId id);                           // Eliminar un usuario por ID
    String quitarUsuarioDeAmistades(ObjectId id);                  // Quitar usuario de las listas de amigos de otros usuarios
}
