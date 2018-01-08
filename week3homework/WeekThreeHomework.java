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
import java.util.Scanner;

/**
 *
 * @author Ding
 */
public class WeekThreeHomework {

    /**
     * @param args the command line arguments
     */
    public static String repeat(int count, String with) {
        /** "\0" means null, ie. no value
         ** following line of code does 3 things
         ** 1. create a char type array with size of count, each char value is null (no value);
         ** 2. convert this array of char to a string using new String(char[]);
         ** 3. use string replace method to replace each null value to passed in "with" value
         **/
        
        return new String(new char[count]).replace("\0", with);
    }

    public static void main(String[] args) {
        System.out.println("Please input a number for the biggest size star number");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int hight = (n -1)/ 2;
        String spaceUnit = " ";
        boolean isEven = (n % 2 == 0);
        String oneStar = "*";
        String twoStar = "**";
        String line = "";

        for (int i = 1; i <= hight; i++) {
            if (isEven) {
                line = repeat((hight - i + 1), spaceUnit) + repeat(i, twoStar);
            } else {
                line = repeat((hight - i + 1), spaceUnit) + repeat(1 + 2 * (i - 1), oneStar);
            }
            System.out.println(line);
        }
        System.out.println(repeat(n, oneStar));
        
        for (int i = hight; i >= 1; i--) {
            if (isEven) {
                line = repeat((hight - i + 1), spaceUnit) + repeat(i, twoStar);
            } else {
                line = repeat((hight - i + 1), spaceUnit) + repeat(1 + 2 * (i - 1), oneStar);
            }
            System.out.println(line);

        }
    }

}

