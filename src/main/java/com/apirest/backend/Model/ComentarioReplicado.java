package com.apirest.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioReplicado {
    private ObjectId usuarioId;    // ID del usuario que hace la réplica
    private String texto;          // Contenido del comentario replicado
    private Date fecha;            // Fecha y hora en la que se hizo la réplica

    // Convertir ObjectId a String para facilitar la visualización en JSON (opcional)
    public String getUsuarioIdAsString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }
}

