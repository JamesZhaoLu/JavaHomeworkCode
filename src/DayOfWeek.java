import java.util.Scanner;

public class DayOfWeek {
	static boolean validmonthday(int month, int day) {
		switch (month) {
		case 1: 
      		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day > 31) {
				return false;
			}
			break;
		case 2:
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 30) {
				return false;
			}
			break;
		default: 
			return false;
		}
		return true;
	}
	
	static boolean validyearmonthday(int year, int month, int day) {
		if (year <= 0 || month <= 0 || day <= 0) {
			return false;
		}
		boolean leapyear = (year/4 == 0 && year/100 != 0 && year/400 == 0) ? true : false;
		if (leapyear == true) {
			if (month == 2) {
				if (day > 29)
                                    return false;
				else 
                                    return true;
			} else {
                            return validmonthday(month, day);
			}
			
		} else {
			if (month == 2) {
				if (day > 28) 
					return false;
				else
					return true;
			} else {
				return validmonthday(month, day);
			}
		}
	}
	public static void main(String[] args) {
		int year = 0;
		int month = 1;
		int date = 1;
		int y0 = 0;
		int x = 0;
		int m0 = 0;
		int d0 = 0;
		Scanner input = new Scanner(System.in);
		
		try {
			boolean isvalid = true;
			do {
				if (isvalid != true)
				    System.out.print("Wrong input! Please input correct year, month and day.\n");
				System.out.print("Enter year (e.g. 2017): \n");
				year = input.nextInt();
				System.out.print("Enter month (1-12): \n");
				month = input.nextInt();
				System.out.print("Enter the day of the month (1-31): \n");
				date = input.nextInt();
			} while ((isvalid = validyearmonthday(year, month, date)) != true);

			y0 = year - (14 - month)/12;
			x  = y0 + y0/4 - y0/100 + y0/400;
			m0 = month + 12*((14 - month)/12) - 2;
			d0 = (date + x + (31*m0)/12)%7;
		}
                catch(Exception e){
                    System.out.println("Error: " );
                    e.printStackTrace();
                
                    
                }finally {
			input.close();
		}
                
		String Name;

		switch (d0) {
		case 0:
			Name = "Sunday";
			break;
		case 1:
			Name = "Monday";
			break;
		case 2:
			Name = "Tuesday";
			break;
		case 3:
			Name = "Wednesday";
			break;
		case 4:
			Name = "Thursday";
			break;
		case 5:
			Name = "Friday";
			break;
		case 6:
			Name = "Saturday";
			break;
		default:
			Name = "unknown";
		}
		System.out.println("Day of the week is " + Name);
	}
}


//import java.util.Scanner;
//
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
//
///**
// *
// * @author jameslu
// */
//
//public class DayOfWeek {
//
//	public static void main(String[] args) {
//		int year = 0;
//		int month = 1;
//		int date = 1;
//		int y0 = 0;
//		int x = 0;
//		int m0 = 0;
//		int d0 = 0;
//		Scanner input = new Scanner(System.in);
//		
//		try {
//			System.out.print("Enter year (e.g. 2017): ");
//			year = input.nextInt();
//
//			System.out.print("Enter month (1-12): ");
//			month = input.nextInt();
//
//			System.out.print("Enter the day of the month (1-31): ");
//			date = input.nextInt();
//
//			y0 = year - (14 - month)/12;
//			x  = y0 + y0/4 - y0/100 + y0/400;
//			m0 = month + 12*((14 - month)/12) - 2;
//			d0 = (date + x + (31*m0)/12)%7;
//		} finally {
//			input.close();
//		}
//		String Name;
//
//		switch (d0) {
//		case 0:
//			Name = "Sunday";
//			break;
//		case 1:
//			Name = "Monday";
//			break;
//		case 2:
//			Name = "Tuesday";
//			break;
//		case 3:
//			Name = "Wednesday";
//			break;
//		case 4:
//			Name = "Thursday";
//			break;
//		case 5:
//			Name = "Friday";
//			break;
//		case 6:
//			Name = "Saturday";
//			break;
//		default:
//			Name = "unknown";
//		}
//		System.out.println("Day of the week is " + Name);
//	}
//}