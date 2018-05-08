import java.util.ArrayList;

public class Tree<K extends Comparable<K>,V> {

    private static class Node<K,V> {
        private K key;                 // sorted by key
        private V val;                 // associated data
        private Node<K,V> left, right; // left & right subtree
        private int N;                 // # nodes in subtree

        public Node(K key, V val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

	public String toString() {
	    return "(" + key + ":" + val + ")";
	}
}

    private Node<K,V> root;

    public Tree() { root = null; }

    private int height(Node<K,V> x) {
	if(x == null)
	    return 0;
	return Math.max(height(x.left),height(x.right)) + 1;
    }

    // returns the height of the tree.
    public int height() { return height(root); }

    private int size(Node<K,V> x) {
	if(x == null)
	    return 0;
	return size(x.left) + size(x.right) + 1;
    }

    // returns the number of nodes in the tree.
    public int size() { return size(root); }

    private int numLeaves(Node<K,V> x) {
	if(x == null)
	    return 0;
	if(x.left == null && x.right == null)
	    return 1;
	return numLeaves(x.left) + numLeaves(x.right);
    }

    // returns the number of leaves in the tree.
    public int numLeaves() { return numLeaves(root); }

    private String toString(Node<K,V> x) {
	if(x == null)
	    return "";
	return toString(x.left) + x + toString(x.right);
    }

    // returns the String representation of the tree.
    public String toString() { return toString(root); }

    private Node<K,V> minimum(Node<K,V> x) { // Modified to return the node.
	// Assumes x != null.
	if(x.left == null)
	    return x;
	return minimum(x.left);
    }

    // returns the minimum key of the tree.
    public K minimum() {
	if(root == null)
	    return null;
	return minimum(root).key;
    }

    private Node<K,V> maximum(Node<K,V> x) {
	// Assumes x != null.
	if(x.right == null)
	    return x;
	return maximum(x.right);
    }

    // returns the maximum key of the tree.
    public K maximum() {
        if(root == null)
	    return null;
	return maximum(root).key;
    }

    private K floor(Node<K,V> x, K key) {
	if(x == null)
	    return null;
	int cmp = key.compareTo(x.key);
	if (cmp < 0)
	    return floor(x.left, key);
	else if (cmp > 0) {
	    K f = floor(x.right, key);
	    if (f == null)
		return x.key;
	    else
		return f;
	}
	else
	    return x.key;
    }

    // returns the floor of the key in the tree (the largest key <= key)
    public K floor(K key) { return floor(root, key); }

    private K ceiling(Node<K,V> x, K key) {
	if(x == null)
	    return null;
	int cmp = key.compareTo(x.key);
	if (cmp < 0) {
	    K f = ceiling(x.left, key);
	    if (f == null)
		return x.key;
	    else
		return f;
	}	    
	else if (cmp > 0)
	    return ceiling(x.left, key);
	else
	    return x.key;
    }

    // returns the ceiling of the key in the tree (the smallest key >= key)
    public K ceiling(K key) { return ceiling(root, key); }

    private V search(Node<K,V> x, K key) {
	if (x == null) return null;
	int cmp = key.compareTo(x.key);
	if      (cmp < 0) return search(x.left, key);
	else if (cmp > 0) return search(x.right, key);
	else              return x.val;
    }

    // returns the data associated with key, null if not found.
    public V search(K key) {
        return search(root, key);
    }

    private Node<K,V> insert(Node<K,V> x, K key, V val) {
        if (x == null) return new Node<K,V>(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = insert(x.left,key,val);
        else if (cmp > 0) x.right= insert(x.right,key,val);
        else              x.val  = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    // inserts the record (key,val) into the tree.
    public void insert(K key, V val) {
        if (val == null)
            delete(key);
        else 
            root = insert(root, key, val);
    }

    private Node<K,V> deleteMin(Node<K,V> x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    // deletes the record with the minimum key from the tree.
    public void deleteMin() {
        root = deleteMin(root); 
    }

    private Node<K,V> delete(Node<K,V> x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node<K,V> t = x;
            x = minimum(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    // deletes the record with the key from the tree.
    public void delete(K key) {
        root = delete(root, key);
    }
}