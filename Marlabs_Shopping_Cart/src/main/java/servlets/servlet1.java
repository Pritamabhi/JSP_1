package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.MyConnection;

public class servlet1 extends HttpServlet {
	boolean b;
	boolean ab;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		try{
			PrintWriter out1 = response.getWriter();
		}
		catch(Exception e){
			System.out.println(e);
		}
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		MyConnection myConnection = new MyConnection();
		try {
			ab = myConnection.getConnection(userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if(b == true)
		//{
			//out.println("welcome");
		//}
		//else
		//{
			//out.println("cannot enter");
		//}
		if(ab == true){
			response.sendRedirect("thankyou.jsp");
		}
		else
		{
			response.sendRedirect("thankyou2.jsp");
		}
		

	}
	
}
