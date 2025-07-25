/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2;

/**
 *
 * @author ljmc2
 */
public class Ticket {

    private String nombre;
    private double montoFinal;
    private double montoOriginal;
    private boolean esPalindromo;

    public Ticket(String nombre, double precioBase, boolean esPalindromo) {
        this.nombre = nombre;
        this.esPalindromo = esPalindromo;
        this.montoOriginal = precioBase;
        this.montoFinal = esPalindromo ? precioBase * 0.8 : precioBase;
    }

    public String getName() {
        return nombre;
    }

    public double getFinalAmount() {
        return montoFinal;
    }

    public double getOriginalAmount() {
        return montoOriginal;
    }

    public boolean isPalindrome() {
        return esPalindromo;
    }

    public String print() {
        return "Nombre: " + nombre + "\n"
                + "Monto original: $" + montoOriginal + "\n"
                + "Monto pagado: $" + montoFinal + "\n"
                + "Descuento por palíndromo: " + (esPalindromo ? "Sí" : "No");
    }
}
