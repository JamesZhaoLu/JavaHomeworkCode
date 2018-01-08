/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6homework;

/**
 *
 * @author jameslu
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GridMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a number that is the size of field matrix as first line and ");
		System.out.println("Then input matrix one row per line:");
		String sizeLine = in.nextLine();
		int size = Integer.parseInt(sizeLine);
		String[] matrix = new String[size];
		for (int i = 0; i < size; i++) {
			String row = in.nextLine();
			if (row.length() != size) {
				System.out.println("Error: this row " + row + " has different length than matrix.");
				return;
			}
			matrix[i] = row;
		}
		in.close();
		GridTree root = new GridTree();
		root.build(matrix);
		root.print();
		ArrayList<String> palins = root.findPalins();
		System.out.println("There are " + palins.size() + " palindromes and they are:");
		for (String palin : palins) {
			System.out.println(palin);
		}
	}

}