package ca.sheridancollege.beans;

import java.io.Serializable;

/**
 * The Product class is the model data being recorded
 * and producing objects through our ArrayList in the Cart.java 
 * servlet.
 * @author Sina Lyon
 *
 */
public class Product implements Serializable{

	private double price;
	private String name;

	public Product() {}
	
	public Product(double price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Product [price=" + price + " name="+ name +"]";
	}
	
}
