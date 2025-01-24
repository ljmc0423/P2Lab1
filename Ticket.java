/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 *
 * @author ljmc2
 */
public class Ticket {
    private String nombre;
    private double total;
    public Ticket(String nombre, double total){
        this.nombre=nombre;
        this.total=total;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotal() {
        return total;
    }

    public void print(){
        System.out.println("Pasajero: "+nombre+" - Total pagado: $"+total);
    }
}
