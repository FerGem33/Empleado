package Unidad5.Excepciones2.Empleado;

public class EmpleadoManual extends Empleado{
    public EmpleadoManual(int num, String nombre, int antiguedad, double pagoPorHora, double horasTrabajadas){
        super(num, nombre, antiguedad, pagoPorHora, horasTrabajadas);
        calcularSueldo();
    }
    
    public void calcularSueldo(){
        sueldo = get_pagoPorHora() * get_horasTrabajadas() * 0.80;
    }
}