/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.controller;

import sisGestion.model.Department;
import sisGestion.model.Employee;
import sisGestion.model.PermEmployee;
import sisGestion.model.Report;
import sisGestion.model.TempEmployee;

/**
 *
 * @author Daniel Marín
 */
public class adminController {

    // Crear empleado según tipo
    public Employee createEmployee(String tipoEmpleado,
                                   String name, String documentType, int documentNumber,
                                   String email, int age, String entryDate,
                                   String payment, String schedule, String contractType) {

        if (tipoEmpleado.equalsIgnoreCase("PERM")) {
            return new PermEmployee(name, documentType, documentNumber, email, age,
                                    entryDate, payment, schedule, contractType, "Salud y Pensión");
        } else if (tipoEmpleado.equalsIgnoreCase("TEMP")) {
            return new TempEmployee(name, documentType, documentNumber, email, age,
                                    entryDate, payment, schedule, contractType, "2025-12-31");
        } else {
            throw new IllegalArgumentException("Tipo de empleado no válido: " + tipoEmpleado);
        }
    }

    // Crear departamento
    public Department createDepartment(String name, String departmentHead) {
        return new Department(name, null, departmentHead);
    }

    // Asignar empleado a un departamento
    public boolean assignEmployeeToDepartment(Employee employee, Department department) {
        return department.addEmployee(employee);
    }

    // Crear reporte
    public Report createReport(String title, String description, String format,
                               String reportDate, String period) {
        return new Report(0, title, description, format, reportDate, period);
    }
}
