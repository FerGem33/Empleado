package Unidad5.Excepciones2.Empleado;

public abstract class Empleado{
    private int num;
    private double pagoPorHora, horasTrabajadas;
    protected String nombre;
    protected int antiguedad;
    protected double sueldo;
    
    public Empleado(int num, String nombre, int antiguedad, double pagoPorHora, double horasTrabajadas){
        this.num = num;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.pagoPorHora = pagoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }
    public int get_numero(){
        return num;
    }
    public double get_pagoPorHora(){
        return pagoPorHora;
    }
    public double get_horasTrabajadas(){
        return horasTrabajadas;
    }
    public String mostrarEmpleado(){
        return("Número " + num + "\nNombre " + nombre + "\nAntiguedad " 
            + antiguedad + "\nPago por hora "+ pagoPorHora + "\nHoras trabajadas " + horasTrabajadas + "\nSueldo " + sueldo);
    }
    public abstract void calcularSueldo();
}