/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 *
 * @author ljmc2
 */
public class PalindromoAir {
    
    private Ticket[] asientos;

    public PalindromoAir(){
        asientos=new Ticket[30];
    }
    
    public int firstAvailable(){
        return firstAvailableRec(0);
    }

    private int firstAvailableRec(int i){
        if (i>=asientos.length){
            return -1;
        }
        if (asientos[i] == null){
            return i;
        }
        return firstAvailableRec(i+1);
    }

    
    
    public int searchPassenger(String name){
        return searchPassengerRec(name, 0);
    }

    private int searchPassengerRec(String name,int i){
        if(i >= asientos.length){
            return -1;
        }
        if(asientos[i]!=null&&asientos[i].getNombre().equals(name)){
            return i;
        }
        return searchPassengerRec(name,i+1);
    }

    public boolean isPalindromo(String name){
        String n=name.toLowerCase();
        return isPalindromoRec(n,0,n.length()-1);
    }

    private boolean isPalindromoRec(String s,int inicio,int fin){
        if(inicio>=fin){
            return true;
        }
        if(s.charAt(inicio)!=s.charAt(fin)){
            return false;
        }
        return isPalindromoRec(s,inicio+1,fin-1);
    }
    
    public void printPassengers(){
        printPassengersRec(0);
    }

    private void printPassengersRec(int i){
        if(i>=asientos.length){
            return;
        }
        if(asientos[i]!=null){
            asientos[i].print();
        }
        printPassengersRec(i+1);
    }

    public double income(){
        return incomeRec(0);
    }

    private double incomeRec(int i){
        if(i>=asientos.length){
            return 0;
        }
        if(asientos[i]!=null){
            return asientos[i].getTotal()+incomeRec(i+1);
        }
        return incomeRec(i+1);
    }

    public void reset(){
        resetRec(0);
    }

    private void resetRec(int i){
        if(i>=asientos.length){
            return;
        }
        asientos[i]=null;
        resetRec(i+1);
    }

    

    public void sellTicket(String name){
        int pos=firstAvailable();
        if(pos==-1) {
            System.out.println("No hay asientos disponibles.");
            return;
        }
        double costo=800;
        if(isPalindromo(name)){
            costo*=0.8;
        }
        asientos[pos]=new Ticket(name,costo);
        System.out.println("Ticket vendido a "+name+" por $"+costo);
    }

    public boolean cancelTicket(String name){
        int pos=searchPassenger(name);
        if(pos==-1){
            return false;
        }
        asientos[pos]=null;
        return true;
    }

    public void dispatch(){
        double total=income();
        System.out.println("Ingreso total del vuelo: $"+total);
        reset();
    }

    public Ticket getAsiento(int i){
        if(i<0||i>=asientos.length){
            return null;
        }
        return asientos[i];
    }
    
    
}
