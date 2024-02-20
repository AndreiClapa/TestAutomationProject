package testData;

import util.Reader;

public class Checkout {
	private String firstName;
	private String lastName;
	private String postalCode;
	
	public Checkout(String fileName) {
		this.firstName = Reader.json(fileName).get("firstName").toString();
		this.lastName = Reader.json(fileName).get("lastName").toString();
		this.postalCode = Reader.json(fileName).get("postalCode").toString();
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getPostalCode() {
		return this.postalCode;
}

}
