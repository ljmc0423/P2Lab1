package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Kellyan Escobar, Lorenzo Matta y Mario Vásquez
 */

public class main extends JFrame {
    private PalindromoAir palindromoAir;
    private JTextField campoNombre;
    private JTextArea areaTexto;
    private JButton botonVender;
    private JButton botonCancelar;
    private JButton botonImprimir;
    private JButton botonDespachar;
    private JLabel etiquetaNombre;

    public main() {
        palindromoAir = new PalindromoAir();
        setTitle("PalindromoAir - Gestión de Tickets");
        setSize(520, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        etiquetaNombre = new JLabel("Nombre del pasajero:");
        etiquetaNombre.setBounds(20, 20, 150, 30);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(180, 20, 200, 30);
        add(campoNombre);

        botonVender = new JButton("Vender");
        botonVender.setBounds(400, 20, 80, 30);
        add(botonVender);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(400, 60, 80, 30);
        add(botonCancelar);

        botonImprimir = new JButton("Imprimir");
        botonImprimir.setBounds(20, 60, 100, 30);
        add(botonImprimir);

        botonDespachar = new JButton("Despachar");
        botonDespachar.setBounds(130, 60, 110, 30);
        add(botonDespachar);

        areaTexto = new JTextArea();
        areaTexto.setBounds(20, 110, 460, 180);
        areaTexto.setEditable(false);
        add(areaTexto);

        botonVender.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nombre = campoNombre.getText().trim();
                if (!nombre.isEmpty()){
                    int posLibre=palindromoAir.firstAvailable();
                    if (posLibre==-1){
                        areaTexto.setText("No hay asientos disponibles.\n");
                    }else{
                        double costo=800;
                        if(palindromoAir.isPalindromo(nombre)){
                            costo*=0.8;
                        }
                        palindromoAir.sellTicket(nombre);
                        areaTexto.setText("Se vendió a "+nombre+" por $"+costo+"\n");
                    }
                }else{
                    areaTexto.setText("Ingrese un nombre.\n");
                }
            }
        });

        botonCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nombre = campoNombre.getText().trim();
                if(!nombre.isEmpty()){
                    boolean cancelado=palindromoAir.cancelTicket(nombre);
                    if(cancelado){
                        areaTexto.setText("Se canceló el ticket de "+nombre+"\n");
                    }else{
                        areaTexto.setText("No se encontró el pasajero "+nombre+"\n");
                    }
                }else{
                    areaTexto.setText("Ingrese un nombre.\n");
                }
            }
        });

        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText(obtenerPasajerosRec(0,""));
            }
        });

        botonDespachar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double total=palindromoAir.income();
                areaTexto.setText("Ingreso total del vuelo: $"+total+"\n");
                palindromoAir.dispatch();
                areaTexto.append("Vuelo despachado. Asientos reseteados.\n");
            }
        });
    }

    private String obtenerPasajerosRec(int i, String acumulado){
        if(i >= 30){
            return acumulado;
        }
        Ticket t=palindromoAir.getAsiento(i);
        if(t!=null){
            acumulado+="Asiento "+(i+1)+": "+t.getNombre() 
                         +" - $"+t.getTotal()+"\n";
        }
        return obtenerPasajerosRec(i+1,acumulado);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new main().setVisible(true);
            }
        });
    }
}
