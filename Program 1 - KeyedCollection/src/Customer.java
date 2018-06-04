/**
 * Class used for Customer Object with data from customers.txt
 * @author Ian Spryn
 */
public class Customer {
	//add private members here
	private Customer customer;
	private int key, zip;
	private float sales;
	private String firstName, middleName, lastName;
	
	/**
	 * Create a customer object with the provided customer id, zipcode, sales volume, first, middle, and last names
	 * 
	 * @param key customer id
	 * @param zip customer zipcode
	 * @param sales customer sales volume
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public Customer(int key, int zip, float sales, String firstName, String middleName, String lastName) {
		this.key = key;
		this.zip = zip;
		this.sales = sales;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;

	}
	
	/**
	 * Create an "empty" customer object with null strings and 0's for other values
	 */
	public Customer() {
		customer = new Customer(0, 0, 0, null, null, null);
	}
	
	
	
	//add getters and setters
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public float getSales() {
		return sales;
	}

	public void setSales(float sales) {
		this.sales = sales;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the Customer's last name
	 */
	public String toString() {
		return getLastName();
	}
}
