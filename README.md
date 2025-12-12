Proyecto Backend — API REST con Spring Boot, JWT, Roles y CRUD Profesional

Este es un proyecto Backend completo desarrollado con Spring Boot, siguiendo buenas prácticas profesionales y estandares usados en entornos reales.
Incluye autenticación segura con JWT, gestión de usuarios con roles, manejo de tareas por usuario uso de DTO´s y arquitectura por capas para asegurar escalabilidad y mantenibilidad.

Tecnologías utilizadas:

Java 17
Spring Boot 3+
Spring Security con JWT
Spring Web
Spring Data JPA
MySQL
Lombok
Maven


Características principales:

*Sistema de autenticación y autorización
    Login con JWT token
    Validación de credenciales
    Protección de endpoints según rol
    Obtención de usuario y roles desde el token

*Gestión de usuarios
    Registro de usuarios
    Asignación dinamica de roles: ROLE_USER, ROLE_ADMIN
    CRUD administrativo
    Separación profesional: Controller, Service/ServiceImpl y Repository

*Gestion de tareas por usuario
    Crear tareas
    Editar tareas
    Eliminar tareas
    Listar tareas
    Obtener tareas por ID
    Cada usuario solo puede manejar sus propias tareas

*Uso de DTOs y Mappers
    No se exponen entidades directamente
    Estructura limpia y mantenible

*Respuestas estandarizadas (ApiResponse) incluye:
    -message
    -status
    -data
    -timestamp


Estructura del proyecto:

src/main/java
└── com.diegoflores.jwtapp
├── config/         # Configuración de seguridad (JWT, filtros, CORS)
├── controllers/    # Controladores REST
├── dto/            # DTOs de entrada y salida
├── entities/       # Entidades JPA
├── exceptions/     # Manejo global de errores
├── mapper/         # Conversión Entity <-> DTO
├── repository/     # Interfaces JPA
├── security/       # JWT Provider, filtros, UserDetails
├── service/        # Interfaces de servicio
└── service/impl/   # Implementaciones



Endpoints principales:

Auth
Método	Endpoint	        Descripción
POST	/api/auth/login	    Iniciar sesión y obtener JWT

Users (público / registro)
Método	Endpoint	        Descripción
POST	/api/users/register	Registrar usuario nuevo

Admin (requieren ROLE_ADMIN)
Método	Endpoint	                Descripción
PUT	    /api/admin/users/{id}/roles	Actualizar roles
DELETE	/api/admin/users/{id}	    Eliminar usuario
GET	    /api/admin/users	        Listar usuarios


Ejemplo de Login (Request / Response)

Request:
{
    "username": "diego",
    "password": "123456"
}

Response:
{
    "message": "Login exitoso",
    "status": 200,
    "data": {
        "user": {
            "id": 1,
            "username": "diego",
            "email": "diegoflores@gmail.com",
            "roles": ["ROLE_USER"]
        },
        "token": "JWT_GENERADO_AQUÍ"
    },
    "timestamp": "2025-01-01T00:00:00"
}

Tasks (requieren autenticación con JWT)

    Los endpoint de tareas estan protegidos.
    El usuario solo puede ver, editar y eliminar sus propias tareas.

    GET /api/tasks
        Obtiene todas las tareas del usuario autenticado.
        Response 200:
        [
            {
                "id": 1,
                "titulo": "Comprar comida",
                "descripcion": "Ir al super por verduras",
                "completada": false,
                "fechaCreacion": "2025-01-08T14:21:00"
            }
        ]

    GET /api/tasks/{id}
        Response 200:
        {
            "message": "Tarea obtenida correctamente.",
            "status": 200,
            "data": {
                "id": 1,
                "titulo": "Comprar comida",
                "descripcion": "Ir al super",
                "completada": false
            }
        }

        Response 404:
        {
            "message": "Tarea no encontrada o no pertenece al usuario.",
            "status": 404
        }

    POST /api/tasks
        Request:
        {
            "titulo": "Lavar ropa",
            "descripcion": "Usar ciclo rápido"
        }

        Response 201:
        {
            "message": "Tarea creada con exito.Lavar ropa",
            "status": 201,
            "data": {
                "id": 5,
                "titulo": "Lavar ropa",
                "descripcion": "Usar ciclo rápido",
                "completada": false
            }
        }

    PUT /api/tasks/{id}
        Request:
        {
            "titulo": "Lavar ropa",
            "descripcion": "Secar al sol",
            "completada": true
        }

        Response 200:
        {
            "message": "Tarea actualizada con exito.",
            "status": 200,
            "data": {
                "id": 5,
                "titulo": "Lavar ropa",
                "descripcion": "Secar al sol",
                "completada": true
            }
        }

    DELETE /api/tasks/{id}
        Response 200:
        {
            "message": "Tarea eliminada con éxito.",
            "status": 200
        }



Configuración necesaria en MySQL

CREATE DATABASE jwt_app;

application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/jwt_app
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

app.jwt.secret=YOUR_SECRET_KEY
app.jwt.expiration-in-ms=86400000

# Reemplazar YOUR_DB_USER y YOUR_DB_PASSWORD con credenciales locales

Cómo ejecutar el proyecto:

1.- Clonar el repositorio:
    git clone https://github.com/tuusuario/tu-repo.git

2.- Editar credenciales en application.properties

3.- Ejecutar el proyecto:
    mvn spring-boot:run

4.- Probar la API en Postman


Objetivo del proyecto:

Este proyecto fue creado para demostrar mis habilidades como desarrollador backend, aplicando:

    .Buenas prácticas de arquitectura
    .Seguridad real con JWT
    .DTOs, capas limpias, separación de responsabilidades
    .Código mantenible y escalable
    .Pruebas con Postman

Está listo para integrarse con cualquier frontend o usarse como base para una aplicación más grande.


Autor:

Diego Fernando Flores Reyes
Backend Developer — Spring Boot | Java | APIs Rest | Bases de datos
