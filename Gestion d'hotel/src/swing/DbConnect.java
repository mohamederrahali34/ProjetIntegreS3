package swing;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

private Connection con ;
	
	public DbConnect() { 
		
		try{  
		//step1 load the driver class  
			Class.forName("com.mysql.jdbc.Driver");
			 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/hotel?serverTimezone=UTC" ,"root","root");
	        con.setAutoCommit(true);
	
		  
		}catch(Exception e) {
			System.err.println(e);
		
		   }
	}
	Connection getConn() {  //getcon
		return con;
	}
		  
		  

}