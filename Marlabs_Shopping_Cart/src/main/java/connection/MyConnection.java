package connection;
import java.io.IOException;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyConnection  {
	Connection con;
	String str1 = "select user_name,user_password from cart_products.users;";
	String str2 = "select * from cart_products.product_details where id = ?;";
    Statement preparedStatement;
    PreparedStatement preparedStatement2;
    public ResultSet resultSet = null;
    String user;
    String pass;
	public boolean getConnection (String userName, String Password) throws Exception
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart_products","root", "Pinakin09");
	

		int count = 0;
		boolean a;
		preparedStatement = con.createStatement();
		resultSet = preparedStatement.executeQuery(str1);
		while(resultSet.next())
		{
			user = resultSet.getString(1);
			pass = resultSet.getString(2);
			
			if(userName.equals(user) && Password.equals(pass))
			{
				count = count+1;
			}
			userName = user;
		}
		if(count>0)
		{
			a=true;
		}
		else
		{
			a=false;
		}
		   System.out.println(userName);
			return a;
		
	
	
}
	public ResultSet result(String str) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart_products","root", "Pinakin09");
		preparedStatement = con.createStatement();
		ResultSet resultSet = preparedStatement.executeQuery(str);
		return resultSet;
	}
	public void getItemsCount(int i) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		preparedStatement2 = con.prepareStatement(str2);
		preparedStatement2.setInt(1, i);
		resultSet = preparedStatement2.executeQuery();
		while(resultSet.next())
		{
			System.out.println(resultSet.getString(1));
		}
		
	}
}	

