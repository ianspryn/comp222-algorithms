import java.util.Collection;
import java.util.TreeMap;

public class RedBlack<K, V> implements Comparable<K> {
	private TreeMap<K, V> map;
	int counter;
	
	public RedBlack(Collection<K> c) {
		map = new TreeMap<K, V>();
	}
	
	public void add(K k, V v) {
		map.put(k, v);
	}
	
	public void remove (K k, V v) {
		map.remove(k, v);
	}
	
	@Override
	public int compareTo(K k) {
		counter++;
		return this.compareTo(k);
	}

}
