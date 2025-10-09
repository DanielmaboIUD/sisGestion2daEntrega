/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sis.Gestion.helper;

import sisGestion.model.Employee;
import java.util.Scanner;
import sisGestion.controller.AdminController;
import sisGestion.model.Employee;
import sisGestion.model.EmployeeType;

public class CreateNewEmployee {
    private final Scanner sc;

    public CreateNewEmployee(Scanner sc) {
        this.sc = sc;
    }

        public static class EmployeeData {
        public EmployeeType type;
        public String name;
        public String documentType;
        public int documentNumber;
        public String email;
        public int age;
        public String entryDate;
        public String payment;
        public String schedule;
        public String contractType;
        public String extraAttribute;
    }
        
        public EmployeeData collectEmployeeData() {
        EmployeeData data = new EmployeeData();
        
        
        System.out.print("BIENVENIDO AL SISTEMA DE GESION DE EMPLEADOS DE COMPUWORK" + "\n");
        System.out.print("Por favor ingrese los sigueintes datos para crear un empleado:"+ "\n") ;


        System.out.print("Ingrese nombre: ");
        data.name = sc.nextLine();

        System.out.print("Ingrese tipo de documento: ");
        data.documentType = sc.nextLine();

        System.out.print("Ingrese número de documento: ");
        while (true) {
            try {
                data.documentNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número válido para el documento: ");
            }
}

        System.out.print("Ingrese email: ");
        data.email = sc.nextLine();

        System.out.print("Ingrese edad: ");
        while (true) {
            try {
                data.age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número válido para la edad: ");
            }
        }

        System.out.print("Ingrese fecha de ingreso: ");
        data.entryDate = sc.nextLine();

        System.out.print("Ingrese salario: ");
        data.payment = sc.nextLine();

        System.out.print("Ingrese horario: ");
        data.schedule = sc.nextLine();

        System.out.print("Tipo de contrato (TEMPORAL o PERMANENTE): ");
        data.contractType = sc.nextLine().toUpperCase();
        data.type = EmployeeType.valueOf(data.contractType);

        if (data.type == EmployeeType.TEMPORAL) {
            System.out.print("Ingrese fecha de finalización del contrato: ");
            data.extraAttribute = sc.nextLine();
        } else {
            System.out.print("Ingrese beneficios: ");
            data.extraAttribute = sc.nextLine();
        }

        return data;
    }
   
}

