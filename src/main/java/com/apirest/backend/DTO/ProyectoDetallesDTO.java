package com.apirest.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDetallesDTO {
    private String tipoCultivo;                // Tipo de cultivo del proyecto
    private String estado;                     // Estado actual del proyecto
    private List<String> nombresColaboradores = new ArrayList<>();  // Nombres de los colaboradores
}

