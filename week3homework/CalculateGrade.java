/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3homework;
import java.util.Scanner;

/**
 *
 * @author jameslu
 */
public class CalculateGrade {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int[] grades = new int[10];
        int counter = 0;
        //could have put this in a method
        //can also divide score by 10 so then you can turn it into a switch statement
        //because 67/10 = 6.7 which rounds to 6 so it works perfectly for the ranges
        try{
            do{
                grades[counter] = in.nextInt();
            
                if (grades[counter] < 60){
                    System.out.println("F");
                }
                else if (grades[counter]>= 60 &&grades[counter] <70){
                    System.out.println("D");
                }
                else if (grades[counter]>= 70 &&grades[counter] <80){
                    System.out.println("C");
                }
                else if (grades[counter]>= 80 &&grades[counter] <90){
                    System.out.println("B");
                }
                else if (grades[counter]>= 90){
                    System.out.println("A");
                }
                else{
                    System.out.println("I am not sure what grade that would be");        
                }
                counter++;
            } while (counter < 10); //only input 10 scores
            
            //Calculate average
            double total = 0;
            for (int i = 0; i<grades.length; i++){
                total += grades[i];
            }
            System.out.println("The average GPA is: " + total/grades.length);
            
           
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            in.close();
        }
        
        
    }
    
}
