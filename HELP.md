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
------
### Endpoint: /api/jardineria/proyectos
------
Creacion de un proyecto en los registros 
------
Ejemplo:
```
{
  "usuarioId": "6732971bc049b05008e0ef2",
  "tipoCultivo": "Horticultura",
  "estado": "EN_PROGRESO",
  "descripcion": "Este proyecto esta enfocado en el cultivo de vegetales organicos",
  "multimedia":[
    {
      "tipo":"imagen",
      "url":"https://imagen.com"
    },
  ],
  "colaboradores":[
    "6732971bc049b05008e0ef2"
  ]
}

```
------
### Endpoint: /api/jardineria/comentarios
------
Creacion de uno o varios comentarios dentro de un proyecto
------
Ejemplo:
```
{
  "_id": "649f8b0b7b6c1d52d5e0f3d1",
  "proyectoId": "649f8b0b7b6c1d52d5e0f2a1",
  "usuarioId": "649f8b0b7b6c1d52d5e0f2e9",
  "texto": "Este es un comentario sobre el proyecto.",
  "fecha": 2024-11-12T15:00:00Z,
  "replicas": [
    {
      "usuarioId": "649f8b0b7b6c1d52d5e0f3c0",
      "texto": "Muy buen trabajo en este proyecto, me gusta mucho.",
      "fecha": "2024-11-12T15:30:00Z"
    },
    {
      "usuarioId": "649f8b0b7b6c1d52d5e0f3c1",
      "texto": "Estoy de acuerdo, se ve impresionante.",
      "fecha": "2024-11-12T16:00:00Z"
    }
  ],
  "adjuntos": [
    {
      "tipo": "imagen",
      "url": "https://example.com/imagen1.jpg"
    },
    {
      "tipo": "documento",
      "url": "https://example.com/plan_de_trabajo.pdf"
    }
  ]
}


```

