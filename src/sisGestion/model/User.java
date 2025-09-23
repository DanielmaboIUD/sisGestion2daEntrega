/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

/**
 *
 * @author DESARROLLOPORTADA
 */
public class User {
    
    private static int incrementIdUser=1;
    private int code;
    private String name;
    private String documentType;
    private int documentNumber;
    private String email;
    private int age;

    public User(String name, String documentType, int documentNumber, String email, int age) {
        this.code=incrementIdUser++;
        this.name = name;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.age = age;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "User{" +
               "code=" + code +
               ", name='" + name + '\'' +
               ", documentType='" + documentType + '\'' +
               ", documentNumber=" + documentNumber +
               ", email='" + email + '\'' +
               ", age=" + age +
               '}';
    }
}
