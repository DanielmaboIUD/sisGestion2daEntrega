/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

import sisGestion.Interfaces.requestVacations;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class PermEmployee extends Employee implements requestVacations{
    
    private String benefits;
    
    public PermEmployee(String name, String documentType, int documentNumber, 
            String email, int age, String entryDate, String payment, 
            String schedule, String contractType, String benefits) {
        super(name, documentType, documentNumber, email, age, entryDate, payment,
              schedule, contractType);
        
        this.benefits = benefits;
    }
    
    @Override
    public boolean approveVacations(String answer){
        if (answer.equals(false)) {
            return false;
        }
        return true;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
    
    
}
