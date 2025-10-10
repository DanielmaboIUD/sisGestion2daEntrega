# Sistema de Gestión de Empleados

Este proyecto es una aplicación de escritorio desarrollada en Java con Swing para la gestión de empleados y departamentos. La aplicación sigue una arquitectura Modelo-Vista-Controlador (MVC) para una clara separación de la lógica de negocio, los datos y la interfaz de usuario.

---

## Funcionalidades Implementadas

El sistema cuenta actualmente con las siguientes funcionalidades, distribuidas en una interfaz gráfica con pestañas.

### Gestión de Empleados
* **Creación:** Permite registrar nuevos empleados, ya sean de tipo `Temporal` o `Permanente`, a través de un formulario detallado.
* **Asignación de Departamento:** Durante la creación de un empleado, es posible asignarlo a un departamento existente a través de una lista desplegable.
* **Edición:** Se puede modificar la información de un empleado existente haciendo clic en el botón "Editar" de la fila correspondiente. Esto abre un formulario precargado con los datos del empleado.
* **Eliminación:** Es posible eliminar un empleado del sistema. La acción requiere confirmación y desvincula al empleado de cualquier departamento al que perteneciera.
* **Visualización:** Todos los empleados se listan en una tabla que muestra su información clave, incluyendo el departamento asignado.

### Gestión de Departamentos
* **Creación:** Permite registrar nuevos departamentos.
* **Edición:** Se puede modificar el nombre de un departamento existente.
* **Eliminación:** Es posible eliminar un departamento. El sistema emite una advertencia si el departamento tiene empleados asignados antes de proceder.
* **Visualización:** Todos los departamentos se listan en una tabla que muestra su ID, nombre y el número de empleados que contiene.

### Interfaz de Usuario
* Interfaz gráfica de escritorio construida con el framework Java Swing.
* Navegación por pestañas para separar la gestión de empleados y la de departamentos.
* Botones de acción ("Editar", "Eliminar") integrados directamente en cada fila de las tablas para una gestión intuitiva de los registros.

---

## Ejecución del Programa

Existen dos métodos para ejecutar la aplicación y visualizar la interfaz gráfica.

### Método 1: Ejecución Gráfica desde un IDE

Este es el método estándar para ejecutar la aplicación durante el desarrollo y ver la interfaz gráfica.

1.  Importar el proyecto en un entorno de desarrollo integrado (IDE) como NetBeans, IntelliJ IDEA o Eclipse.
2.  Localizar el archivo que contiene el método de arranque `public static void main(String[] args)`. Dependiendo de su configuración, este archivo puede ser `Main.java` o la propia `VentanaPrincipal.java`.
3.  Hacer clic derecho sobre dicho archivo.
4.  En el menú contextual, seleccionar la opción "Run File" (o "Ejecutar Archivo").
5.  El IDE compilará el proyecto y la ventana principal de la aplicación aparecerá en pantalla.

### Método 2: Ejecución desde la Terminal

Este método permite ejecutar la aplicación sin necesidad de un IDE, pero requiere que el proyecto haya sido previamente compilado en un archivo `.jar` ejecutable.

1.  **Compilar el Proyecto:** Utilice la opción "Clean and Build" (Limpiar y Reconstruir) de su IDE. Esta acción compila el código fuente y empaqueta la aplicación en un archivo `.jar` dentro de una carpeta llamada `dist`, ubicada en el directorio raíz del proyecto.

2.  **Abrir una Terminal:** Abra una terminal (en Linux/macOS) o un Símbolo del sistema (en Windows).

3.  **Navegar al Directorio:** Utilice el comando `cd` para navegar hasta la carpeta `dist` que se generó en el primer paso.
    ```sh
    cd ruta/a/su/proyecto/dist
    ```

4.  **Ejecutar el Archivo JAR:** Inicie la aplicación con el siguiente comando. Reemplace `NombreDelArchivo.jar` con el nombre real de su archivo (por ejemplo, `sisGestion2daEntrega.jar`).
    ```sh
    java -jar NombreDelArchivo.jar
    ```
5.  Al ejecutar el comando, la interfaz gráfica de la aplicación se iniciará.