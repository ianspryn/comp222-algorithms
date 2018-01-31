import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Ian Spryn
 *
 * @param <K> the type used for keys in this collection
 * @param <T> the type used for data in this collection
 */
public class KeyedCollection<K, T> {
	//add private members here
	//private KeyedCollection<K, T> collection;
	private ArrayList<K> key;
	private ArrayList<T> data;
	
	/**
	 * Create an empty collection
	 */
	public KeyedCollection() {
		//collection = new KeyedCollection<K, T>();
		key = new ArrayList<K>();
		data = new ArrayList<T>();
	}
	
	/**
	 * 
	 * @return the number of objects in the collection
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Insert object of type T with a key of type K into the collection using an "ignore duplicates" policy
	 * 
	 * @param key the new key to add to the collection
	 * @param data the corresponding data to add to the collection
	 */
	public void insert(K key, T data) {
		//collection.insert(key, data);	
		this.key.add(key);
		this.data.add(data);
	}
	
	/**
	 * Output a string with a data values stored in the collection with a newline after each value. You do not print the keys.
	 * 
	 * @return the contents of the collection
	 */
	public String toString() {
		String s = "";
		for (T data : data) {
			s += data + "\n";
		}
		return s;
	}
}
