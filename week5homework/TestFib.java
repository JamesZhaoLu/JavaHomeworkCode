/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5homework;

/**
 *
 * @author jameslu
 */
import java.util.Scanner;

public class TestFib {

    private static int testFib(int number)
    {
    	int n_1 = 1;
    	int n_2 = 0;
    	if (number == n_1) {
            return n_1;	
    	}
    	if (number == n_2) {
            return n_2;	
    	}
    	int n = 0;
    	int i = 1;
    	do {
            n = n_1 + n_2;
            i++;
            if (n == number) {
    		return i;
            }
            n_2 = n_1;
            n_1 = n;
    	} while (n < number);
    	return -1;
    }

	public static void main(String[] args) {
	    System.out.print("Please input number:\n");
            Scanner input = new Scanner(System.in);		
            try {
		int number = input.nextInt();
		int fibnum = testFib(number);
		if (fibnum >= 0) {
			System.out.println(" " + number + " is a Fibonicci number whose position is " + fibnum);
		} else {
			System.out.println(" " + number + " is not a Fibonicci number.");
		}
	} finally {
		input.close();
	}
    }
}
