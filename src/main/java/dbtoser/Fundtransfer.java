package dbtoser;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.sql.*;

	 /*
	 	This servlet is used for handling the amount transfer from one account to another account
	 */

@WebServlet(urlPatterns = "/fundtransfer.do")
    
public class Fundtransfer extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{  
         try{   
             
        	 //getting the connection to the database
        	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactiondb?useSSL=false", "student", "student");    
             
        	 //getting the recent account balance
             int amount=current_amount(con);
             
             //If the balance is greater than 0,amount can be transfered and its status is success
             //otherwise,it is not possible and its status is denoted with Failure
             
             if(amount>0){
	             amount=amount-1000;
	             checking_amount(con,"Success",amount);
             }
             else{
            	 checking_amount(con,"Failure",amount);
             }
             
             //redirecting this servlet to display.do servlet for displaying the transactions and balance
             res.sendRedirect("/dbtoser/display.do");
             
             //closing the connection
             con.close(); 
             
         }  
         catch (Exception e){  
             e.printStackTrace();
         }  
     }  
	
	 //This function is used to get the present Account balance
	 public static int current_amount(Connection conn) throws SQLException {
		 
		 Statement stmt=conn.createStatement();
		 ResultSet Rs = stmt.executeQuery("select * from transaction order by tranid desc limit 1;");
		 Rs.next();
		 int amount=Rs.getInt("balance");
		 return amount;
	 
	 }
	 
	 //This function is used for inserting the newly done transaction details into the database.
	 //by calling the stored procedure named "Inserting_Transaction_Data".
	 public static void checking_amount(Connection con,String s,int amount) throws SQLException {
		 
		 CallableStatement myStmt = con.prepareCall("{call Inserting_Transaction_Data(?,?)}");
         myStmt.setString(1,s);
         myStmt.setInt(2, amount);
 		 myStmt.execute();
 
	 }
	 
 }  
