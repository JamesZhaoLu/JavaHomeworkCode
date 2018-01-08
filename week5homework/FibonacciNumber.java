package week5homework;

import java.util.Scanner;

public class FibonacciNumber {

	static int sequence;
	static int position = -1;

	static void findFibonacciSequenceNumber(int[] previousTwo, int index, int givenNum) {
		int nextNumber = previousTwo[0] + previousTwo[1];

		if (nextNumber == givenNum) {
			position = index;
			return;
		}else if (nextNumber >  givenNum){
			return;
		}

		previousTwo[0]= previousTwo[1];
		previousTwo[1] = nextNumber;
		index ++;
		findFibonacciSequenceNumber(previousTwo, index, givenNum);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int givenNum =0;
		System.out.println("Please input a number which is greater than 1");
		givenNum = in.nextInt();
		while (givenNum <= 1) {
			System.out.println("invalid number, enter again");
			givenNum = in.nextInt();
		}
		in.close();

		int[] twoFibonacciNumbers = {1,1};
		findFibonacciSequenceNumber(twoFibonacciNumbers, 3, givenNum);
		System.out.println(position);
		if (position == -1) {
			System.out.println("the given number " + givenNum + " is not a Fibonacci number.");
		}else {
			System.out.println("the given number " + givenNum + " is a Fibonacci number, and it is in the position of " + position);
		}
	}

}
