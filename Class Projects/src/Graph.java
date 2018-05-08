import java.util.*;

/*
Write a program that will read in a list of pairs of cities.
Each pair of cities is connected by a highway.
Print out the critical highways – those if destroyed, partition the cites in two (or
more) disconnected sets.
The input will consists of lines, each line containing a pair of cities, the names
of the cities separated by commas.
 */
public class Graph {
	
	class Vertex {
		
		String name;
		ArrayList<Vertex> neighbors;
		int dfsnum, low;
		boolean mark;
		
		public Vertex(String name) {
			this.name = name;
			neighbors = new ArrayList<Vertex>();
			mark = false;
			dfsnum = low = -1;
		}
		
		public void addNeighbor(Vertex w) {
			neighbors.add(w);
		}
		
		public String toString() {
			return name;
		}
	}
	
	HashMap<String, Vertex> map = new HashMap<>();
	int count = 0;
	
	
	
	public Vertex getVertex(String name) {
		Vertex v = map.get(name);
		if (v == null) {
			v = new Vertex(name);
			map.put(name, v);
		}
		return v;
	}
	
	public Collection<Vertex> getVertices() {
		return map.values();
	}
	
	public void addEdge(Vertex v, Vertex w) {
		v.addNeighbor(v);
		v.addNeighbor(w);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Graph graph = new Graph();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line);
			sc2.useDelimiter(",");
			Vertex v = graph.getVertex(sc2.next());
			Vertex w = graph.getVertex(sc2.next());
			graph.addEdge(v, w);
		}
		for (Vertex v : graph.getVertices()) {
			if (!v.mark) {
				graph.visit(v, null);
			}
		}
	}

	
	void visit(Vertex x, Vertex p) {
		x.mark = true;
		x.dfsnum = count++;
		x.low = x.dfsnum;
		for (Vertex v : x.neighbors) {
			if (!v.mark) {
				visit(v, x);
				if (v.low == v.dfsnum) {
					//if this ^^, then we have a bridge!
					System.out.println(x + " " +  v);
				}
			}
			if (v != p && v.low < x.low) {
				x.low = v.low;
			}
		}
	}
}
