}# Plan de Pruebas Manuales - Sistema de Gestión

Este documento describe una serie de pruebas manuales diseñadas para verificar el correcto funcionamiento de las funcionalidades principales de la aplicación de gestión de empleados.

---

## Prueba 1: Creación y Asignación de un Empleado

**Objetivo:** Verificar que un nuevo empleado puede ser creado y asignado correctamente a un departamento existente, y que los datos se reflejan en ambas tablas.

**Pre-condiciones:**
* La aplicación está en ejecución.
* Debe existir al menos un departamento. Si no existe, créelo primero (ej. "Contabilidad").

**Pasos de Ejecución:**
1.  En la ventana principal, seleccionar la pestaña "EMPLEADOS".
2.  Hacer clic en el botón "Agregar".
3.  En el diálogo "Agregar Nuevo Empleado", llenar todos los campos con datos válidos.
    * **Nombre:** `Carlos Ramírez`
    * **Tipo de Contrato:** `PERMANENTE`
    * **Departamento:** Seleccionar "Contabilidad" de la lista desplegable.
4.  Hacer clic en el botón "Guardar".
5.  Observar el comportamiento de la aplicación.

**Resultados Esperados:**
* El diálogo para agregar empleado se cierra sin errores.
* Aparece un mensaje de confirmación de "Empleado creado exitosamente".
* En la pestaña "EMPLEADOS", una nueva fila aparece en la tabla con los datos de `Carlos Ramírez`.
* En la misma fila, la columna "Departamento" debe mostrar "Contabilidad".

---

## Prueba 2: Edición de un Departamento

**Objetivo:** Verificar que el nombre de un departamento puede ser modificado y que el cambio se visualiza correctamente en ambas tablas.

**Pre-condiciones:**
* La aplicación está en ejecución.
* Debe existir al menos un departamento (ej. "Marketing").
* Opcional: Asignar un empleado al departamento "Marketing" para verificar la actualización en la tabla de empleados.

**Pasos de Ejecución:**
1.  En la ventana principal, seleccionar la pestaña "DEPARTAMENTOS".
2.  Localizar la fila correspondiente al departamento "Marketing".
3.  En la columna "Acciones" de esa fila, hacer clic en el botón "Editar".
4.  En el diálogo "Editar Departamento", el campo "Nuevo nombre" debe estar precargado con "Marketing".
5.  Cambiar el texto a `Marketing y Ventas`.
6.  Hacer clic en el botón "Guardar".

**Resultados Esperados:**
* El diálogo de edición se cierra.
* En la tabla de "DEPARTAMENTOS", el nombre en la fila correspondiente ha cambiado a "Marketing y Ventas".
* Si había un empleado asignado a este departamento, al ir a la pestaña "EMPLEADOS", la columna "Departamento" para ese empleado ahora debe mostrar "Marketing y Ventas".

---

## Prueba 3: Eliminación de un Empleado

**Objetivo:** Verificar que un empleado puede ser eliminado del sistema y que el conteo de empleados en su departamento se actualiza.

**Pre-condiciones:**
* La aplicación está en ejecución.
* Debe existir un empleado con un departamento asignado (ej. `Ana Gómez` en el departamento "Recursos Humanos").

**Pasos de Ejecución:**
1.  Cambiar a la pestaña "EMPLEADOS".
2.  Localizar la fila correspondiente a `Ana Gómez`.
3.  Hacer clic en el botón "Eliminar" en la columna "Acciones" de esa fila.
4.  Aparecerá un diálogo de confirmación. Hacer clic en "Sí" o "Yes".
5.  Observar el comportamiento de las tablas.

**Resultados Esperados:**
* La fila correspondiente a `Ana Gómez` desaparece de la tabla de "EMPLEADOS".

---

## Prueba 4: Edición de un Empleado

**Objetivo:** Verificar que los datos de un empleado, incluyendo su departamento, pueden ser modificados y los cambios se reflejan correctamente en ambas tablas.

**Pre-condiciones:**
* La aplicación está en ejecución.
* Existe un empleado, `Carlos Ramírez`, asignado al departamento "Contabilidad".
* Existe un segundo departamento, "Recursos Humanos".

**Pasos de Ejecución:**
1.  Seleccionar la pestaña "EMPLEADOS".
2.  Localizar la fila de `Carlos Ramírez`.
3.  Hacer clic en el botón "Editar" de esa fila.
4.  En el diálogo "Editar Empleado", que debe aparecer con los datos precargados:
    * Cambiar el campo "Nombre" a `Carlos Ramírez Silva`.
    * Cambiar el "Departamento" de "Contabilidad" a "Recursos Humanos" en la lista desplegable.
5.  Hacer clic en el botón "Guardar".

**Resultados Esperados:**
* Aparece un mensaje de "Empleado actualizado exitosamente".
* En la tabla "EMPLEADOS", la fila del empleado ahora muestra el nombre `Carlos Ramírez Silva` y en la columna "Departamento" se lee `Recursos Humanos`.
