package com.onyeka.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.onyeka.DAO.userDAO;
import com.onyeka.DBConnection.DbConnection;
import com.onyeka.model.User;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		userDAO ud=new userDAO(DbConnection.getConnection());
		User user = ud.getUser(email, password);
		if(user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("auth", user);
			response.sendRedirect("home.jsp");
		}else {
			writer.println("<div class='alert alert-warning' role='alert'>Invalid username/password</div>");
			RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
			dispatch.include(request, response);
		}
	}

}
