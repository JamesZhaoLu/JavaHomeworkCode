/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3homework;

/**
 *
 * @author jameslu
 */
public class FindPi {
    
    public static void main(String[] args){
        double pi = 4.0;
        int counter = 1;
        //after 100 loops
        for (int i = 3; counter <=100; i+= 2){
            
            if (counter %2 == 1){
                pi = pi - (double)(4.0/i);
            }
            else{
                pi = pi + (double)(4.0/i);               
            }
            counter++;
            //System.out.println(counter);
            
        }
        System.out.println(pi);
        
        //how many loops
        double pii = 4.0;
        int iterations = 0;
        int divisor = 3;
        do {
            iterations++;
            if (iterations %2 == 1){
                pii = pii - (double)(4.0/divisor);
            }
            else{
                pii = pii + (double)(4.0/divisor);               
            }
            
            divisor += 2;
            //System.out.println (Math.abs(pii - 3.14159));
            //System.out.println(pii);
        } while(Math.abs(pii - 3.14159)>=0.000004);
        
        System.out.println("It takes " + iterations + " iterations");
        System.out.println(pii);
    }
    
}
