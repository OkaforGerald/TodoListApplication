package com.onyeka.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.onyeka.DAO.ListDAO;
import com.onyeka.DBConnection.DbConnection;
import com.onyeka.model.ListP;
import com.onyeka.model.User;

/**
 * Servlet implementation class sortList
 */
public class sortList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sortList() {
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
		int userID=Integer.parseInt(request.getParameter("id"));
		String order=request.getParameter("order");
		if(order.equals("new")) {
		String query="SELECT ListID,UserId,ListName,date(DateCreated) FROM lists WHERE UserId=? ORDER BY DateCreated desc";
		ListDAO ld=new ListDAO(DbConnection.getConnection());
		User auth=(User)request.getSession().getAttribute("auth");
		ArrayList<ListP> sortedList=ld.getLists(auth.getUserId(), query);
		request.getSession().setAttribute("sortList", sortedList);
		response.sendRedirect("sortList.jsp");
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
