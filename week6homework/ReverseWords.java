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
import java.util.Scanner;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
                
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a numbers of words separated by a space:");
		String sentence = in.nextLine();
		in.close();
		String[] words = sentence.split(" ");
		TreeBalance root = new TreeBalance();
		for (int i = 0; i < words.length; i++) {
			TreeNode node = new TreeNode(i, words[i]);
			root.insert(node);
		}
		root.print();
		System.out.println("Original word order: " + root.inorder());
		System.out.println("Reversed word order: " + root.outorder());		
	}

}