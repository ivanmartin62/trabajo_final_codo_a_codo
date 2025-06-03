# Proyecto Final - Codo a Codo

Este repositorio contiene una aplicación web sencilla desarrollada para el curso *Codo a Codo*. El proyecto se encuentra dentro de la carpeta `ProyectoFinal` y se construye con **Apache Ant** generando un archivo `WAR` desplegable en cualquier contenedor de servlets compatible con **Jakarta EE 10**.

## Requisitos previos

- **Java 17** o superior.
- **Apache Ant** en el `PATH` (o utilizar el que viene con su IDE).
- **Contenedor de servlets** compatible con **Jakarta EE 10** (por ejemplo, GlassFish 7).
- **Driver MySQL Connector/J** disponible y configurado en `nbproject/project.properties`.
- **MySQL 8** con una base de datos llamada `trabajo_final` y la tabla `usuario` correspondiente.
- Variables de entorno recomendadas:
  - `JAVA_HOME` apuntando al directorio de instalación del JDK.
  - Opcionalmente `DB_HOST`, `DB_NAME`, `DB_USER` y `DB_PASSWORD` para personalizar los datos de conexión en `Coneccion.java`.

## Compilación

1. Ubíquese en la carpeta del proyecto:
   ```bash
   cd ProyectoFinal
   ```
2. Ejecute Ant para compilar y generar el `WAR`:
   ```bash
   ant clean dist
   ```
   Al finalizar encontrará el archivo `dist/ProyectoFinal.war`.

## Despliegue

Copie el `WAR` generado a la carpeta de despliegue de su servidor (por ejemplo, `glassfish/domains/domain1/autodeploy`) o utilice la consola de administración del contenedor para desplegarlo manualmente.

Una vez desplegado podrá acceder a las páginas HTML y al servlet de login a través de la URL correspondiente de su servidor.
