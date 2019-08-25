import java.text.*;
import java.util.Scanner;

public class Look_and_say_sequence_memoization {

	public static void main(String[] args) {
		System.out.println("Enter the nth position");
		Scanner scnr = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
		
		int n = scnr.nextInt();
		int counter; //count how many of the same numbers there are
		int positionValue; //the start of any block of the same numbers
		String value = "1";
		String temp = "";
		while (n > 1) {
			for (int i = 0; i < value.length(); i++) {
				counter = 0;
				positionValue = value.charAt(i) - '0';
				while (i < value.length() && (value.charAt(i) - '0') == positionValue) {
					i++;
					counter++;
				}
				temp += Integer.toString(counter) + Integer.toString(positionValue);
				i--;
			}
			value = temp;
			temp = "";
			n--;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(value);
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
	}	
}

/*
n value: 43

ARRAY
9.35
9.87
9.14
22.24 (n of 45)

STRING
8.931
9.95
9.17
24.089 (n of 45)

MEMOIZATION
9.51
9.098
9.069
24.16 (n of 45)
*/