/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class Employee extends User{
    private String entryDate;
    private String payment;
    private String schedule;
    private String contractType;

    public Employee(String name, String documentType, int documentNumber, 
           String email, int age, String entryDate,
           String payment, String schedule, String contractType) {
        super(name, documentType, documentNumber, email, age);
        this.entryDate = entryDate;
        this.payment = payment;
        this.schedule = schedule;
        this.contractType = contractType;

    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
    
    
}
