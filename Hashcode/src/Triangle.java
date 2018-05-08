
public class Triangle {
	
	private Point x, y, z;
	
	private class Point {
		private double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}
	}
	
	public Triangle(double x1, double x2, double y1, double y2, double z1, double z2) {
		this.x = new Point(x1, x2);
		this.y = new Point(y1, y2);
		this.z = new Point(z1, z2);
	}
	
	@Override
//	public int hashCode() {
//		int hash = 7;
//		hash = 31 * hash + Double.valueOf(x.getX()).hashCode();
//		hash = 31 * hash + Double.valueOf(x.getY()).hashCode();
//		hash = 31 * hash + Double.valueOf(y.getX()).hashCode();
//		hash = 31 * hash + Double.valueOf(y.getY()).hashCode();
//		hash = 31 * hash + Double.valueOf(z.getX()).hashCode();
//		hash = 31 * hash + Double.valueOf(z.getY()).hashCode();
//		return hash;
//	}
	
	
	public int hashCode() {
		int a = Double.valueOf(x.getX()).hashCode();
		int b = Double.valueOf(x.getY()).hashCode();
		int c = Double.valueOf(y.getX()).hashCode();
		int d = Double.valueOf(y.getY()).hashCode();
		int e = Double.valueOf(z.getX()).hashCode();
		int f = Double.valueOf(z.getY()).hashCode();
		a = (a + b) * (a + b + 1) + b;
		b = (c + d) * (c + d + 1) + d;
		c = (e + f) * (e + f + 1) + f;
		return (a + b) * (a + b + c) + b;
	}
	
}
