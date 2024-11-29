# Zona Fit - Sistema de Gestión de Membresías de Gimnasio

## Descripción del Proyecto
Zona Fit es una aplicación de consola desarrollada en Java que permite la gestión de membresías de un gimnasio. La aplicación cuenta con un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para administrar los datos de los miembros, incluyendo su nombre, apellido y estado de membresía.

## Tecnologías Utilizadas
- Lenguaje de Programación: Java
- Base de Datos: MySQL

## Estructura del Proyecto
```
zona_fit_app/
├── .idea/
├── src/
│   └── main/
│       ├── java/
│       │   └── zona_fit/
│       │       └────── connection
│       │            │   └── Conexion.java
│       │            ├── datos
│       │            │   ├── ClienteDAO.java
│       │            │   └── ClienteDAOImpl.java
│       │            ├── dominio
│       │            │   └── Cliente.java
│       │            └── Main.java
│       └── resources/
│           
├── target/
├── .gitignore
└── README.md
```

## Funcionalidades
- Agregar nuevos miembros
- Listar miembros
- Busqueda por id
- Actualizar información de miembros
- 
- Eliminar miembros

## Configuración de la Base de Datos
1. Crear la base de datos:
```sql
CREATE DATABASE zona_fit;
USE zona_fit;

CREATE TABLE miembros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    membresia BOOLEAN
);
```

2. Actualizar la clase `MiembroDAO` con los datos de conexión a la base de datos.

## Ejecución
1. Clonar el repositorio
2. Abrir el proyecto en un IDE compatible con Java
3. Ejecutar la clase `Main`

## Contribuciones
Las contribuciones son bienvenidas. Por favor, sigue estos pasos:
1. Haz un fork del repositorio
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`)
3. Realiza tus cambios
4. Haz commit de tus cambios (`git commit -m 'Agregar nueva funcionalidad'`)
5. Sube los cambios a tu fork (`git push origin feature/nueva-funcionalidad`)
6. Abre un Pull Request

## Contacto
Si tienes alguna pregunta o sugerencia, puedes contactarme a través de:
- Correo electrónico: [tu_correo@ejemplo.com]
- GitHub: [tu_usuario_github]