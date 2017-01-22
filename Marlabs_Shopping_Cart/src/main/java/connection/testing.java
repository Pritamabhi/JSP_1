package connection;
import connection.MyConnection;
import java.sql.*;

public class testing {
	public ResultSet resultSet = null;
	String name;
	String price;
	String[] array1 = new String[100];
	String str = "select product_name,price from cart_products.product_details;";
 public int getCount(){
	 return 4;
 }
  MyConnection myConnection = new MyConnection();
  public ResultSet getValues() throws Exception{
	  resultSet = myConnection.result(str);
	  int i = 0;
	  while(resultSet.next())
	  {
		 name = resultSet.getString(1);
		 price = Integer.toString(resultSet.getInt(2));
		 System.out.println(price);
		 i++;
	  }
	  return resultSet;
  }
  
  
}