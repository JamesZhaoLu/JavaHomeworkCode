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
public class DiamondPattern {
   
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int width;
        try{
            width = in.nextInt();
                   
            String stars = "";
            String spaces = "";

            int counter = 0;
            
            int numSpaces = (width-1)/2;
            
            for (int i = 0; i<numSpaces; i++){
                spaces = spaces + " ";
            }
            numSpaces--;
            
            if (width%2 == 0){
                stars = "**";
            } else{
                stars = "*";
            }
            //System.out.println(spaces + stars);
            
            //spaces = "";
            
            do{
               
                System.out.println(spaces + stars);
                counter++;
                
                //add/ subtract to the stars length to the stars
                //before the reaches width
                if (counter < (width+1)/2){
//                   //less spaces
                    for (int i = 0; i<=numSpaces; i++){
                        spaces = spaces + " ";
                    }
                    numSpaces -= 1;
                    
                    stars = stars + "**";
                    
                }
                //after and at width
                else if (counter>= (width+1)/2 && stars.length() >=2){ 
                    //add spaces
                    for (int i = 0; i<numSpaces; i++){
                        spaces = spaces + " ";
                    }
                    numSpaces++;
                    
                    stars = stars.substring(0, stars.length()-2);
                }
                spaces = "";
                
                //add/subtract to the spaces length
                
                for (int i = 0; i<=numSpaces; i++){
                    spaces = spaces + " ";
                }
                
            } while (counter < width);

            
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            in.close();
        }
        
    }
    
}
