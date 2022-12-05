package com.onyeka.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.onyeka.DAO.TaskDAO;
import com.onyeka.DBConnection.DbConnection;

/**
 * Servlet implementation class MarkComplete
 */
public class MarkComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkComplete() {
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
		int TaskID=Integer.parseInt(request.getParameter("TaskID"));
		TaskDAO td=new TaskDAO(DbConnection.getConnection());
		if(td.MarkComplete(TaskID)>0) {
			response.sendRedirect("Tasks.jsp");
		}else {
			writer.println("<h2>An error occured</h2>");
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
