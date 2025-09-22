/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

/**
 *
 * @author Daniel Marín
 */
public class Metric {
    
    private static int incrementIdCode=1;
    private int code;
    private String type;
    private String nombre;
    private String description;
    private String unitMeasure;
    private double value;

    public Metric(String type, String nombre, String description, String unitMeasure, double value) {
        this.code = Metric.incrementIdCode;
        this.type = type;
        this.nombre = nombre;
        this.description = description;
        this.unitMeasure = unitMeasure;
        this.value = value;
        incrementIdCode++;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }    
}
