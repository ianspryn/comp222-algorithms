import java.util.*;

public class Diamonds {
	
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter matrix size");
		int n = scnr.nextInt();
		
		matrix = new int[n][n]; 
		
		generateGrid(n);
		
		System.out.println(Arrays.deepToString(matrix));
	}

	/**
	 * 
	 * @param n to define the size of the n by n matrix
	 */
	public static void generateGrid(int n) {
		Random rand = new Random();
		matrix[rand.nextInt(n)][rand.nextInt(n)] = 1;
	}
}
