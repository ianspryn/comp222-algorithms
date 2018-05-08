import java.util.ArrayList;
import java.util.Scanner;

public class NumberingCities {
	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		Tree<String, Integer> map = new Tree<>();
		ArrayList<String> names = new ArrayList<>();
		while(scnr.hasNext()) {
			String city = scnr.nextLine();
			Integer num = map.search(city);
			if (num == null) {
				num = map.size();
				map.insert(city, map.size());
				names.add(city);
			}
			System.out.println(city + " : " + num);
		}	
	}
}
