/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jameslu
 */
public class ReverseArray {
    public static void main(String[] args) {
        
        int[] array = {1, 2, 3, 4, 5};
        //System.out.print(array[0]);
        for (int i = 4; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
    
}
