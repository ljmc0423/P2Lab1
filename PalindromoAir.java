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
        
    }
    
    public double income(){
        
    }
    
    public void reset(){
        
    }
    
    public void sellTicket(String name){
        
    }
    
    public boolean cancelTicket(String name){
        
    }
    
    public void dispatch(){
        
    }
    
    
}
