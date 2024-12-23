package com.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		
		
		try {
			
			String firstName = req.getParameter("fn");
			String lastName = req.getParameter("ln");
			String email = req.getParameter("email");
			String mobileNo = req.getParameter("mobile");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pass = req.getParameter("passwd");
			String cpass = req.getParameter("cpasswd");
			String gender = req.getParameter("gender");
			String terms = req.getParameter("terms");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk?useSSL=false","root","root");
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO userdata(Firstname,Lastname,Email,Mobile,City,State,Password,Gender,Terms) VALUES(?,?,?,?,?,?,?,?,?);");
			stmt.setString(1,firstName);
			stmt.setString(2,lastName);
			stmt.setString(3,email);
			stmt.setLong(4, Long.parseLong(mobileNo));
			stmt.setString(5,city);
			stmt.setString(6,state);
			stmt.setString(7,pass);
			stmt.setString(8,gender);
			stmt.setString(9,terms);
			stmt.execute();
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.include(req, resp);
			
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
