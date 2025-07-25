/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author ljmc2
 */
public class PalindromoAir {

    private Ticket[] asientos = new Ticket[30];
    private final double PRECIO_BASE = 100.0;

    public int firstAvailable(int index) {
        if (index >= asientos.length) {
            return -1;
        }
        return (asientos[index] == null) ? index : firstAvailable(index + 1);
    }

    public int searchPassenger(String nombre, int index) {
        if (index >= asientos.length) {
            return -1;
        }
        if (asientos[index] != null && asientos[index].getName().equalsIgnoreCase(nombre)) {
            return index;
        }
        return searchPassenger(nombre, index + 1);
    }

    public boolean isPalindromo(String nombre) {
        nombre = nombre.replaceAll("\\s+", "").toLowerCase();
        return isPalindromoRec(nombre, 0, nombre.length() - 1);
    }

    private boolean isPalindromoRec(String nombre, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (nombre.charAt(i) != nombre.charAt(j)) {
            return false;
        }
        return isPalindromoRec(nombre, i + 1, j - 1);
    }

    public void printPassengers(int index, JTextArea area) {
        if (index >= asientos.length) {
            return;
        }
        if (asientos[index] != null) {
            area.append("Asiento " + index + ":\n" + asientos[index].print() + "\n\n");
        }
        printPassengers(index + 1, area);
    }

    public double income(int index) {
        if (index >= asientos.length) {
            return 0;
        }
        return (asientos[index] != null ? asientos[index].getFinalAmount() : 0) + income(index + 1);
    }

    public void reset(int index) {
        if (index >= asientos.length) {
            return;
        }
        asientos[index] = null;
        reset(index + 1);
    }

    public void sellTicket(String nombre, JButton[] botones, JTextArea areaMensajes) {
        int pos = firstAvailable(0);
        if (pos == -1) {
            areaMensajes.setText("Avión lleno. No se puede vender más boletos.");
            return;
        }

        boolean esPal = isPalindromo(nombre);
        Ticket ticket = new Ticket(nombre, PRECIO_BASE, esPal);
        asientos[pos] = ticket;

        botones[pos].setBackground(esPal ? Color.BLUE : Color.RED);
        areaMensajes.setText("Ticket vendido. Monto pagado: $" + ticket.getFinalAmount());
    }

    public boolean cancelTicket(String nombre, JButton[] botones, JTextArea areaMensajes) {
        int pos = searchPassenger(nombre, 0);
        if (pos == -1) {
            areaMensajes.setText("Pasajero no encontrado.");
            return false;
        }
        asientos[pos] = null;
        botones[pos].setBackground(Color.GREEN);
        areaMensajes.setText("Boleto cancelado exitosamente.");
        return true;
    }

    public void dispatch(JButton[] botones, JTextArea areaMensajes) {
        double total = income(0);
        areaMensajes.setText("Total recaudado: $" + total + "\nSistema reiniciado.");
        reset(0);
        for (JButton b : botones) {
            b.setBackground(Color.GREEN);
        }
    }
}
