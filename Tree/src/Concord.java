import java.util.Scanner;

public class Concord {
	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		Tree<String, Integer> map = new Tree<>();
		while(scnr.hasNext()) {
			String word = scnr.next().replaceAll("\\W", ""); //replace all alphanumeric characters with blank
			Integer count = map.search(word);
			count = (count == null ? 1 : count++);
			map.insert(word, count);
		}
		System.out.println(map);
	}
}

