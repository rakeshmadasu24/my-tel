package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paybills1")
public class paybills1 extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public paybills1() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String contact=request.getParameter("contact");
		PrintWriter pw=response.getWriter();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res;
		String due1=null;
		//pw.println(contact);
		
		
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Rakesh@143");
		pst=con.prepareStatement("select due from userdetails where postpaidno=?"); 
		pst.setString(1, contact);
		res=pst.executeQuery();
	 
		

		if(res.next()){			
				
			due1=res.getString(1);
			if(due1==null) {
				pw.println("<html><body bgcolor=aqua >");	
				pw.println("<center><h2  style='text-align:center;'>Mytel </h2>");
		        pw.println("<h2 style='margin-left:15%;'>Welcome User");
		        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");	      
		        pw.println("<h3 style='text-align:center;'>No Bill Due Amount</h3><br>");
		        pw.println("<a href='mytelhome.jsp'>Home</a>");
		        pw.println("</h2><center> </body></html>");
			}
			else {
				String contact1=new String(contact);
				request.setAttribute("contact1",contact1);
			pw.println("<html><body bgcolor=aqua >");	
			pw.println("<h2  style='text-align:center;'>Mytel </h2>");
	        pw.println("<h2 style='margin-left:15%;'>Welcome User");
	        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");	      
	        pw.println("<h3 style='text-align:center;'>Bill Due :"+due1+"</h3>");
	        pw.println("<form action='./paymentbil' method=post>");
	        pw.println("<h3 style='text-align:center;'><input type=submit value=Proceed></h3></form>");
	        pw.println("</h2> </body></html>");
	        
	        pst=con.prepareStatement("update  userdetails set due=null where contact=?");
			
			pst.setString(1, contact);
			
			//pst.setString(1,contact);

			pst.executeUpdate();
			}
			}
			else {
				pw.println("<html><body bgcolor=aqua >");	
				pw.println("<h2  style='text-align:center;'>Mytel </h2>");
		        pw.println("<h3 style='margin-left:15%;'>Welcome User");
		        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a><br><br>");	  
				pw.println("<h3 style='text-align:center;'> Provide correct number<br>");
		        pw.println("<a href='mytelhome.jsp'>Home</a>");
				pw.println("</h3> </body></html>");
				}
		
		}
	
		catch(Exception e) {
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
