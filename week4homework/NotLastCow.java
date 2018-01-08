/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4homework;

/**
 *
 * @author jameslu
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotLastCow {

	private static int findIndex(String[] cowNames, String name) {
		for (int i = 0; i < cowNames.length; i++) {
			if (cowNames[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public static int[] readFromFile(String[] cowNames, String filename) throws IOException {
		int[] cowMilk = new int[cowNames.length];
		for (int i = 0; i < cowMilk.length; i++) {
			cowMilk[i] = 0;
		}
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		if ((line = bufferedReader.readLine()) == null) {
			bufferedReader.close();
			throw new IOException();
		}
		int numberOfLines = Integer.parseInt(line);
		if (numberOfLines <= 0 || numberOfLines > 100) {
			bufferedReader.close();
			throw new IOException();
		}
		for (int i = 0; i < numberOfLines; i++) {
			if ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split(" ");
				if (!parts[0].trim().isEmpty()) {
					int idx = findIndex(cowNames, parts[0].trim());
					int milk = Integer.parseInt(parts[1].trim());
					if (idx >= 0 && milk >= 0) {
						cowMilk[idx] += milk;
					}
				}
			}
		}
		bufferedReader.close();
		return cowMilk;
	}

	private static void quicksortCow(int low, int high, String[] cowName, int[] cowMilk) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = cowMilk[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller than the pivot
			// element then get the next element from the left list
			while (cowMilk[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger than the pivot
			// element then get the next element from the right list
			while (cowMilk[j] > pivot) {
				j--;
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j, cowName, cowMilk);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j) {
			quicksortCow(low, j, cowName, cowMilk);
		}
		if (i < high) {
			quicksortCow(i, high, cowName, cowMilk);
		}
	}

	private static void exchange(int i, int j, String[] cowName, int[] cowMilk) {
		int temp = cowMilk[i];
		cowMilk[i] = cowMilk[j];
		cowMilk[j] = temp;
		String tmp = cowName[i];
		cowName[i] = cowName[j];
		cowName[j] = tmp;
	}

	private static String getSecondLastCow (String[] cowName, int[] cowMilk) {
		int idx = 1;
		while (idx < cowName.length && cowMilk[0] >= cowMilk[idx]) {
			idx++;
		}
		if (idx >= cowName.length) {
			return "tie";
		}
		String name = cowName[idx];
		for (int i = idx + 1; i < cowName.length; i++) {
			if (cowMilk[idx] == cowMilk[i]) {
				name = name + ", " + cowName[i];
			}
		}
		return name;
	}

	public static void writeToOutFile(String name, String fileName) throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		fw = new FileWriter(file.getAbsoluteFile(),false);
		bw = new BufferedWriter(fw);
		if (bw != null) {
			bw.write(name + "\n");
			bw.close();
		}
		if (fw != null) {
			fw.close();
		}
	}

	public static void printarray(String[] cowName, int[] cowMilk) {
		for (int i = 0; i < cowName.length; i++) {
			System.out.println("name=" + cowName[i] + ", milk=" + cowMilk[i]);
		}
	}
	public static void main(String[] args) {
		String[] cowName = { "Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta" };
		String filename = "notlast.in";
		String outfilename = "notlast.out";
		try {
			int[] cowMilk = readFromFile(cowName, filename);
			quicksortCow(0, cowName.length - 1, cowName, cowMilk);
			printarray(cowName, cowMilk);
			String name = getSecondLastCow(cowName, cowMilk);
			System.out.println("\nsecond last is " + name);
			writeToOutFile(name, outfilename);
		} catch (IOException x) {
			System.err.println(x);
		} finally {
		}

	}

}