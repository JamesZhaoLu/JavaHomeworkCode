/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3homework;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author jameslu
 */
public class CalculateInterest {
    
   public static void main(String[] args){
       
    
    Scanner in = new Scanner(System.in);
    
        try{
            int years = in.nextInt();
            //Asuming $100 is deposited during year 0
            double deposit = 100.0;
            final float INTEREST = 1.03f;
            final DecimalFormat df = new DecimalFormat( "#.##");
            for (int i = 1; i <= years; i++ ){
                
                //deposit = deposit*INTEREST;
                deposit *= INTEREST;
                
                deposit += 100.0;
               
                //
            }
            df.format(deposit);
            System.out.format("You will have: $%.2f in %d years \n" , deposit, years);
        //PrintStream format = System.out.format("%.2f%n", deposit);
            //System.out.print( " in your account after " + years + " years");
         }catch (Exception e){
            e.printStackTrace();
        } finally{
            in.close();
        }
            
    }
    
    
}
