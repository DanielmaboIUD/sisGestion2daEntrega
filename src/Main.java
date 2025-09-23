
import java.util.Scanner;
import sis.Gestion.helper.CreateNewEmployee;
import sisGestion.controller.adminController;
import sisGestion.controller.departmentController;
import sisGestion.controller.reportController;
import sisGestion.model.Department;
import sisGestion.model.Employee;
import sisGestion.model.Metric;
import sisGestion.model.Report;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Daniel Marín
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        adminController adminController = new adminController();
        CreateNewEmployee helper = new CreateNewEmployee(sc, adminController);

        boolean continuar = true;

        while (continuar) {
            Employee emp = helper.crearEmpleadoInteractivo();
            System.out.println("Empleado creado:\n" + emp);

            System.out.print("¿Desea crear otro empleado? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        System.out.println("=== Programa finalizado ===");
    }
}
