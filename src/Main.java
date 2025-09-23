
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Daniel Marín
 */
import java.util.Scanner;
import sisGestion.controller.adminController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        adminController adminController = new adminController(sc);

        adminController.interactiveEmployeeCreation();

        System.out.println("MUCHAS GRACIAS, NOS VEMOS PRONTO!");
    }
}

