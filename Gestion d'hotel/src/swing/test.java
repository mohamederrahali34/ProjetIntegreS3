package swing;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    test()
    {
    try{

        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test" ,"root","");

                    stmt=con.prepareStatement("select * from test ");
                    System.out.println("hoiii");                
    }

    catch (Exception e) 
    {
        System.out.println(e);
    }
}
    public static void main(String[] args) {
    	test a=new test();
    	
    }
}