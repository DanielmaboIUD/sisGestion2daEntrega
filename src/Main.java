
import sisGestion.controller.adminController;
import sisGestion.controller.departmentController;
import sisGestion.controller.reportController;
import sisGestion.model.Department;
import sisGestion.model.Employee;
import sisGestion.model.Metric;
import sisGestion.model.Report;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Daniel Marín
 */
public class Main {
    public static void main(String[] args) {

        // Controladores
        adminController adminCtrl = new adminController();
        departmentController deptCtrl = new departmentController();
        reportController reportCtrl = new reportController();

        // ====== EMPLEADOS ======
        System.out.println("=== Creación de empleados ===");
        Employee emp1 = adminCtrl.createEmployee("PERM", "Ana", "CC", 1001,
                "ana@mail.com", 28, "2022-05-01", "Mensual", "8-5", "Indefinido");
        Employee emp2 = adminCtrl.createEmployee("TEMP", "Carlos", "CC", 1002,
                "carlos@mail.com", 35, "2024-01-15", "Quincenal", "7-4", "Temporal");

        System.out.println("Empleado 1: " + emp1);
        System.out.println("Empleado 2: " + emp2);

        // ====== DEPARTAMENTOS ======
        System.out.println("\n=== Creación de departamentos ===");
        Department itDept = deptCtrl.createDepartment("IT", "Laura");
        Department hrDept = deptCtrl.createDepartment("Recursos Humanos", "Miguel");

        System.out.println("Departamento IT: " + itDept.getName());
        System.out.println("Departamento RRHH: " + hrDept.getName());

        // Asignar empleados a departamentos
        adminCtrl.assignEmployeeToDepartment(emp1, itDept);
        adminCtrl.assignEmployeeToDepartment(emp2, hrDept);

        System.out.println("\nEmpleados en IT:");
        itDept.listEmployees();
        System.out.println("\nEmpleados en RRHH:");
        hrDept.listEmployees();

        // ====== REPORTES ======
        System.out.println("\n=== Creación de reportes ===");
        Report r1 = reportCtrl.createReport("Reporte IT", "Indicadores técnicos",
                "PDF", "2025-09-20", "Septiembre");

        Metric m1 = new Metric("Productividad", "Tareas completadas",
                "Porcentaje de tareas completadas en el mes", "%", 85.5);
        Metric m2 = new Metric("Asistencia", "Asistencia del personal",
                "Registro de asistencia mensual", "%", 92.0);

        reportCtrl.addMetricToReport(r1, m1);
        reportCtrl.addMetricToReport(r1, m2);

        System.out.println("\nReporte creado: " + r1.getTitle());
        System.out.println("Métricas del reporte:");
        System.out.println(r1.showMetric());
    }
