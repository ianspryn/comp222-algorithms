package emh;

import javax.xml.soap.Node;

public class Homework3 {
	public static void main (String[] args) {
		int[] intArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		System.out.println(search(intArray, 0, intArray.length, 11));
	}
	
	public static int search(int[] array, int low, int high, int key) {
		int mid = (high + low) / 2;
		if (key == array[mid]) {
			return array[mid];
		} else if (key > array[mid]) {
			return search(array, (mid + 1), high, key);
		} else if (key < array[mid]) {
			return search(array, low, (mid - 1), key);
		} else {
			return -1;
		}
	}
	
	public static int insertSorted(int arr[], int n, int key, int capacity)
    {
        // Cannot insert more elements if n is already
        // more than or equal to capacity
        if (n >= capacity)
           return n;
      
        int i;
        for (i=n-1; (i >= 0 && arr[i] > key); i--)
           arr[i+1] = arr[i];
      
        arr[i+1] = key;
      
        return (n+1);
    }
  
	public static int[] insert(int[] array, int low, int high, int value) {
		if (array.length < 2) {
			if (value < array[0]) {
				
			}
		}
		int mid = (high + low) / 2;
		if (value == array[mid]) {
			return mid;
		} else if (key  > array[mid]) {
			return search(array, (mid + 1), high, key);
		} else {
			return search(array, low, (mid - 1), key);
		}
	}
	
	
	
	
	
	
	
	//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	int height(Node node) {
		if (node == null) {
			return 0;
		}
		return(1 + Math.max(height(node.left), height(node.right)));
	}
	int diameter(Node root) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + height(root.left) + height(root.right), Math.max(diameter(root.left), diameter(root.right)));
	}
}
