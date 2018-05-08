/*
 * Author: Ian Spryn
 */
public class TwoKey<K1 extends Comparable<K1>, K2 extends Comparable<K2>, D> {
	
	private Tree<K1, Data<K1, K2, D>> tree1;
	private Tree<K2, Data<K1, K2, D>> tree2;
	
	public TwoKey() {
		tree1 = new Tree<K1, Data<K1, K2, D>>();
		tree2 = new Tree<K2, Data<K1, K2, D>>();
	}
	
	private static class Data<K1, K2, D> {
		
        private K1 key1;
        private K2 key2;
        private D data;
        
        public Data(K1 key1, K2 key2, D data) {
            this.key1 = key1;
            this.key2 = key2;
            this.data = data;
        }
        
        public String toString() {
        	return data.toString();
        }
	}
	
	// insert a record into the map. it is an error if record already exists.
	public void insert(K1 key1, K2 key2, D data) {
		Data<K1, K2, D> newData = new Data<K1, K2, D>(key1, key2, data);
				
		if(tree1.search(key1) == null) {
			tree1.insert(key1, newData);
		} else {
			System.err.println("Error. Item already exists.");
		}
		if(tree2.search(key2) == null) {
			tree2.insert(key2, newData);
		} else {
			System.err.println("Error. Item already exists.");
		}
	}
	
	// search and return the data associated with key1
	public D search1(K1 key1) {
		return tree1.search(key1) == null ? null : tree1.search(key1).data;
	}
	
	// search and return the data associated with key2
	public D search2(K2 key2) {
		return tree2.search(key2) == null ? null : tree2.search(key2).data;
	}
	
	// modify the record associated with key1 to contain the new data
	public void modify1(K1 key1, D data) {
		K2 key2 = tree1.search(key1).key2;
		tree1.delete(key1);
		tree1.insert(key1, new Data<K1, K2, D>(key1, key2, data));
		tree2.delete(key2);
		tree2.insert(key2, new Data<K1, K2, D>(key1, key2, data));
	}
	
	// modify the record associated with key2 to contain the new data
	public void modify2(K2 key2, D data) {
		K1 key1 = tree2.search(key2).key1;
		tree2.delete(key2);
		tree2.insert(key2, new Data<K1, K2, D>(key1, key2, data));
		tree1.delete(key1);
		tree1.insert(key1, new Data<K1, K2, D>(key1, key2, data));
		
		
	}
	// delete the record associated with key1
	public void delete1(K1 key1) {
		K2 key2 = tree1.search(key1).key2;
		tree1.delete(key1);
		tree2.delete(key2);
	}
	
	// delete the record associated with key2
	public void delete2(K2 key2) {
		K1 key1 = tree2.search(key2).key1;
		tree2.delete(key2);
		tree1.delete(key1);
	}
	
	// change the second key of the record associated with key1 to be key2
	public void change1(K1 key1, K2 key2) {
		if(tree1.search(key1) == null) {
			System.err.println("Error. Item does not exist.");
		} else {
			D data = tree1.search(key1).data;
			delete1(key1);
			insert(key1, key2, data);
		}
	}
	
	// change the first key of record associated with key2 to be key1
	public void change2(K2 key2, K1 key1) {
		if(tree2.search(key2) == null) {
			System.err.println("Error. Item does not exist.");
		} else {
			D data = tree2.search(key2).data;
			delete2(key2);
			insert(key1, key2, data);
		}	
	}

	// return the list (key, data) in order by key1 as a String
	public String list1() {
		return tree1.toString();
	}
	
	// return the list (key, data) in order by key2 as a String
	public String list2() {
		return tree2.toString();
	}
}