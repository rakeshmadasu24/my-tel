package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/mytel")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public userlogin() {
        // TODO Auto-generated constructor stub
    }
 		
 	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

 	    Connection con = null;
 	    PreparedStatement pst = null;
 	    ResultSet res;
 	    String email;    
 	    String pwd; 
 	   PrintWriter pw=response.getWriter();
 	   
		response.setContentType("text/html");
		 email=request.getParameter("name");
         pwd=request.getParameter("pwd");
         try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
         con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Rakesh@143");
         pst= con.prepareStatement("select * from userdetails where email=? and password=?");
         pst.setString(1,email);
         pst.setString(2, pwd);
         res=pst.executeQuery();
         
        if(res.next()) {
        	response.sendRedirect("./mytelhome.jsp");
        }
        else {
        	pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
	        pw.println("<h2 >Wrong username/password</h2>");
	        pw.println("<h4><a href='./login.html'>Login</a></h4>");
	        pw.println("</body></html>");
	        
        }
          
         }  catch (Exception e) {
 			e.printStackTrace();
 		}
	       
	        
         finally {
			 
				try {
					con.close();
					pst.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		 
         }
	        }
		}

