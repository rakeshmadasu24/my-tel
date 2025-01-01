package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profiledetails")
public class profiledetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public profiledetails() {
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
		pst=con.prepareStatement("select name,address from userdetails where contact=?");
		pst.setString(1,contact);
		res=pst.executeQuery();
		
		if(res.next()){
			String name=res.getString(1);
			String Address=res.getString(2);
		pw.println("<html><body bgcolor=aqua >");	
		pw.println("<h2  style='text-align:center;'>Mytel </h2>");
        pw.println("<h3 style='margin-left:15%;'>Welcome User");
        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a>");
        pw.println("<h4 style='text-align:center;'>Profile details :</h4><br>");
        pw.println("<h4 style='text-align:center;'>Name :  "+name+"</h4>");
        pw.println("<h4 style='text-align:center;'>Address :  "+Address+"</h4><br><br>");
        pw.println("<h4 style='text-align:center;'><a href='./mytelhome.jsp'>Home</a></h4>");
        pw.println("</h3> </body></html>");
	}
	else {
		pw.println("<html><body bgcolor=aqua style='text-align:center;'>");	
		pw.println("<h2  style='text-align:center;'>Mytel </h2>");
        pw.println("<h3 style='margin-left:15%;'>Welcome User");
        pw.println("<a href='login.html' style='margin-left:75%;'>Logout</a><br><br>");
		pw.println("<h3 style='text-align:center;'> Provide corerct Mobile Number<br>");
        pw.println("<h4 style='text-align:center;'><a href='./profile.jsp'>Back</a></h4>");
		pw.println("</h3> </body></html>");
	}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	

}
}