import java.util.*;

public class plusMinus {
	public static void main(String[] args) {
		int[] intArray = new int[] {-4, 3, -9, 0, 4, 1};
		fractions(intArray);
		
	}
	
	static void fractions(int[] arr) {
		int negatives = 0;
		int zeros = 0;
		int positives = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negatives++;
			} else if (arr[i] > 0) {
				positives++;
			} else {
				zeros++;
			}
		}
		double lol = negatives / arr.length;
		System.out.printf("%.6f", lol);
		//System.out.println(zeros / (negatives + zeros + positives));
		//System.out.println(positives / (negatives + zeros + positives));
				
	}
	
}
