package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/paymentui")
public class paymentui extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public paymentui() {
        super();    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = null;
		  PrintWriter pw=response.getWriter();
		  String contact = (String) request.getAttribute("contact");
		  String package1 = (String) request.getAttribute("package1");
		  // perform processing
		  RequestDispatcher dispatcher = request.getRequestDispatcher("rechargedone");
		  dispatcher.forward(request, response);
		  pw.println(package1);
		  pw.println(contact);
		  
		
	
	}

}
