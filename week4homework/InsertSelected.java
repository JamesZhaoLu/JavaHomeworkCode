/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4homework;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author jameslu
 */
public class InsertSelected {
    
    public static void main(String[] args){
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        Scanner in = null;
        
        try{
            fr = new FileReader("SortedNumbers.txt");
            br = new BufferedReader(fr);
            
            //read from text file - save in int array
            String line = br.readLine();
            String[] snumbers = line.split(" ");
            int[] numbers = new int[snumbers.length];
            
            for (int i = 0; i < snumbers.length; i++){
                numbers[i] = Integer.parseInt(snumbers[i]);
                System.out.println(numbers[i]);
            }
            
            in = new Scanner(System.in);
            System.out.println("what number would you like to insert? Please make it between 0 and 100");
            
            int input = in.nextInt();
            
            for (int i = 0; i < numbers.length; i++){
                if (input < numbers[i]){
                    numbers = Arrays.copyOf(numbers, numbers.length + 1);
//                    for (int k = 0; k < numbers.length; k++){
//                        System.out.println(numbers[k]);
//                    }
                    //System.out.println("i is: " + i);
                    for (int j = numbers.length - 1; j > i; j--){
                        numbers[j] = numbers[j-1];
                    }
                    numbers[i] = input;
                    break;
                } else if (i == numbers.length - 1){
                    numbers = Arrays.copyOf(numbers, numbers.length + 1);
                    numbers[i+1] = input;
                    break;
                }
            }
            
            for (int i = 0; i < numbers.length; i++){
                System.out.println(numbers[i]);
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
