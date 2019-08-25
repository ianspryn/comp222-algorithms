import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Look_and_say_sequence {

	public static void main(String[] args) {
		System.out.println("Enter the nth position");
		Scanner scnr = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
		System.out.println(lookAndSay(scnr.nextInt(), "1"));
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
	}
	
	public static String lookAndSay(int n, String currentValue) {
		if (n == 1) {
			return currentValue;
		}
		
		int[] currentValueArray = new int[currentValue.length()];
		
		for (int i = 0; i < currentValue.length(); i++) {
			currentValueArray[i] = currentValue.charAt(i) - '0';
		}
		
		String newValue = "";
		for (int i = 0; i < currentValueArray.length; i++) {
			int counter = 0;
			int positionValue = currentValueArray[i];
			while (i < currentValueArray.length && currentValueArray[i] == positionValue) {
				i++;
				counter++;
			}
			newValue += Integer.toString(counter) + Integer.toString(positionValue);
			i--;
		}
		
		return lookAndSay(n - 1, newValue);
		
	}
	
}
