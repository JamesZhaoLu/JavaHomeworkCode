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

public class DistMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input two words separated by a space.");
		System.out.println("The first word is the start word and the second word is the end word:");
		String sentence = in.nextLine();
		in.close();
		String[] words = sentence.split(" ");
		DistTree root = new DistTree();
		root.build(words[0], words[1]);
		root.print();
		int path = root.findPath(words[1]);
		System.out.println("The Levenshtein distance of the two words is " + path);
	}

}
