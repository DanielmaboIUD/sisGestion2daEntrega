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
}
