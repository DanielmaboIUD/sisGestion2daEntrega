/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.controller;

import java.util.ArrayList;
import java.util.List;
import sisGestion.model.Department;
import sisGestion.model.Employee;

public class DepartmentController {

    private final List<Department> departments = new ArrayList<>();
    
    public Department createDepartment(String name) {
      Department newDepartment = new Department(name);
      this.departments.add(newDepartment);
      System.out.println("Departamento '" + name + "' creado exitosamente.");
        return newDepartment;
    }
       
    public List<Department> getDepartments() {
      return this.departments;
    }
    
    public Department findDepartmentByCode(int code) {
        for (Department dept : departments) {
            if (dept.getCode() == code) {
                return dept;
            }
        }
        return null;
    }
        
    public boolean addEmployeeToDepartment(Department department, Employee employee) {
        return department.addEmployee(employee);
    }


    public boolean removeEmployeeFromDepartment(Department department, Employee employee) {
        return department.getEmployees().remove(employee);
    }

    
    public Employee findEmployeeById(Department department, int code) {
        for (Employee e : department.getEmployees()) {
            if (e.getCode()== code) {
                return e;
            }
        }
        return null;
    }
    public Department findDepartmentOfEmployee(Employee employee) {
    for (Department dept : departments) {
        if (dept.getEmployees().contains(employee)) {
            return dept;
        }
    }
    return null;
    }
    
    public void removeEmployeeFromAllDepartments(Employee employee) {
    for (Department dept : departments) {
        dept.getEmployees().remove(employee);
    }
    }
    
    public boolean actualizarDepartamento(int id, String nuevoNombre) {
    Department depto = findDepartmentByCode(id);
    if (depto != null) {
        depto.setName(nuevoNombre);
        System.out.println("Departamento actualizado a: " + nuevoNombre);
        return true;
    }
    return false;
    }
    
    public Department eliminarDepartamento(int id) {
    Department deptoAEliminar = findDepartmentByCode(id);
    if (deptoAEliminar != null) {
        // Advertencia importante si el departamento tiene empleados
        if (!deptoAEliminar.getEmployees().isEmpty()) {
            int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                null,
                "El departamento '" + deptoAEliminar.getName() + "' tiene empleados asignados.\n" +
                "Eliminarlo los dejará sin departamento. ¿Deseas continuar?",
                "Advertencia",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
            );
            if (respuesta == javax.swing.JOptionPane.NO_OPTION) {
                return null; // El usuario canceló la operación
            }
        }
        departments.remove(deptoAEliminar);
        System.out.println("Departamento eliminado: " + deptoAEliminar.getName());
        return deptoAEliminar;
    }
    return null;
    }
}
