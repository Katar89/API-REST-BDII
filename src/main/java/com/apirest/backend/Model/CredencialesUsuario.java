package com.apirest.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredencialesUsuario {
    private String username;  // Nombre de usuario
    private String password;  // Contraseña
    private String email; // Correo electronico
}

