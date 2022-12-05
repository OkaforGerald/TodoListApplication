package com.onyeka.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.onyeka.DBConnection.DbConnection;

/**
 * Servlet implementation class Remove
 */
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		int ListId=Integer.parseInt(request.getParameter("id"));
		String query="DELETE FROM TASKS WHERE ListID=?";
		String query1="DELETE FROM LISTS WHERE ListID=?";
		Connection con= DbConnection.getConnection();
	    try {
			PreparedStatement pst=con.prepareStatement(query);
			PreparedStatement pst1=con.prepareStatement(query1);
			pst.setInt(1, ListId);
			pst1.setInt(1, ListId);
			pst.executeUpdate();
			pst1.executeUpdate();
			response.sendRedirect("home.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
