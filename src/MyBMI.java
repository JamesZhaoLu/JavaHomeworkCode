
import java.util.Scanner;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jameslu
 */
public class MyBMI {
    public static void main(String[] args) {
                
        Scanner in = new Scanner(System.in);
        System.out.println("Please input your height in inches");
        try{
            float height = in.nextFloat();
        
            System.out.println("Please input your weight in pounds");
            float mass = in.nextFloat();
 
            float bmi = ((mass/(float)(Math.pow(height, 2)))*703);
             // the Math class has the answer in a double which is why you have to change it into a float since everything else is float
            
            System.out.println("Your BMI is " + bmi);
        
            if (bmi <= 18.5){
                System.out.println("You are underweight. You can now be a Victoria's Secret Model! Although you really shouldn't starve yourself. A healthy look is a beautiful look!");
            }
            else if (18.5 < bmi && bmi < 25){
                System.out.println("You are normal weight. Congratulations! You are perfectly average :)");
            }
            else if (bmi >= 25 && bmi < 30) {
                System.out.println("You are overweight. Please don't go to McDonald's tomorrow; I know you were planning to.");
            }
            else {
                System.out.println("You are unfortunately obese. On the bright side though, you can enter in a Sumo Wrestling Competition!!");
            }
            
        
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Please enter valid numberical value");
                    
            }
            System.out.println(e.toString());
        }
        
        int a = 10;
        double b = 5.56;
        double c = a+b;
        int d = a + (int) b;
        System.out.println(c + " " + d);
            
        float g = 10/3;  
        float e = 10.0f/3;
        System.out.println(e);
        
        int aa = 10;
        int bb = 20;
        int cc;
//        
        cc = aa>bb ? aa:bb;
//        
        if (aa>bb){
            cc=aa;
        }
        else{
            cc=bb;
        }
        
        
    }
    
    
}
