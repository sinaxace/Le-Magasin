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
		request.getRequestDispatcher("ViewCart").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creating a list of Product objects.
		List<Product> toBuy = new CopyOnWriteArrayList<Product>();

		try {
			// Extract Checkbox values
			String[] prices = request.getParameterValues("cart");
			toBuy.clear(); // Making sure the list doesn't get repeated values.
			for (String i : prices) {
				toBuy.add(new Product(Double.parseDouble(i)));
			}
		} catch (NullPointerException nullpoint) {
			System.err.println("They didn't select any items."); //To let us know, but user won't see this.
			toBuy.add(new Product(0.00)); //Fill it with an empty Product.
		} finally {
			// Next we set the session variable with the toBuy List.
			request.getSession().setAttribute("shoppingCart", toBuy);
			doGet(request, response);
		}
	}

}
