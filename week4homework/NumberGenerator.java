/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4homework;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author jameslu
 */
public class NumberGenerator {
    
    public static void main(String[] args){
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        Random rand = new Random();
        
        try{            
            File file = new File("number.txt");
            if (!file.exists()) {
		file.createNewFile();
                System.out.println("new file created");
            }
            
            fw = new FileWriter(file.getAbsoluteFile(), false);
            bw = new BufferedWriter(fw);
            
            for (int i = 0; i < 100; i++){
                bw.write(rand.nextInt(101) + " ");
            }
            //need to close to print out the values
            bw.close();
            fw.close();
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Io exception");
            Logger.getLogger(NumberGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
