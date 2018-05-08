package emh;

public class meh {
	
	public static void main (String[] args) {
		System.out.println(sum(74160));
		System.out.println(power(2, 3));
		int[] array = new int[] {4,5,7,8};
		System.out.println(arrayElement(array, 0, 8));
	}

	
	public static int sum(int n) {
		if (n == 0) {
			return n;
		} else {
			return sum(n/10) + n % 10;
		}
	}
	
	public static int power(int a, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return a;
		} else {
			return power(a, n - 1) * a;
		}
	}
	
	public static int arrayElement(int[] array, int position, int value) {
		if (array[position] > value) {
			return -1;
		} else if (array[position] == value) {
			return position;
		} else {
			return arrayElement(array, position + 1, value);
		}
	}
}
