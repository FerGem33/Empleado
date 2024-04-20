package Unidad5.Excepciones2.Empleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpleadoTest{
    public static int readInt(String message, String title){
        while(true){
            try{
                int x = Integer.parseInt(JOptionPane.showInputDialog(null, message, title, 3));
                return x;
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero", 
                    "Error de entrada", 0);
            }
        }
    }
    public static double readDouble(String message, String title){
        while(true){
            try{
                double x = Double.parseDouble(JOptionPane.showInputDialog(null, message, title, 3));
                return x;
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe ingresar un número", 
                    "Error de entrada", 0);
            }
        }
    }

    public static Empleado generar(int tipo){
        String title = "Dar de alta nuevo empleado";
        int num = readInt("Número", title);
        String nombre = JOptionPane.showInputDialog("Nombre");
        int antiguedad = readInt("Antigüedad", title);
        double pagoPorHora = readDouble("Pago por hora", title);
        double horasTrabajadas = readDouble("Horas trabajadas", title);
        
        switch(tipo){
            case 0:{
                return new EmpleadoDocente(num, nombre, antiguedad, pagoPorHora, horasTrabajadas);
            }
            case 1:{
                return new EmpleadoTemporal(num, nombre, antiguedad, pagoPorHora, horasTrabajadas);
            }
            case 2:{
                return new EmpleadoManual(num, nombre, antiguedad, pagoPorHora, horasTrabajadas);
            }
        } return null;
    }
    public static void main(String[] args){
        Object selectedVal = "";

        int x;
        boolean encontrado;
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        
        Object[] menu = {"Empleado docente", "Empleado temporal", "Empleado manual", "Mostrar empleados", "Borrar empleado", "Terminar"};
        
        while(selectedVal != "Terminar"){
            selectedVal = JOptionPane.showInputDialog(null, "Seleccione la opción deseada.",
                                                                        "Menú", 3, null, menu, menu[0]);
            switch((String)selectedVal){
                case "Empleado docente":{  
                    empleados.add(generar(0));
                    break;
                }
                case "Empleado temporal":{
                    empleados.add(generar(1));
                    break;
                }
                case "Empleado manual":{
                    empleados.add(generar(2));
                    break;
                }
                case "Mostrar empleados":{
                    for(Empleado e: empleados){
                        JOptionPane.showMessageDialog(null, e.mostrarEmpleado());
                    }
                    break;
                }
                case "Borrar empleado":{
                    x = readInt("Número de empleado", "Eliminar empleado");
                    encontrado = false;
                    for(int i=0; i<empleados.size() && !encontrado; i++){
                        if(x == empleados.get(i).get_numero()){
                            if(JOptionPane.showConfirmDialog(null,
                                "¿Está seguro que desea borrar?\n" + empleados.get(i).mostrarEmpleado(), "Confirmar", 1, 2)==0){
                                empleados.remove(i);
                                encontrado = true;
                            }
                        }
                    }
                    if(!encontrado){
                        JOptionPane.showMessageDialog(null, "No fue posible borrar el empleado");
                    } break;
                }
            }
        }
    }
}