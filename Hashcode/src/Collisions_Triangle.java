import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Random;

public class Collisions_Triangle {

	public static void main(String[] args) throws FileNotFoundException {

		int M = 8009;
		//int M = Integer.MAX_VALUE;
		
		
		Random rand = new Random();
		
		

		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		Triangle triangle;

		int counter = 1000;
		while(counter > 0) {
			triangle= new Triangle(rand.nextDouble() * Math.pow(10, rand.nextInt(5)+1), rand.nextDouble() * Math.pow(10, rand.nextInt(5)+1), rand.nextDouble() * Math.pow(10, rand.nextInt(5)+1), rand.nextDouble() * Math.pow(10, rand.nextInt(5)+1), rand.nextDouble() * Math.pow(10, rand.nextInt(5)+1), rand.nextDouble() * Math.pow(10, rand.nextInt(5)+1));
			int hash = (triangle.hashCode() % M + M) % M;
			if(set.contains(hash))
				count++;
			else
				set.add(hash);
			counter--;
		}
		System.out.println(count);
	}
}