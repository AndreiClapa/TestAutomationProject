package testData;

import util.Reader;

public class Backpack {
	private String label;
	private String details;
	private String price;
	
	public Backpack(String fileName) {
		this.label = Reader.json(fileName).get("Label").toString();
		this.details = Reader.json(fileName).get("Details").toString();
		this.price = Reader.json(fileName).get("Price").toString();
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLabel() {
		return this.label;
	}
	public String getDetails() {
		return this.details;
	}
	public String getPrice() {
		return this.price;
	}
}

