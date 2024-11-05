package com.apirest.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("PerfilesUsuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilesUsuariosViews {

    private String nombreCompleto;                // Nombre completo del usuario
    private String fotoPerfil;                    // URL de la foto de perfil del usuario
    private String descripcion;                   // Breve descripción o biografía del usuario
    private List<PerfilesUsuariosViews> seguidores;     // Lista de seguidores 
    private List<ProyectosModel> proyectos;       // Lista de proyectos del usuario
}

