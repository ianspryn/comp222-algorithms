
public class Point implements Comparable<Point> {
	double x, y;
	static int count = 0;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public int hashCode() {
		return Double.hashCode((x + 180) * 360 + (y + 180));
	}
	
	public boolean equals (Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Point)) {
			return false;
		}
		Point b = (Point)o;
		return x == b.x && y == b.y;
	}

	@Override
	public int compareTo(Point arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
