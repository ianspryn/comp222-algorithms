import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Opens the file customers.txt, creates a new KeyedCollection Object, reads through the file, and prints the collection.
 * @author Ian Spryn
 */
public class Program1 {

	public static void main(String[] args) {
		//set up file reading
		Scanner reader = null;
		try {
			reader = new Scanner(new File("customers.txt"));
		}
		catch (FileNotFoundException ex) {
			System.err.println("Failed to open \"customers.txt\" for reading");
			System.exit(1);
		}
		
		//create keyed collection
		KeyedCollection<Integer, Customer> collection = new KeyedCollection<>();
		
		//read each customer from the file
		while(reader.hasNextInt()) {
			int currentKey = reader.nextInt();
			try {
				collection.insert(currentKey, new Customer(currentKey, reader.nextInt(), reader.nextFloat(), reader.next(), reader.next(), reader.next()));
			}
			catch (NoSuchElementException ex) {
				System.err.println("File was not formatted correctly, so reading ended prematurely");
				break;
			}
			catch (IllegalStateException ex) {
				System.err.println("A file-read error has occurred.");
				break;
			}
		}
		
		//print the collection
		System.out.println(collection);
	}
}
