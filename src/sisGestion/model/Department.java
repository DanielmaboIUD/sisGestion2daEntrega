/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

import java.util.List;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class Department {
    
    private static int autoincrementDepartment=1;
    private int code;
    private String name;
    private List<Employee> Employees; 
    private String departmentHead;

    public Department(String name, List Employees, String departmentHead) {
        this.code = Department.autoincrementDepartment;
        this.name = name;
        this.Employees = Employees;
        this.departmentHead = departmentHead;
        autoincrementDepartment++;
    }
    
    
}
