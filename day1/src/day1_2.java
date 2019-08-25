
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day1_2 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("adventofcodeday1.txt");
		Scanner scnr = new Scanner(f);
		boolean iterate = true;
		int value = 0;
		Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();
		while(iterate) {
			while (scnr.hasNext() && iterate) {
				value += scnr.nextInt();
				if (h.containsKey(value)) {
					System.out.println("first repeitive frequency: " + value);
					iterate = false;
					break;
				} else {
					h.put(value, 0);
				}
			}
			scnr.close();
			scnr = new Scanner(f);
		}
	}
}
