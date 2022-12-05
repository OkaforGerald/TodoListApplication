package com.onyeka.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.onyeka.DAO.ListDAO;
import com.onyeka.DBConnection.DbConnection;
import com.onyeka.model.User;

/**
 * Servlet implementation class NewList
 */
public class NewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String desc=request.getParameter("desc");
		ListDAO ld=new ListDAO(DbConnection.getConnection());
		HttpSession session=request.getSession();
		User auth=(User)session.getAttribute("auth");
		if(ld.insertList(desc,auth.getUserId())>0) {
			response.sendRedirect("home.jsp");
		}else {
			writer.println("<p><style='text-color:red;'>A problem occured</p>");
		}
	}

}
