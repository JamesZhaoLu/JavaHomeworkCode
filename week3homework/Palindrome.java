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
public class Palindrome {
    
    public static void main (String[] args){
        
        Scanner in = new Scanner(System.in);
        
        try{
            //I used String but this very well could have read numbers as well
            //But now you can compare String palindromes
            String input = in.next();
            input.trim();
            input.toLowerCase();
            
            boolean palindrome = true;
            for (int i = 0; i < input.length()/2; i++){
                if (input.charAt(i) != input.charAt(input.length()-1 -i)){
                    palindrome = false;
                }
            }
            System.out.println(palindrome);
            
            
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            in.close();
        }
             
    }
    
}
