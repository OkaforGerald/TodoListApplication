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
 * Servlet implementation class removeFromAllTasks
 */
public class removeFromAllTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeFromAllTasks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		TaskDAO td=new TaskDAO(DbConnection.getConnection());
		int TaskID=Integer.parseInt(request.getParameter("id"));
		if(td.DeleteTask(TaskID)>0) {
			response.sendRedirect("AllTasks.jsp");
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
