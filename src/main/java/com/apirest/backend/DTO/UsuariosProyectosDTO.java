package com.apirest.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosProyectosDTO {
    private String nombre;                      // Nombre del usuario
    private String fotoPerfil;                  // Foto de perfil del usuario
    private List<String> nombresProyectos = new ArrayList<>();  // Nombres de los proyectos del usuario
}

