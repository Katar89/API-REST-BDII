package com.apirest.backend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Document("Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {

    @Id
    private ObjectId id;
    private String nombreCompleto;               // Nombre completo del usuario
    private List<DireccionUsuario> direccion;          // Dirección que incluye ubicación detallada
    private String fotoPerfil;                   // URL de la foto de perfil del usuario
    private String descripcion;                  // Breve descripción del usuario
    private List<CredencialesUsuario> credenciales;    // Información de inicio de sesión
    private List<ObjectId> seguidores = new ArrayList<>();   // Lista de IDs de seguidores del usuario
    private List<ObjectId> siguiendo = new ArrayList<>();    // Lista de IDs de usuarios a los que el usuario sigue

    // Convertir ObjectId a String para el campo `id` en la respuesta JSON
    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }

    // Convertir ObjectId a String para el campo `seguidores` en la respuesta JSON
    @JsonProperty("seguidores")
    public List<String> getSeguidoresAsString() {
        return seguidores != null ? seguidores.stream().map(ObjectId::toHexString).collect(Collectors.toList()) : null;
    }

    // Convertir ObjectId a String para el campo `siguiendo` en la respuesta JSON
    @JsonProperty("siguiendo")
    public List<String> getSiguiendoAsString() {
        return siguiendo != null ? siguiendo.stream().map(ObjectId::toHexString).collect(Collectors.toList()) : null;
    }
}

