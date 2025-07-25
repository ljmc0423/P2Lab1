/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2;

/**
 *
 * @author ljmc2
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp extends JFrame {
    private PalindromoAir sistema = new PalindromoAir();
    private JButton[] botonesAsientos = new JButton[30];
    private JTextField campoNombre = new JTextField(15);
    private JTextArea areaMensajes = new JTextArea(10, 30);

    public MainApp() {
        setTitle("Gestión de Boletos - PalindromoAir");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelAsientos = new JPanel(new GridLayout(6, 5));
        for (int i = 0; i < 30; i++) {
            botonesAsientos[i] = new JButton((i + 1) + "");
            botonesAsientos[i].setBackground(Color.GREEN);
            panelAsientos.add(botonesAsientos[i]);
        }

        JPanel panelControl = new JPanel();
        panelControl.add(new JLabel("Nombre:"));
        panelControl.add(campoNombre);

        JButton vender = new JButton("Sell Ticket");
        JButton cancelar = new JButton("Cancel Ticket");
        JButton despacho = new JButton("Dispatch");
        JButton imprimir = new JButton("Print Passengers");
        JButton buscar = new JButton("Search Passenger");
        JButton ingresos = new JButton("View Income");
        
        panelControl.add(vender);
        panelControl.add(cancelar);
        panelControl.add(despacho);
        panelControl.add(imprimir);
        panelControl.add(buscar);
        panelControl.add(ingresos);

        areaMensajes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaMensajes);

        add(panelAsientos, BorderLayout.CENTER);
        add(panelControl, BorderLayout.NORTH);
        add(scroll, BorderLayout.SOUTH);

        // Acciones
        vender.addActionListener(e -> sistema.sellTicket(campoNombre.getText(), botonesAsientos, areaMensajes));
        cancelar.addActionListener(e -> sistema.cancelTicket(campoNombre.getText(), botonesAsientos, areaMensajes));
        despacho.addActionListener(e -> sistema.dispatch(botonesAsientos, areaMensajes));
        imprimir.addActionListener(e -> {
            areaMensajes.setText("");
            sistema.printPassengers(0, areaMensajes);
        });
        buscar.addActionListener(e -> {
            int pos = sistema.searchPassenger(campoNombre.getText(), 0);
            areaMensajes.setText(pos == -1 ? "Pasajero no encontrado." : "Pasajero en asiento: " + pos);
        });
        ingresos.addActionListener(e -> areaMensajes.setText("Ingresos totales: $" + sistema.income(0)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
