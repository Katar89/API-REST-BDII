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

@Document("Mensajes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajesModel {

    @Id
    private ObjectId id;
    private ObjectId usuarioReceptorId;           // ID del usuario que recibe el mensaje
    private ObjectId usuarioDestinatarioId;             // ID del usuario que envía el mensaje
    private String texto;                         // Texto del mensaje
    private List<TipoAdjunto> adjuntos = new ArrayList<>();  // Archivos adjuntos en el mensaje

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }

    @JsonProperty("usuarioReceptorId")
    public String getUsuarioReceptorIdAsString() {
        return usuarioReceptorId != null ? usuarioReceptorId.toHexString() : null;
    }

    @JsonProperty("usuarioDestinatarioId")
    public String getUsuarioEmisorIdAsString() {
        return usuarioDestinatarioId != null ? usuarioDestinatarioId.toHexString() : null;
    }
}

