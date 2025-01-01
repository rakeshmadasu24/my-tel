package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class packagesjsp {
	 private String contact;
	    private String package1;
	    PreparedStatement st;
	    Connection con;
	    public packagesjsp(){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("loaded");
	            con=DriverManager.getConnection("jdbc:mysql://localhost/first", "root","Rakesh@143");
	            System.out.println("connected");

	        }
	        catch(Exception E){            
	            System.out.println(E);
	         }
	    }
	    
	public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getPackage1() {
			return package1;
		}

		public void setPackage1(String package1) {
			this.package1 = package1;
		}

	public void insert() {
		
	}

}
