package main;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.*;
//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.MyConnection;

public class main_class {
	

	public static void main(String[] args) throws Exception {
		MyConnection myConnection = new MyConnection();
		boolean s = myConnection.getConnection("pinakin", "rane");
		System.out.println(s);
	}

}
