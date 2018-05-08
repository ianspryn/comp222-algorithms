import java.util.HashMap;
import java.util.Scanner;

public class Hashing {
	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		while(scnr.hasNext()) {
			String word = scnr.next().replaceAll("\\W", ""); //replace all alphanumeric characters with blank
			Integer count = map.get(word);
			count = (count == null ? 1 : count++);
			map.put(word, count);
		}
		System.out.println(map);
	}
}

