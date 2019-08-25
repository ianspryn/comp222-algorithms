
public class Matrix {
	int[][] matrix;
	int n;
	
	public Matrix(int n) {
		this.n = n;
		matrix = new int[n][n];
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				str += matrix[i][j];
			}
			str += "\n";
		}
		return str;
	}
}
