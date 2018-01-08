package week5homework;

import java.util.Scanner;

/**
 * Joe wants to buy a fidget spinner but he does not like to get changes. He

has four bills each with different amount of money $b1, $b2, $b3, $b4. If

the fidget spinner�s price is �$x�, can Joe buy it using the bills without

getting any changes? For example, if b1=1,b2=5,b3=10,b4=20,Joe can buy

a $16 fidget spinner without getting any change but if he wants to buy a

$17 one, he will get change.
 * @author James
 *
 */
public class NoChangeMethodOne {
//	static boolean printAll=true;
	static boolean printAll=false;
	static boolean found = false;
	static String comment = "You will have change.";
	
	/* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
	static void combinationUtil(int arr[], int data[], int start,
			int end, int index, int r, int price)
	{
		// Current combination is ready to be printed, print it
		if (index == r)
		{
			int sumofBillValue = 0;
			String billcombinationStr = "";
			for (int j=0; j<r; j++){
				System.out.print(data[j]+" ");
				billcombinationStr += data[j] + " ";
				sumofBillValue += data[j];
			}
			System.out.println("");
			if (sumofBillValue == price) {
				found = true;
				comment = "Use this combination of bills to pay, you will not have change: " + billcombinationStr;
				System.out.println(billcombinationStr);
			}
			if (printAll)
				System.out.println(billcombinationStr);
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i=start; i<=end && index <= r; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r, price);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(int arr[], int n, int r, int price)
	{
		// A temporary array to store all combination one by one
		int data[]=new int[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n-1, 0, r, price);
	}

	/*Driver function to check for above function*/
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input 4 bill values seperated by a ','");
		String nbillstr = in.next();
		System.out.println("Please input the price");
		int price = in.nextInt();
		in.close();

		String[] billStrArr = nbillstr.split(",");
		int billnumber = billStrArr.length;
		int[] bills = new int[billnumber];
		int totalMoney = 0;
		for (int i = 0; i < billnumber; i++) {
			bills[i] = Integer.parseInt(billStrArr[i].trim());
			totalMoney += bills[i];
		}

		if (price > totalMoney) {
			System.out.println("Sorry, you don't have enough money to pay!");
			return;
		}
		for (int r=1; r<= bills.length; r++){
			printCombination(bills, bills.length, r, price);
		}
		
		System.out.println(comment);
	}
}
