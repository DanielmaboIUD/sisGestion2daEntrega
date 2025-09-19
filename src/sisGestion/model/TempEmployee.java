/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class TempEmployee extends Employee{
    
    private String outDate;

    public TempEmployee(String name, String documentType, int documentNumber, 
            String email, int age, String entryDate, String payment, 
            String schedule, String contractType, String outDate) {
        super(name, documentType, documentNumber, email, age, entryDate, 
                payment, schedule, contractType);
        
        this.outDate = outDate;
    }
  
    public boolean renewContract(String result){
            if (result.equals(false)){
                return false;
            }
        return true;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }
    
    
}
