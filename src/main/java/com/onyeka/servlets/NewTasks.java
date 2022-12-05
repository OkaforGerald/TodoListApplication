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
import com.onyeka.DAO.TaskDAO;
import com.onyeka.DBConnection.DbConnection;
import com.onyeka.model.User;

/**
 * Servlet implementation class NewTasks
 */
public class NewTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTasks() {
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
		String desc=request.getParameter("desc");
		HttpSession session=request.getSession();
		TaskDAO td=new TaskDAO(DbConnection.getConnection());
		int ListID=(int) session.getAttribute("ListID");
		User user=(User)session.getAttribute("auth");
		if(td.insertTasks(desc, ListID,user.getUserId())>0) {
			response.sendRedirect("Tasks.jsp");
		}else {
			writer.println("<p><style='text-color:red;'>A problem occured</p>");
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
