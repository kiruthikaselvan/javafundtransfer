<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
<style>
table.center {
  margin-left:auto; 
  margin-right:auto;
}
</style>
</head>
<body>
 
	    <center><h3>Recent transactions made:</h3></center>
	    
		<table border=1 style=" width:300px; border-collapse: collapse; background-color: #f1f1c1;" class="center">
		
		<tr><th>TransId</th><th>status</th><th>balance</th></tr>
		
		<!-- 
			Displaying the database data in the form of table using "foreach" loop 
		    "data" variable used in the below code is a reference to "items" list object mentioned in the servlet.
		    "trans" is the loop variable
		-->
		<c:forEach var="trans" items="${data}">
		   <tr> 
			   <td style=" text-align:center; background-color: Aqua "> ${trans.tranid} </td>
			   <td style=" text-align:center; background-color: Aqua " > ${trans.state} </td>
			   <td style=" text-align:center; background-color: Aqua " > ${trans.balance} </td>
		   </tr>
		</c:forEach>
	    </table>
	    
	    <!-- post request raised after fund transfer button click,is handled by the fundtransfer.do servlet -->
	    <form method="post" action="/dbtoser/fundtransfer.do">
	         <br><br>
	         <center><input name="fund transfer" value="fund transfer" type="submit"></center>
	    </form>
	    <br><br>
	    
	    <!-- On clicking this link,logout servlet is called -->
	    <center><a href="/dbtoser/logout.do">logout</a></center>
	    
    </div>
    
</body>
</html>