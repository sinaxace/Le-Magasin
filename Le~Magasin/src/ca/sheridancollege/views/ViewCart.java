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
 * Servlet implementation class ViewCart for displaying all chosen items.
 * @author Sina Lyon
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter stdout = response.getWriter();
		
		stdout.print("<head> <title>Le~Magasin</title> <link ref=stylesheet href=css/style.css> </head>");
		
		List<Product> shoppingCart = (CopyOnWriteArrayList<Product>) request.getSession().getAttribute("shoppingCart");
		
		stdout.print("<body style='text-align:center; background: rgb(90%, 90%, 90%);'>"
				+ "<h1 style='font-size: 40px; text-decoration:underline;'>Cart Items</h1> "
				+ "<main style='font-size: 35px; margin: 40px;'>");
		for(Product p : shoppingCart) {
			switch (Double.toString(p.getPrice())) {
			case "79.99":
				stdout.println("<li>British Navy Blue Suit - Checkered: " + p.getPrice());
				break;
			case "101.25":
				stdout.println("</li><li>French Linen Blazer - Pink: " + p.getPrice());
				break;
			case "40.45":
				stdout.println("</li><li>True Scottish Skirt - Green: " + p.getPrice());
				break;
			case "35.45":
				stdout.println("</li><li>True Scottish Skirt - Red: " + p.getPrice());
				break;
			case "29.99":
				stdout.println("</li><li>Suede Cowboy Torso - Western: " + p.getPrice());
				break;
			case "15.45":
				stdout.println("</li><li>Prospector's Hat - Black: " + p.getPrice());
				break;
			case "92.69":
				stdout.println("</li><li>Russian Winter Coat - Brown Fur: " + p.getPrice());
				break;
			case "100.02":
				stdout.println("</li><li>East Slavic Business Suit - Blue: " + p.getPrice());
				break;
			case "77.79":
				stdout.println("</li><li>Latino Ballroom Dance Suit - Black: " + p.getPrice());
				break;
			case "19.59":
				stdout.println("</li><li>Mexican Vacation Torso - Light Blue: " + p.getPrice());
				break;
			default:
				stdout.println("<li>Empty Cart");
				break;
			}
		}
		
		stdout.print("</main>");
		stdout.print("</li> <a style='"
				+ "font-size: 40px;"
				+ "background:whitesmoke;"
				+ "text-decoration: none;"
				+ "color:black;"
				+ "padding: 10px;"
				+ "margin: 20px;"
				+ "border-radius: 10px;' "
				+ "href=Home.html>Continue Shopping</a>");
		stdout.print("</li> <a style='"
				+ "font-size: 40px;"
				+ "background:whitesmoke;"
				+ "text-decoration: none;"
				+ "color:black;"
				+ "padding: 10px;"
				+ "margin: 20px;"
				+ "border-radius: 10px;' "
				+ "href=Checkout>Checkout</a> </body>");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
