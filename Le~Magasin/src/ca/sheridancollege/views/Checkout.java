package ca.sheridancollege.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Product;

/**
 * Servlet implementation class Checkout to show the total price 
 * of all items "purchased", so to speak.
 * @author Sina Lyon
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter stdout = response.getWriter();
		
		stdout.print("<head> <title>Le~Magasin</title> <link ref=stylesheet src=css/style.css> </head>");
		
		List<Product> shoppingCart = (CopyOnWriteArrayList<Product>) request.getSession().getAttribute("shoppingCart");
		
		stdout.print("<body style='background: rgb(90%, 90%, 90%); text-align:center;'><h1 style='font-size: 40px; text-decoration:underline;'>Total Spent</h1>");
		double sum = 0;
		for(Product item : shoppingCart) {
			System.out.println(item);
			sum += item.getPrice();
		}
		stdout.printf("<p style='font-size: 35px;'>%.2f</p>", sum);
		
		stdout.print("</li> <a style='"
				+ "font-size: 40px;"
				+ "background:whitesmoke;"
				+ "text-decoration: none;"
				+ "color:black;"
				+ "padding: 10px;"
				+ "margin: 20px;"
				+ "border-radius: 10px;' "
				+ "href=Home.html>Continue Shopping</a>");
		stdout.print("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
