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
public class DiamondPattern2 {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int width;
        try{
            width = in.nextInt();
                   
            String stars = "";
            String spaces = "";

            int countRows = 0; 
            //initialize spaces
            for (int i = 0; i<(width-1)/2; i++){
                spaces = spaces + " ";
            }
            //initialize stars
            if (width%2 == 0){
                stars = "**";
            } else{
                stars = "*";
            }
            
            do{
                System.out.println(spaces + stars);
                countRows++;
                
                //add/ subtract to the stars length to the stars
                //before the reaches width
                if (countRows < (width+1)/2){
//                   //less spaces
                    spaces = spaces.substring(0, spaces.length()-1);
                    stars = stars + "**";
                    
                }
                //after and at width
                else if (countRows>= (width+1)/2 && stars.length() >=2){ 
                    //add spaces
                    spaces = spaces + " ";
                    stars = stars.substring(0, stars.length()-2);
                }
            } while (countRows < width);

            
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            in.close();
        }
        
    }
}
