package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paymentbil")
public class paymentbil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public paymentbil() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
	
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet res;
		pw.println("<html><body bgcolor=aqua >");	
		pw.println("<h2  style='text-align:center;'>Mytel </h2>");
        pw.println("<h2 style='margin-left:15%;'>Welcome User");
        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");	      
        pw.println("<h3 style='text-align:center;'>Enter Payment Details");
        pw.println("</h2> </body></html><center>");
        pw.println("<form action='rechargedone.jsp' method=\"post\" >\r\n"
        		+ "<table >\r\n"
        		+ "<tr>\r\n"
        		+ "<td>Enter Debit Card No. :</td>\r\n"
        		+ "<td><input type=\"text\" name=\"cardno\" required><br><br></td>\r\n"
        		+ "</tr>\r\n"
        		+ "<tr>\r\n"
        		+ "<td>Expiry Date :</td>\r\n"
        		+ "<td><input type=\"text\" name=\"date\" required><br><br></td>\r\n"
        		+ "</tr>\r\n"
        		+ "<tr>\r\n"
        		+ "<td>CVV :</td>\r\n"
        		+ "<td><input type=\"text\" name=\"cvv\" required><br><br></td>\r\n"
        		+ "</tr>\r\n"       	
        		+ "</table>"
        		+"<input type=submit value=Confirm><br>\r\n");
        pw.println("<a href='mytelhome.jsp'>Home</a>");
        pw.println("</h3> </center</body></html>");
        
        try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

}
