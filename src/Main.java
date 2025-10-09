
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
import sisGestion.controller.AdminController;
import sisGestion.controller.DepartmentController;
import sisGestion.vista.AppView;

public class Main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminController adminController = new AdminController(scanner);
        DepartmentController departmentController = new DepartmentController();
        
        AppView view = new AppView(adminController, departmentController, scanner);
        
        view.start();
        
        scanner.close();
    }
}

