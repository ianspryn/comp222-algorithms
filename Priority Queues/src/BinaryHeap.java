import java.util.Collection;
import java.util.PriorityQueue;

public class BinaryHeap<K> implements Comparable<K> {
	private PriorityQueue<K> queue;
	int counter;
	
	public BinaryHeap(Collection<K> c) {
		queue = new PriorityQueue<K>();
		counter = 0;
	}
	
	public void add(K k) {
		queue.add(k);
	}
	
	public void remove (K k) {
		queue.remove(k);
	}
	
	@Override
	public int compareTo(K k) {
		counter++;
		return this.compareTo(k);
	}

}
