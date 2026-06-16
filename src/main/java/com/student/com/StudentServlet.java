package com.student.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
		String name= request.getParameter("comp_name");
		String city=request.getParameter("city");
		
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root" ,"");
			String query = "INSERT INTO companies(comp_name,city) VALUES(?,?)";
			PreparedStatement ps= con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, city);
			
			int result = ps.executeUpdate();
			
			if (result > 0) {
			    request.getRequestDispatcher("success.jsp").forward(request, response);
			} else {
			    out.println("Error: No data saved");
			}
			
			con.close();
				   
	   }catch(Exception e) {
		out.println("Error:"+e.getMessage()); 
		e.printStackTrace();
	   }
		
	}

}
