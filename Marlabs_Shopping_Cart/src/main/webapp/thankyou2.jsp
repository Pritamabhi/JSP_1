<%@page import="connection.testing"%>
<%@page import="connection.MyConnection"%>
<%@page import="servlets.servlet1"%>
<%@ page import="java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "connection.testing" %>

<%@page import = "java.sql.*"  %>
</title>
</head>
<body>
<c:set var="i" value="5"/>  
<jsp:useBean id="someid" class="connection.MyConnection"></jsp:useBean>
<% testing test = new testing();
   MyConnection myConnection = new MyConnection();
   Connection con;
     
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart_products","root", "Pinakin09");

			if(con!=null){
				System.out.println("connected");
			}
			
		


   Statement preparedStatement;
   String str = "select id,product_name,price from cart_products.product_details;";
	preparedStatement = con.createStatement();
	ResultSet resultSet = preparedStatement.executeQuery(str);
%>
<form method = "get" action = "servlet1"> 
<table>
 <tr>
<th>NAME OF THE PRODUCT</th>
<th>PRICE OF THE PRODUCT</th>
<th>SELECT QUANTITY</th>
<th>ADD TO CART</th>
</tr>
     <%
    
     testing test2 = new testing();
     servlet1 servlet1 = new servlet1();
     ResultSet resultSet2 = test.getValues(); 
     int i = 0;
     
    
     while(resultSet.next())
    {
    	 i++;
    	 
	 %>
	 <tr>
	 
	 
	 <td>
	 <input type="text" name="text1" size="20" value="<%=resultSet.getString(2) %>">
	 </td>
	 <td>
	 
	 <input type="number" name="text2" size="100" value="<%=resultSet.getInt(3) %>">
	 
	 </td>
	 <td>
	
	 <input type = "number" name = "quantity" value = '<%=resultSet.getInt(1) %>'/>
	 
	 </td>
	 <td>
	 
	 <input type = "submit" name = "add" value = "ADD"/>
	 
	 </td>
	
	 
	</tr>
      <% 
        
      }%>
      </table>
      </form>
      
	
</body>
</html>