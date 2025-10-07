/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import sisGestion.controller.AdminController;
import sisGestion.controller.DepartmentController;
import sisGestion.model.Department;
import sisGestion.model.Employee;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class AppView {
      private final AdminController adminController;
    private final DepartmentController departmentController;
    private final Scanner scanner;

    public AppView(AdminController AdminController, DepartmentController DepartmentController, Scanner scanner) {
        this.adminController = AdminController;
        this.departmentController = DepartmentController;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            showMainMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1 -> handleCreateDepartment();
                case 2 -> handleCreateEmployee();
                case 3 -> handleAssignEmployee();
                case 4 -> handleShowReports();
                case 5 -> {
                    System.out.println("\nGracias por usar el sistema. ¡Adiós! 👋");
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private void showMainMenu() {
        System.out.println("\nBIENVENIDO A SISGESTIÓN, QUÉ DESEAS HACER?");
        System.out.println("1. Crear nuevo departamento");
        System.out.println("2. Crear nuevo empleado");
        System.out.println("3. Asignar empleado a un departamento");
        System.out.println("4. Ver reportes");
        System.out.println("5. Salir");
        System.out.println("==========================");
        System.out.print("Por favor, elija una opción: ");
    }

    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar el buffer del scanner
            return -1; // Retorna un valor inválido para que el switch muestre el error
        }
    }

    private void handleCreateDepartment() {
        System.out.println("\n--- Creación de Departamento ---");
        System.out.print("Ingrese el nombre del nuevo departamento: ");
        String name = scanner.nextLine();
        departmentController.createDepartment(name);
    }

    private void handleCreateEmployee() {
        System.out.println("\n--- Creación de Empleado ---");
        adminController.interactiveEmployeeCreation();
    }
    private void handleAssignEmployee() {
        System.out.println("\n--- Asignar Empleado a Departamento ---");
        
        List<Employee> employees = adminController.getEmployees();
        List<Department> departments = departmentController.getDepartments();

        if (employees.isEmpty() || departments.isEmpty()) {
            System.out.println("Error: Debe existir al menos un empleado y un departamento.");
            return;
        }

        // 1. Seleccionar Departamento
        System.out.println("Departamentos disponibles:");
        departments.forEach(dept -> System.out.println("  ID: " + dept.getCode() + " - Nombre: " + dept.getName()));
        System.out.print("Ingrese el ID del departamento: ");
        int deptId = getUserChoice();
        Department selectedDept = departmentController.findDepartmentByCode(deptId);

        if (selectedDept == null) {
            System.out.println("Departamento no encontrado.");
            return;
        }

        // 2. Seleccionar Empleado
        System.out.println("\nEmpleados disponibles:");
        employees.forEach(emp -> System.out.println("  ID: " + emp.getCode() + " - Nombre: " + emp.getName()));
        System.out.print("Ingrese el ID del empleado a asignar: ");
        int empId = getUserChoice();
        Employee selectedEmp = adminController.findEmployeeByCode(empId);
        
        if (selectedEmp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        // 3. Asignar
        if (departmentController.addEmployeeToDepartment(selectedDept, selectedEmp)) {
            System.out.println("\n✅ ¡Éxito! Empleado '" + selectedEmp.getName() + "' asignado al departamento '" + selectedDept.getName() + "'.");
        } else {
            System.out.println("\nOcurrió un error al asignar el empleado.");
        }
    }
    
    private void handleShowReports() {
        System.out.println("\n--- Menú de Reportes ---");
        System.out.println("1. Ver empleados por departamento");
        System.out.println("2. Ver información detallada de un empleado");
        System.out.println("3. Volver al menú principal");
        System.out.print("Elija una opción: ");
        
        int choice = getUserChoice();
        switch (choice) {
            case 1 -> reportByDepartment();
            case 2 -> reportByEmployee();
            case 3 -> System.out.println("Volviendo al menú principal...");
            default -> System.out.println("Opción no válida.");
        }
    }

    private void reportByDepartment() {
        System.out.println("\n--- Reporte por Departamento ---");
        List<Department> departments = departmentController.getDepartments();
        if (departments.isEmpty()) {
            System.out.println("No hay departamentos creados.");
            return;
        }
        
        System.out.println("Departamentos disponibles:");
        departments.forEach(dept -> System.out.println("  ID: " + dept.getCode() + " - Nombre: " + dept.getName()));
        System.out.print("Ingrese el ID del departamento para ver su reporte: ");
        int deptId = getUserChoice();
        Department selectedDept = departmentController.findDepartmentByCode(deptId);
        
        if (selectedDept == null) {
            System.out.println("Departamento no encontrado.");
            return;
        }
        
        System.out.println("\n--- Empleados en " + selectedDept.getName() + " ---");
        if (selectedDept.getEmployees().isEmpty()) {
            System.out.println("Este departamento no tiene empleados asignados.");
        } else {
            selectedDept.listEmployees();
        }
        System.out.println("---------------------------------");
    }

    private void reportByEmployee() {
        System.out.println("\n--- Reporte por Empleado ---");
        List<Employee> employees = adminController.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("No hay empleados creados.");
            return;
        }
        
        System.out.println("Empleados disponibles:");
        employees.forEach(emp -> System.out.println("  ID: " + emp.getCode() + " - Nombre: " + emp.getName()));
        System.out.print("Ingrese el ID del empleado para ver sus detalles: ");
        int empId = getUserChoice();
        Employee selectedEmp = adminController.findEmployeeByCode(empId);
        
        if (selectedEmp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        
        System.out.println("\n--- Detalles del Empleado ---");
        System.out.println(selectedEmp.toString());
        System.out.println("-----------------------------");
    }
}
