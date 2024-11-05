package com.apirest.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAdjunto {
    private String tipo;           // Tipo de archivo adjunto (ej. "Imagen", "Video", "Documento")
    private String url;            // URL o ruta del archivo adjunto
}

