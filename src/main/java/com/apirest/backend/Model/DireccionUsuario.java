package com.apirest.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionUsuario {
    private String barrio;         // Barrio donde reside el usuario
    private int codigoPostal;   // Código postal de la dirección
    private String ciudad;         // Ciudad de residencia
    private String departamento;   // Departamento (o estado) de residencia
}
