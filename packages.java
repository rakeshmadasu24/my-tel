package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/packages")
public class packages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public packages() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res;
		  HttpSession session = null;

		String contact=request.getParameter("contact");
        String package1=request.getParameter("package");
        
        
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Rakesh@143");
	    pst=con.prepareStatement("select prepaidno from userdetails where contact=?");
		pst.setString(1,contact);
		res=pst.executeQuery();
	    
		if(res.next())	{
	String	contact1=res.getString(1);	
		if(contact1!=null) {
		
		pst=con.prepareStatement("select details,amount from packages where package=?");
		
		pst.setString(1, package1);
		res=pst.executeQuery();
			if(res.next()){				
				String package2=res.getString(1);
				String amount=res.getString(2);	
			
			pw.println("<html><body bgcolor=aqua >");	
			pw.println("<h2  style='text-align:center;'>Mytel </h2>");
	        pw.println("<h3 style='margin-left:15%;'>Welcome User");
	        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");
	      
	       // pw.println("<h4 style='text-align:center;'>"+amount+"</h4>");
	        pw.println("<h4 style='text-align:center;'>"+package2+"</h4>");
	        pw.println("<form action='payment1.jsp' method='post'>");
	       

	        pw.println("<h3 style='text-align:center;'><input type=submit value=Proceed></h3></form>");
	        pw.println("<a href='mytelhome.jsp' style='text-align:center;'>Home</a>");
	        pw.println("</h3> </body></html>");
	        
	       
	    if(contact!=null) {
	        pst=con.prepareStatement("update userdetails set balance=? where contact=?");
			pst.setString(1, amount);
			pst.setString(2,contact);
			int val=pst.executeUpdate();
			//pw.println("sucess");
			} 
	        	else {
	        		pw.println("fail");
	        		} 
			}
	        	
		else {
			pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
			pw.println("<h3 style='text-align:center;'> Provide corerct package<br>");
	        pw.println("<a href='rechargemodule.jsp'>Back</a>");
			pw.println("</h3> </body></html>");
		} 
		}
			else {
				pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
				pw.println("<h3 style='text-align:center;'> You do not have any Prepaid Numbers<br>");
		        pw.println("<a href='rechargemodule.jsp'>Back</a>");
				pw.println("</h3> </body></html>");
				}
		}
			else {
				pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
				pw.println("<h3 style='text-align:center;'>You do not have any Prepaid Numbers<br>");
		        pw.println("<a href='rechargemodule.jsp'>Back</a>");
				pw.println("</h3> </body></html>");
				
				}
			
			
			
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		try {
			pst.close();
			con.close();
		} catch (SQLException e2) {
			e2.printStackTrace(); 
		}
	
		}

}
