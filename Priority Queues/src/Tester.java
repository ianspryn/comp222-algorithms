import java.util.*;

public class Tester {
	
	public static int count;
	
	public static void main(String[] args) {
		int n = 1000000;
		Random rand = new Random();
		long startTime;
		
		/*
		 * Priority Queue and Binary Heap
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println("Testing with " + n + " values for Binary Heap");
			
			//Add keys to ArrayList
			ArrayList<Wrapper> array = new ArrayList<>();
			
			for (int j = 0; j < n; j++) {
				array.add(new Wrapper(rand.nextInt()));
			}
			count = 0;
			startTime = System.nanoTime();
			PriorityQueue<Wrapper> queue = new PriorityQueue<Wrapper>(array);
			System.out.println("\tCreation time: " + (System.nanoTime() - startTime) / 1000000.0 + " milliseconds");
			System.out.println("\tNumber of comparisons: " + count + "\n");
			
			count = 0;
			startTime = System.nanoTime();
			for (int j = 0; j < n/10; j++) {
				if (rand.nextBoolean()) {
					queue.add(new Wrapper(rand.nextInt()));
				} else {
					queue.poll();
				}
			}
			System.out.println("\tOperations time: " + (System.nanoTime() - startTime) / 1000000.0 + " milliseconds");
			System.out.println("\tNumber of comparisons: " + count + "\n");
			
			
			
			n /= 10;
			System.out.println("\n");
			
		}
		
		n = 1000000;
		
		/*
		 * TreeMap and Red Black Tree
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println("Testing with " + n + " values for Red Black Tree");
			
			//Add keys to ArrayList
			ArrayList<Wrapper> array = new ArrayList<>();
			
			for (int j = 0; j < n; j++) {
				array.add(new Wrapper(rand.nextInt()));
			}
			count = 0;
			startTime = System.nanoTime();
			TreeSet<Wrapper> set = new TreeSet<Wrapper>(array);
			System.out.println("\tCreation time: " + (System.nanoTime() - startTime) / 1000000.0 + " milliseconds");
			System.out.println("\tNumber of comparisons: " + count + "\n");
			
			count = 0;
			startTime = System.nanoTime();
			for (int j = 0; j < n/10; j++) {
				if (rand.nextBoolean()) {
					set.add(new Wrapper(rand.nextInt()));
				} else {
					set.pollLast();
				}
			}
			System.out.println("\tOperations time: " + (System.nanoTime() - startTime) / 1000000.0 + " milliseconds");
			System.out.println("\tNumber of comparisons: " + count + "\n");
			
			
			
			n /= 10;
			System.out.println("\n");
			
		}
		
	}

}
