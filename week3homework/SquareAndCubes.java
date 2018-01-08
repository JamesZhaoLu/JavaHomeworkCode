/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3homework;

/**
 *
 * @author jameslu
 */
public class SquareAndCubes {
    public int getSquareValue(int number) {
        int square = (int)Math.pow(number, 2);
        return square;
        
    }
    
    public int getCubeValue(int number2) {
        int cube = (int)Math.pow(number2, 3);
        return cube;
        
    }
    
    public static void main(String[] args) {
        SquareAndCubes sAndc = new SquareAndCubes();
        //int[][] t2 = { {1,2,3}, {1,2}};
        int[][] table = new int[100][3];
        for (int i = 0;i<100 ; i++) {
            
                table[i][0] = i;
                table[i][1] = sAndc.getSquareValue(i);
                table[i][2] = sAndc.getCubeValue(i);
                
                System.out.print(table[i][0] + "\t" + table[i][1] + "\t" + table[i][2] + "\n");
                
        }
        
    }
    
}
