package com.apirest.backend.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document("Comentarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentariosModel {

    @Id
    private ObjectId id;
    private ObjectId proyectoId;                  // ID del proyecto al que pertenece el comentario
    private ObjectId usuarioId;                   // ID del usuario que hizo el comentario
    private String texto;                         // Texto del comentario
    private Date fecha;                           // Fecha del comentario
    private List<ComentarioReplicado> replicas = new ArrayList<>();  // Lista de réplicas al comentario
    private List<TipoAdjunto> adjuntos = new ArrayList<>();          // Archivos adjuntos (multimedia)

    public ObjectId getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(ObjectId proyectoId) {
        this.proyectoId = proyectoId;
    }
    
    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }

    @JsonProperty("proyectoId")
    public String getProyectoIdAsString() {
        return proyectoId != null ? proyectoId.toHexString() : null;
    }

    @JsonProperty("usuarioId")
    public String getUsuarioIdAsString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }
}

