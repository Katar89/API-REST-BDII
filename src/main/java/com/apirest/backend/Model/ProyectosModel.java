package com.apirest.backend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.stream.Collectors;

import java.util.List;

@Document("Proyectos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectosModel {

    @Id
    private ObjectId id;
    private ObjectId usuarioId;               // ID del usuario que creó el proyecto
    private String tipoCultivo;               // Tipo de cultivo (ej. "Tomates", "Hierbas aromáticas")
    private EstadoProyecto estado;            // Estado del proyecto (ej. "En progreso", "Finalizado")
    private String descripcion;               // Descripción breve del proyecto
    private List<MultimediaProyecto> multimedia;          // URLs de imágenes, videos, etc., relacionados con el proyecto
    private List<ObjectId> colaboradores;     // Lista de IDs de los colaboradores en el proyecto

    // Convertir ObjectId a String para el campo `id` en la respuesta JSON
    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }

    // Convertir ObjectId a String para el campo `usuarioId` en la respuesta JSON
    @JsonProperty("usuarioId")
    public String getUsuarioIdAsString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }

    // Convertir ObjectId a String para el campo `colaboradores` en la respuesta JSON
    @JsonProperty("colaboradores")
    public List<String> getColaboradoresAsString() {
        return colaboradores != null ? colaboradores.stream().map(ObjectId::toHexString).collect(Collectors.toList()) : null;
    }
}

