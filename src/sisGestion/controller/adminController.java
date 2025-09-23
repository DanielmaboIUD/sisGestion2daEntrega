/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.controller;

import sisGestion.model.Department;
import sisGestion.model.Employee;
import sisGestion.model.EmployeeType;
import sisGestion.model.PermEmployee;
import sisGestion.model.Report;
import sisGestion.model.TempEmployee;

/**
 *
 * @author Daniel Marín
 */
public class adminController {

    public Employee createEmployee(EmployeeType type,
                                   String name, String documentType, int documentNumber,
                                   String email, int age, String entryDate,
                                   String payment, String schedule, String contractType,
                                   String extraAttribute) {
        if (type == EmployeeType.TEMPORAL) {
            return new TempEmployee(name, documentType, documentNumber, email, age,
                                    entryDate, payment, schedule, contractType, extraAttribute);
        } else if (type == EmployeeType.PERMANENTE) {
            return new PermEmployee(name, documentType, documentNumber, email, age,
                                    entryDate, payment, schedule, contractType, extraAttribute);
        }
        return null;
    }
}
