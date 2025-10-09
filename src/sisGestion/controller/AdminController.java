/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sis.Gestion.helper.CreateNewEmployee;
import sis.Gestion.helper.CreateNewEmployee.EmployeeData;
import sisGestion.model.Employee;
import sisGestion.model.PermEmployee;
import sisGestion.model.TempEmployee;
import sisGestion.model.EmployeeType;
import sisGestion.model.Department;


public class AdminController {
    private final List<Employee> employees = new ArrayList<>();
    private final CreateNewEmployee helper;
    private final Scanner sc;
    private final DepartmentController departmentController;

    public AdminController(Scanner sc,DepartmentController departmentController) {
        this.sc = sc;
        this.helper = new CreateNewEmployee(sc);
        this.departmentController = departmentController;
    }

    private Employee createEmployee(EmployeeData data) {
        Employee emp = null;

        switch (data.type) {
            case TEMPORAL -> emp = new TempEmployee(
                    data.name, data.documentType, data.documentNumber, data.email, data.age,
                    data.entryDate, data.payment, data.schedule, data.contractType, data.extraAttribute
            );
            case PERMANENTE -> emp = new PermEmployee(
                    data.name, data.documentType, data.documentNumber, data.email, data.age,
                    data.entryDate, data.payment, data.schedule, data.contractType, data.extraAttribute
            );
        }

        if (emp != null) {
            employees.add(emp);
        }
        return emp;
    }

    
    public void interactiveEmployeeCreation() {
        boolean continuar = true;

        while (continuar) {
            EmployeeData data = helper.collectEmployeeData();
            Employee emp = createEmployee(data);

            System.out.println("Empleado creado: " + emp);

            System.out.print("¿Desea crear otro empleado? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }
        
        System.out.println("\nESTOS FUERON LOS EMPLEADOS CREADOS");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    
    public Employee findEmployeeByCode(int code) {
        for (Employee emp : employees) {
            if (emp.getCode() == code) {
                return emp;
            }
        }
        return null;
    }
    public void createEmployeeFromUI(String name, String documentType, int documentNumber, String email, int age,
                                 String entryDate, String payment, String schedule,
                                 EmployeeType type, String extraAttribute, Department selectedDepartment) {
    Employee emp = null;

    if (type == EmployeeType.TEMPORAL) {
        emp = new TempEmployee(name, documentType, documentNumber, email, age,
                               entryDate, payment, schedule, "TEMPORAL", extraAttribute);
    } else {
        emp = new PermEmployee(name, documentType, documentNumber, email, age,
                               entryDate, payment, schedule, "PERMANENTE", extraAttribute);
    }

    if (emp != null) {
        employees.add(emp);
        System.out.println("Empleado creado desde la GUI: " + emp.getName());
         if (selectedDepartment != null) {
                departmentController.addEmployeeToDepartment(selectedDepartment, emp);
                System.out.println("Asignado al departamento: " + selectedDepartment.getName());
            }
    }
    }
    
    public boolean eliminarEmpleado(int id) {
    Employee empleadoAEliminar = findEmployeeByCode(id);
    if (empleadoAEliminar != null) {
        departmentController.removeEmployeeFromAllDepartments(empleadoAEliminar);
        
        return employees.remove(empleadoAEliminar);
    }
        return false;
    }
    
// En la clase: sisGestion.controller.AdminController.java

public void actualizarEmpleado(int id, String nombre, String documentType, int documentNumber, String email, int age,
                               String entryDate, String payment, String schedule,
                               EmployeeType type, String extraAttribute, Department nuevoDepartamento) {
    
    // 1. Encontrar el empleado que queremos actualizar en nuestra lista
    Employee empleadoAActualizar = findEmployeeByCode(id);

    if (empleadoAActualizar != null) {
        empleadoAActualizar.setName(nombre);
        empleadoAActualizar.setDocumentType(documentType);
        empleadoAActualizar.setDocumentNumber(documentNumber);
        empleadoAActualizar.setEmail(email);
        empleadoAActualizar.setAge(age);
        empleadoAActualizar.setEntryDate(entryDate);
        empleadoAActualizar.setPayment(payment);
        empleadoAActualizar.setSchedule(schedule);
        empleadoAActualizar.setContractType(type.toString());

        if (empleadoAActualizar instanceof sisGestion.model.PermEmployee perm) {
            perm.setBenefits(extraAttribute);
        } else if (empleadoAActualizar instanceof sisGestion.model.TempEmployee temp) {
            temp.setOutDate(extraAttribute);
        }


        departmentController.removeEmployeeFromAllDepartments(empleadoAActualizar);
        if (nuevoDepartamento != null) {
            departmentController.addEmployeeToDepartment(nuevoDepartamento, empleadoAActualizar);
        }
        
        System.out.println("Empleado actualizado: " + empleadoAActualizar.getName());
    }
}
}
