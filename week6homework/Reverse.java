/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6homework;

/**
 *
 * @author jameslu
 */

import java.util.Scanner;

public class Reverse {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please input phrase all on one line");
        String input = in.nextLine();
        in.close();
        
        String[] words = input.split(" ");
        //work on this but easier to use split
        //StringBuilder words = new StringBuilder(input);
        
        for (int i = words.length - 1; i >= 0; i--){
            System.out.print(words[i] + " ");
        }
        
        
    }
    
}
