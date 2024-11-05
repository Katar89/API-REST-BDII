package com.apirest.backend.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("SolicitudesColaboracion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudesColaboracionModel {

    @Id
    private ObjectId id;
    private ObjectId proyectoId;                   // ID del proyecto para el cual se solicita colaboración
    private ObjectId usuarioSolicitanteId;         // ID del usuario que solicita la colaboración
    private ObjectId usuarioReceptorId;            // ID del usuario que recibe la solicitud
    private String descripcion;                    // Descripción de la colaboración solicitada
    private String habilidadesRequeridas;          // Habilidades o conocimientos específicos solicitados
    private Date fechaSolicitud;                   // Fecha en la que se realizó la solicitud
    private EstadoColaboracion estado;             // Estado de la solicitud (Pendiente, Aceptada, Rechazada)

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
}

