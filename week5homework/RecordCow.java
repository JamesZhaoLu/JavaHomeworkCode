/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5homework;

import java.util.Scanner;

/**
 *
 * @author jameslu
 */
public class RecordCow {

	public static int findIndex(int[] B, int value) {
		for (int i = 0; i < B.length; i++) {
			if (value == B[i]) {
				return i;
			}
		}
		return -1;
	}
	public static int[] cyclicShift(int[] A, int[] B) {
		int numberOfCycles = 0;
		int maxCyclesSize = 0;
		int[] C = A.clone();
		for (int i = 0; i < C.length; i++) {
			int iB = findIndex(B, C[i]);
			int size = 0;
			if (iB != i) {
				numberOfCycles++;
				System.out.println("check A[" + i + "]=" + A[i] + " is at B[" + iB + "]");
				while (C[iB] != B[iB]) {
					int value = C[iB];
					C[iB] = B[iB];
					System.out.println("shift A[" + iB + "] to " + B[iB] + " from " + value);
					iB = findIndex(B, value);
					size++;
				}
			}
			if (size > maxCyclesSize) {
				maxCyclesSize = size;
			}
		}
		int[] result = new int[2];
		result[0] = numberOfCycles;
		result[1] = (maxCyclesSize == 0) ? -1 : maxCyclesSize;
		return result;
	}
	
	public static void main(String[] args) {
            System.out.println("Please input values as described in problem:");
            Scanner in = new Scanner(System.in);
            int numberOfElements = in.nextInt();
            int[] A = new int[numberOfElements];
            int[] B = new int[numberOfElements];
            for (int i = 0; i < numberOfElements; i++) {
        	A[i] = in.nextInt();
            }  
            for (int i = 0; i < numberOfElements; i++) {
        	B[i] = in.nextInt();
            }
            in.close();

            int[] R = cyclicShift(A, B);
            System.out.println("");
            System.out.println(R[0] + " " + R[1]);
            System.out.println("");
            }
}
