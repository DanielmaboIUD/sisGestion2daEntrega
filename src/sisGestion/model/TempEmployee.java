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
    
    public boolean renewContract(boolean c){
         if(c == false){
             return false;
         }
        return true;
    }
    
}
