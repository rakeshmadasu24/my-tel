package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/balancedetails")
public class balancedetails extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    public balancedetails() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw=response.getWriter();
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet res;
	String contact=request.getParameter("contact");
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
   con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Rakesh@143");
	pst=con.prepareStatement("select balance from userdetails where prepaidno=?");
	pst.setString(1,contact);
	res=pst.executeQuery();
	
	if(res.next()){
		String balance=res.getString(1);
		if(balance==null) {
			pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
			pw.println("<h2  style='text-align:center;'>Mytel </h2>");
	        pw.println("<h3 style='margin-left:15%;'>Welcome User");
	        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a><br><br>");
			pw.println("<h3 style='text-align:center;'> You do not have any pack on this  Mobile Number<br>");
	        pw.println("<h4 style='text-align:center;'><a href='./mytelhome.jsp'>Home</a></h4>");

			pw.println("</h3> </body></html>");
		}
		else {
		pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
		pw.println("<h2  style='text-align:center;'>Mytel </h2>");
        pw.println("<h3 style='margin-left:15%;'>Welcome User");
        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a><br><br>");
		pw.println("<h3 style='text-align:center;'>Your Balance<br>");
		pw.println("<h3 style='text-align:center;'>"+balance+"<br>");
        pw.println("<h4 style='text-align:center;'><a href='./balance.jsp'>Back</a></h4>");
		pw.println("</h3> </body></html>");
	}}
	else {
		pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
		pw.println("<h2  style='text-align:center;'>Mytel </h2>");
        pw.println("<h3 style='margin-left:15%;'>Welcome User");
        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a><br><br>");
		pw.println("<h3 style='text-align:center;'> Provide corerct Mobile Number<br>");
        pw.println("<h4 style='text-align:center;'><a href='./balance.jsp'>Back</a></h4>");
        pw.println("<h4 style='text-align:center;'><a href='./mytelhome.jsp'>Home</a></h4>");

		pw.println("</h3> </body></html>");
	}
	
	
	}catch(Exception e)
	{
		System.out.println(e);
	}
	try {
		pst.close();
		con.close();
	} catch (SQLException e) {
		e.printStackTrace(); 
	}
	}

}
