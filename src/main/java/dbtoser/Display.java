package dbtoser;

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.sql.*;
import java.util.ArrayList;
import java.util.List; 

	 /*
	  	With this servlet, I am going to display the recent transactions on the count of 5 with the help of "dis.jsp" file.
	 */

@WebServlet(urlPatterns = "/display.do")
    
public class Display extends HttpServlet  {    
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{  
         try{   
        	 
        	 //the list object is created to store the data which is traversed from the database using the query
        	 List<Transaction> items=new ArrayList<>();
        	 
        	 //obtaining the connection to the database
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactiondb?useSSL=false", "student", "student");    
             
             //creating a statement 
             Statement stmt = con.createStatement(); 
             
             //executing the query with statement object and storing in the result set
             ResultSet rs = stmt.executeQuery("select * from transaction where tranid!=1 order by tranid desc limit 5;");  
             
             //traversing the result set one by one and storing it in the list object already created i.e items 
             while (rs.next()) 
             {  
                 items.add(new Transaction(rs.getString("Tranid"),rs.getString("statusinfo"),rs.getInt("balance")));
             }  
             
             //setting the attribute "items" as "data" in the dis.jsp file to access the "items" list data in the dis.jsp file 
             req.setAttribute("data", items);
             
             //forwarding this servlet to "dis.jsp"
             req.getRequestDispatcher("/WEB-INF/views/dis.jsp").forward(req, res);
             
             //closing the connection
             con.close();  
             
            }  
            catch (Exception e){  
                e.printStackTrace();
            }  
     } 
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		//on clicking the fund transfer button in "dis.jsp" file,Post request is raised and is going to get handled by this servlet.
		//In this servlet's post method definition,this is redirected to the servlet with the url pattern "fundtransfer.do".
		res.sendRedirect("/dbtoser/fundtransfer.do");	
	}
	
 }  
