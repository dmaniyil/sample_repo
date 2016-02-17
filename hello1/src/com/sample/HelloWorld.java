package com.sample;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
    }
        // TODO Auto-generated con
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi","deepika","Changeme@123");
			Statement st =con.createStatement();
			ResultSet rs= st.executeQuery("select * from student");
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th> Student_id </th><th> student_name </th><tr>");
			while(rs.next())
			{
				String n=rs.getString("student_id");
				String nm=rs.getString("student_name");
				out.println("<tr><td>" + n +"</td><td>" + nm + "</td></tr");
				
			}
			 out.println("</table");
		
			 out.println("</html></body");
			 con.close();
			
		}
		catch(Exception e)
		{
			out.println("some exception is there");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
