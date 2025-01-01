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

@WebServlet("/postpaidservlet")
public class postpaidservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public postpaidservlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res;
		//String contact1 = null;
		String contact=request.getParameter("contact");
      // pw.println(contact);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	         con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Rakesh@143");
	         pst= con.prepareStatement("select postpaidno from userdetails where contact=?");
	         pst.setString(1,contact);
	         res=pst.executeQuery();
	         
	        if(res.next()) {
	        	 contact=res.getString(1);
	        	 if(contact==null) {
	        		 pw.println("<html><body bgcolor=aqua >");	
						pw.println("<h2  style='text-align:center;'>Mytel </h2>");
				        pw.println("<h3 style='margin-left:15%;'>Welcome User");
				        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");
				      
				        pw.println("<h4 style='text-align:center;'>You do not have any Postpaid Numbers...</h4>");
				        pw.println("<h3 style='text-align:center;'><a href='mytelhome.jsp'>Home</a></h3></form>");
				        pw.println("</h3> </body></html>");
	        	 }else {
	        	pw.println("<html><body bgcolor=aqua >");	
				pw.println("<h2  style='text-align:center;'>Mytel </h2>");
		        pw.println("<h3 style='margin-left:15%;'>Welcome User");
		        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");
		      
		        pw.println("<h4 style='text-align:center;'>Your Postpaid Number :"+contact+"</h4>");
		        pw.println("<h4 style='text-align:center;'>Congrats... your Conversion  us completed.. Your new SIM will be delivered to your registered Address within 2/3 days<br><br></h4>");
		        pw.println("<h3 style='text-align:center;'><a href='mytelhome.jsp'>Home</a></h3></form>");
		        pw.println("</h3> </body></html>");
		        
		        pst=con.prepareStatement("update  userdetails set postpaidno=null where contact=?");					
				pst.setString(1, contact);
				pst.executeUpdate();
				
				 pst=con.prepareStatement("update  userdetails set prepaidno=? where contact=?");
					
					pst.setString(1, contact);					
					pst.setString(2,contact);
					pst.executeUpdate();
		        }
	        	
	        }
	        else{
	        	pw.println("<html><body bgcolor=aqua >");	
				pw.println("<h2  style='text-align:center;'>Mytel </h2>");
		        pw.println("<h3 style='margin-left:15%;'>Welcome User");
		        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");
		      
		        pw.println("<h4 style='text-align:center;'>You do not have any Postpaid Numbers...</h4>");
		        pw.println("<h3 style='text-align:center;'><a href='mytelhome.jsp'>Home</a></h3></form>");
		        pw.println("</h3> </body></html>");
			}}
		catch(Exception e) {
			}
		
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

}
