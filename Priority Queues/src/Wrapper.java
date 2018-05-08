
public class Wrapper implements Comparable<Wrapper> {

	int key;
	
	public Wrapper(int key) {
		this.key = key;
	}
	
	@Override
	public int compareTo(Wrapper w) {
		Tester.count++;
		return (this.key - w.key);
	}
	
}
