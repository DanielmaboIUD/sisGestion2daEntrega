/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class Admin extends User{
    private String cargo;

    public Admin(String name, String documentType, int documentNumber, String email, int age, String cargo) {
        super(name, documentType, documentNumber, email, age);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
