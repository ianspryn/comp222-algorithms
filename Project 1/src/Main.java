
public class Main {
	public static void main(String[] args) {
		 TwoKey<String, Integer, Integer> db = new TwoKey<String, Integer, Integer>();
		 db.insert("Sam", 1, 2);
		 db.insert("Joe", 2, 3);
		 db.insert("Wilma", 3, 5);
		 db.insert("Bob", 4, 7);
		 System.out.println(db.search1("Wilma"));
		 System.out.println(db.search2(4));
		 System.out.println(db.list1());
		 System.out.println(db.list2());
		 db.modify1("Sam", 11);
		 db.modify1("Joe", 13);
		 db.modify2(1, 17);
		 db.change1("Bob", 5);
		 db.change2(3, "Pebbles");
		 System.out.println(db.list1());
		 System.out.println(db.list2());
		 System.out.println(db.search1("Foo"));
		 }
}
