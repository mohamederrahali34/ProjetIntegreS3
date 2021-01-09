package swing;

import java.sql.Connection;
 
import java.sql.Statement;
 
import java.sql.DriverManager;
 
import java.sql.ResultSet;
 
import java.sql.ResultSetMetaData;
 
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
 
 
 
public class Test extends JFrame{
 
private static javax.swing.JList<String> list;
 
public static void main(String args[]) throws ClassNotFoundException, SQLException
 
{
 
Connection con ;
 
Statement Statement ;
 
ResultSet resultSet ;
ResultSetMetaData metaData ;
int numberOfColumns = 0;
DefaultListModel mod=new DefaultListModel();
 
try
 
{
 
Class.forName("com.mysql.jdbc.Driver");
 
con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/hotel?serverTimezone=UTC" ,"root","root");
 
//statement = connection.createStatement();
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from admin");  
while(rs.next())  
System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getInt(3)+  " " + rs.getString(4) + " " + rs.getString(5));  
con.close();  
 
System.out.println("Connection Established");
 
 
}catch(ClassNotFoundException | SQLException e){
    System.err.println(e);
}
}}