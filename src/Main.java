
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Daniel Marín
 */
import java.util.Scanner;
import sisGestion.controller.AdminController;
import sisGestion.controller.DepartmentController;
import sisGestion.vista.AppView;

public class Main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepartmentController departmentController = new DepartmentController();
        AdminController adminController = new AdminController(scanner,departmentController);
        
        
        AppView view = new AppView(adminController, departmentController, scanner);
        
        view.start();
        
        scanner.close();
    }
}

