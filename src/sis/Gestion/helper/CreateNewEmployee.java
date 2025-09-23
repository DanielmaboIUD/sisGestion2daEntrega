/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sis.Gestion.helper;

import sisGestion.model.Employee;
import java.util.Scanner;
import sisGestion.controller.adminController;
import sisGestion.model.Employee;
import sisGestion.model.EmployeeType;

/**
 *
 * @author Marcela Realpe
 */
public class CreateNewEmployee {
    private Scanner sc;
    private adminController adminController;

    public CreateNewEmployee(Scanner sc, adminController adminController) {
        this.sc = sc;
        this.adminController = adminController;
    }

    public Employee crearEmpleadoInteractivo() {
        System.out.println("=== Crear Empleado ===");
        System.out.println("Seleccione tipo de empleado: ");
        System.out.println("1. Temporal");
        System.out.println("2. Permanente");
        int option = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        EmployeeType type = (option == 1) ? EmployeeType.TEMPORAL : EmployeeType.PERMANENTE;

        // Datos comunes
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Tipo de documento: ");
        String docType = sc.nextLine();
        System.out.print("Número de documento: ");
        int docNum = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Edad: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Fecha de ingreso: ");
        String entryDate = sc.nextLine();
        System.out.print("Pago: ");
        String payment = sc.nextLine();
        System.out.print("Horario: ");
        String schedule = sc.nextLine();
        System.out.print("Tipo de contrato: ");
        String contractType = sc.nextLine();

        String extra;
        if (type == EmployeeType.TEMPORAL) {
            System.out.print("Fecha de salida: ");
            extra = sc.nextLine();
        } else {
            System.out.print("Beneficios: ");
            extra = sc.nextLine();
        }

        return adminController.createEmployee(
                type, name, docType, docNum, email, age,
                entryDate, payment, schedule, contractType, extra);
    }
}

