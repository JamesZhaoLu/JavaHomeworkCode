/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author jameslu
 */
public class SelectionSort {
    
    public static void main(String[] args){
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        
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
            
            //sorting method
            int counter = 0;
            int maxIndex = -1;
            int max = -1;
            while (counter < numbers.length){
                for (int i = 0; i < numbers.length - counter; i++){
                    if (numbers[i] > max){
                        max = numbers[i];
                        maxIndex = i;
                    }
                }
                int temp = numbers[maxIndex];
                numbers[maxIndex] = numbers[numbers.length - counter - 1];
                numbers[numbers.length - counter - 1] = temp;
                counter ++;
                max = -1;
            }
            br.close();
            fr.close();
            
            //write the output out
            File file = new File("SortedNumbers.txt");
            
            if (!file.exists()){
                file.createNewFile();
            }
            
            fw = new FileWriter(file.getAbsoluteFile(), false);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < numbers.length; i++){
                System.out.println(numbers[i]);
                bw.write(numbers[i] + " ");
            }
            bw.close();
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
