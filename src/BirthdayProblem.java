/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jameslu
 */
public class BirthdayProblem {
    
    public static void main(String[] args) {
        
        //int n = Integer.parseInt(args[0]);
        int n = 300;
        
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            int[] birthday = new int[365];
            
            int x = (int)Math.floor(Math.random()*365);
            
            birthday[x] = 1;
            
            int day = (int)Math.random();
            //System.out.println(day);
            int count = 2;
            
            while (birthday[day] != 1) {
                birthday[day] = 1;
                day = (int)Math.floor(Math.random()*365);
                count++;
                
            }
            
            System.out.println("It takes " + count + " people to enter the room before there is a duplicate birthday.");
            
            numbers[i] = count;
            
        }
        
        int total = 0;
        int average = 0;
            
        for (int j = 0; j < n; j++) {
         
         total += numbers[j];
        }
        
        average = total/n;
            
         System.out.println("The average number of people to enter the room before there is a duplicate birthday is " + average + ".");
    }
}

