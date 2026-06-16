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
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<meta charset='UTF-8'>");
			    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
			    out.println("<title>Success</title>");
			    out.println("<style>");
			    out.println("  body { background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; font-family: 'Segoe UI', sans-serif; }");
			    out.println("  .card { background: white; padding: 2.5rem; border-radius: 10px; box-shadow: 0 10px 25px rgba(0,0,0,0.1); text-align: center; max-width: 400px; width: 90%; }");
			    out.println("  .icon { font-size: 3.5rem; color: #2ecc71; margin-bottom: 1rem; }");
			    out.println("  h2 { color: #2c3e50; margin: 0 0 0.5rem 0; }");
			    out.println("  p { color: #7f8c8d; margin-bottom: 1.5rem; font-size: 0.95rem; }");
			    out.println("  .btn { display: inline-block; padding: 0.75rem 1.5rem; background-color: #4a90e2; color: white; text-decoration: none; border-radius: 5px; font-weight: 600; transition: background 0.2s; }");
			    out.println("  .btn:hover { background-color: #357abd; }");
			    out.println("</style>");
			    out.println("</head>");
			    out.println("<body>");
			    out.println("  <div class='card'>");
			    out.println("    <div class='icon'>✓</div>");
			    out.println("    <h2>Success!</h2>");
			    out.println("    <p>The company data has been successfully saved to your database.</p>");
			    out.println("    <a href='index.html' class='btn'>Go Back to Form</a>");
			    out.println("  </div>");
			    out.println("</body>");
			    out.println("</html>");
			} else {
			    out.println("<h3 style='color: red; text-align: center; font-family: sans-serif; margin-top: 50px;'>Error: No data was saved. Please try again.</h3>");
			}
			
			con.close();
				   
	   }catch(Exception e) {
		out.println("Error:"+e.getMessage()); 
		e.printStackTrace();
	   }
		
	}

}
