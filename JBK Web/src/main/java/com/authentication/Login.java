package com.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk?useSSL=false","root","root");
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM userdata WHERE Email = (?) and Password = (?);");
		stmt.setString(1, email);
		stmt.setString(2, pass);
		ResultSet rs =  stmt.executeQuery();
		
		if(rs.next())
		{
			req.setAttribute("fn", rs.getString("Firstname"));
			req.setAttribute("ln", rs.getString("Lastname"));
			req.setAttribute("email",  rs.getString("Email"));
			req.setAttribute("mobile",  rs.getLong("Mobile"));
			req.setAttribute("city",  rs.getString("City"));
			req.setAttribute("state",  rs.getString("State"));
			req.setAttribute("password", rs.getString("Password"));
			req.setAttribute("gender", rs.getString("Gender"));
		
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
		    rd.forward(req, resp);
		   }
		
		else {
			System.out.println("No user found");
		}
		conn.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
