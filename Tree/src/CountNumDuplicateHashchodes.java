import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountNumDuplicateHashchodes {
	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		while(scnr.hasNext()) {
			String word = scnr.next();
			int n = word.hashCode(); //don't do this line unless you are writing an implementation of a hash table
			ArrayList<String> words = map.get(n);
			if  (words == null) {
					words = new ArrayList<String>();
			}
			words.add(word);
			map.put(n,  words);
		}
		for (Integer n : map.keySet()) {
			ArrayList<String> words = map.get(n);
			if (words.size() > 1) {
				System.out.printf("%10d : %s\n", n, words);
			}
		}
	}
}
