import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Random;

public class Collisions_ScientificName {

	public static void main(String[] args) throws FileNotFoundException {

		int M = 8009;
		//int M = Integer.MAX_VALUE;
		

		
		Scanner sc = new Scanner (new File ("beetles.txt"));

		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		ScientificName word;

		while(sc.hasNext()) {
			word = new ScientificName(sc.next(), sc.next());
			int hash = (word.hashCode() % M + M) % M;
			if(set.contains(hash))
				count++;
			else
				set.add(hash);
		}
		System.out.println(count);
	}
}