package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Product;

/**
 * Servlet implementation class Cart where we transfer the chosen items to ViewCart servlet 
 * by using session attributes.
 * @author Sina Lyon
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creating a list of Product objects.
		List<Product> toBuy = new CopyOnWriteArrayList<Product>();
		
		//If the list exists, override new list with previous one.
		if (request.getSession().getAttribute("shoppingCart") != null) {
			toBuy = (List<Product>) request.getSession().getAttribute("shoppingCart");
		}

		try {
			// Extract Checkbox price/name values
			String[] clothes = request.getParameterValues("cart");
			
			int i = 0;
			for(String c : clothes) {
				toBuy.add(createProduct(c));
				System.out.println(toBuy.get(i).getName()); //Testing object
				i++;
			}

			
		} catch (NullPointerException nullpoint) {
			System.err.println("They didn't select any items."); //To let us know, but user won't see this.
			toBuy.add(new Product(0.00, "Empty Cart")); //Fill it with an empty Product.
		} finally {
			// Next we set the session variable with the toBuy List.
			request.getSession().setAttribute("shoppingCart", toBuy);
			doGet(request, response);
		}
	}
	
	/**
	 * createProduct(value : String) is for generating a Product object out of the String
	 * value param that should be passed as an argument. 
	 * @param value is the full price/name value in one string.
	 * @return sends up the Product object created through the splitted String
	 */
	private Product createProduct(String value) {
		System.out.println("Before: "+value);
		
		String[] p = value.split("/"); //Creates delimiter and splits String into array
		
		System.out.println("Price: "+ p[0] +" Name: "+ p[1]); //Testing delimiter
		
		Product product = new Product(Double.parseDouble(p[0]), p[1]); //Adding seperate values to object creation.
		return product;	
	}

}
