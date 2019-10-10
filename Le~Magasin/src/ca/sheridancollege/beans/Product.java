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
	
	public Product() {}
	
	public Product(double price) {
		super();
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + "]";
	}
	
}
