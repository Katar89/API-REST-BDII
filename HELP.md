# Como Iniciar

### Documentaciones de Referencia
Por favor considerar las siguientes documentaciones:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.3.5/reference/using/devtools.html)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/3.3.5/reference/data/nosql.html#data.nosql.mongodb)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)

## Guia
A continuacion se especificara la funcionalidad de los siguientes endpoints:

* POST    -   Añadir nuevo registro. 
* PUT     -   Actualizar registro existente. 
* DELETE  -   Borrar registro existente. 
* GET     -   Obtener registros.  

## POST 
### Descripcion:  
### Endpoint: /api/jardineria/usuarios
------
Objeto Usuario que debe ser añadido a los registros 
------
Ejemplo:
```
{
  "_id": ObjectId("649f8b0b7b6c1d52d5e0f2e9"),
  "nombreCompleto": "Juan Pérez",
  "fotoPerfil": "https://example.com/foto.jpg",
  "descripcion": "Desarrollador de software apasionado por la tecnología.",
  "direccion": [
    {
      "barrio": "Centro",
      "codigoPostal": 12345,
      "ciudad": "Montevideo",
      "departamento": "Montevideo"
    }
  ],
  "credenciales": [
    {
      "username": "juanperez",
      "password": "supersecreta123",
      "email": "juan.perez@example.com"
    }
  ],
  "seguidores": [
    {
      "_id": ObjectId("649f8b0b7b6c1d52d5e0f2e8")
    }
  ],
  "siguiendo": [
    {
      "_id": ObjectId("649f8b0b7b6c1d52d5e0f2e7")
    }
  ]
}

```


