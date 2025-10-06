/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class Department {
    
    private static int autoIncrementDepartment=1;
    private int code;
    private String name;
    private List<Employee> employees;
    private Employee departmentHead;
    
    public Department(String name) {
        this.code = Department.autoIncrementDepartment;
        this.name = name;
        this.departmentHead = null;
        this.employees = new ArrayList<>();
        autoIncrementDepartment++;
    }
    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(Employee departmentHead) {
        this.departmentHead = departmentHead;
    }
    
    public boolean addEmployee(Employee employee) {
        return this.employees.add(employee);
    }
    
    public void listEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
    
    public Employee searchEmployee(Employee employee) {
        for (Employee searchEmp : employees) {
            if (searchEmp.equals(employee)) {
                return searchEmp;
            }
        }
        return null;
    }
    
    public Employee searchEmployeeByCode(int code) {
        for (Employee searchEmp : employees) {
            if (searchEmp.getCode() == code) {
                return searchEmp;
            }
        }
        return null;
    }
}
