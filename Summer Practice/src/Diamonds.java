import java.util.*;

public class Diamonds {
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter matrix size");
		int n = scnr.nextInt();
		Matrix m1 = new Matrix(n);
		Random rand = new Random();
		//Set a random matrix value to 1
		m1.matrix[rand.nextInt(n)][rand.nextInt(n)] = 1;
		
		System.out.println(m1.matrix.toString());
		
	}

	
}
