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

 
@WebServlet("/register")
public class registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String prepaid="prepaid";
	String postpaid="postpaid";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        String uname=request.getParameter("name");
        String ucontact=request.getParameter("contact");
        String uemail=request.getParameter("email");
        String upwd=request.getParameter("pwd");
        String uaddress=request.getParameter("address");
        String usertype=request.getParameter("usertype");
        
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	            con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Rakesh@143");
	         String query="insert into userdetails(name,contact,email,password,address) values(?,?,?,?,?)";
	            ps=con.prepareStatement(query);
	            ps.setString(1, uname);
	            ps.setString(2,ucontact);
	            ps.setString(3,uemail);
	            ps.setString(4, upwd);
	            ps.setString(5, uaddress);
	            int row=ps.executeUpdate();
	            if(usertype.equals(prepaid))
	            {
	            	ps=con.prepareStatement("update userdetails set prepaidno=? where contact=?");
	            	ps.setString(1,ucontact);
	            	ps.setString(2, ucontact);
	            	ps.executeUpdate();
	            }else {
	            	ps=con.prepareStatement("update userdetails set postpaidno=? where contact=?");
	            	ps.setString(1,ucontact);
	            	ps.setString(2, ucontact);

	            	ps.executeUpdate();
	            }
	            
	            
	            
	            if(row!=0) {
	            	pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
	    	        pw.println("<h2 >Rregistration Sucessful</h2>");
	    	        pw.println("<h4><a href='./login.html'>Login</a></h4>");
	    	        pw.println("</body></html>");
	            }
	            else {
	            	pw.println("invalid data");
	            }
	            
	     
				
	            }		catch(Exception e) {
			System.out.println(e);
		}

		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}	}

}
