/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.controller;

import sisGestion.model.Department;
import sisGestion.model.Employee;

/**
 *
 * @author Daniel Marín
 */
public class DepartmentController {

    
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
}
