/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

class NovaNit implements Runnable {
    
    Thread t;
    
    NovaNit() {
        //pravi novu dodatnu nit
        t = new Thread (this, "Demonstraciona nit");
        System.out.println("Nit potomka:" + t);
        
    }
    
    //ovo je polazna tacka druge niti
    public void run (){
        
        try{
            
            for(int i = 5; i> 0; i--){
                
                System.out.println("Nit potomka prekinuta.");
                Thread.sleep(500);               
            }
            
        } catch (InterruptedException e){
            
            System.out.println("Nit potomka prekinuta.");
        }
        
        System.out.println("Izlazak iz niti potomka.");
        
    }
    
}

public class PrimerZaNiti {
    
    public static void main (String args[]){
        
        NovaNit nn = new NovaNit(); //pravi novu nit
        
    }
    
}
