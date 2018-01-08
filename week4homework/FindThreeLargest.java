/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4homework;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
/**
 *
 * @author jameslu
 */
public class FindThreeLargest {
    
    public static void main (String[] args){
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            fr = new FileReader("number.txt");
            br = new BufferedReader(fr);
            
            //read from text file - save in int array
            String line = br.readLine();
            String[] snumbers = line.split(" ");
            int[] numbers = new int[snumbers.length];
            for (int i = 0; i < snumbers.length; i++){
                numbers[i] = Integer.parseInt(snumbers[i]);
                //System.out.println(numbers[i]);
            }
            
            //use int array to find 3 largest numbers
            int[] threeLargest = {0,0,0};
            name:
            for (int i = 0; i < numbers.length; i++){
                boolean flag = false;
                for (int j = 0; j < threeLargest.length; j++){
                    if (numbers[i] == threeLargest[j]){
                        flag = true;
                        break;
                    }
                }
                if (flag == true){
                    continue;
                }
                for (int j = 0; j < threeLargest.length; j++){
                    if (numbers[i] > threeLargest[j]){
                      for (int k = threeLargest.length - 1; k > j; k--){
                          threeLargest[k] = threeLargest[k-1];
                      }
                      threeLargest[j] = numbers[i];
                      break;
                    }
                }
                
            }
            System.out.println("The three largest distinct numbers are:");
            for (int i = 0; i < threeLargest.length; i++){
                System.out.println(threeLargest[i]);
            }
            
            br.close();
            fr.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
