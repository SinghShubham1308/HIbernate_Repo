package com.notetracker.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetracker.entity.Note;
import com.notetracker.helper.FactoryProvider;

/**
 * Servlet implementation class Noteservlet
 */
public class Noteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Noteservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Note note = new Note(title, content, new Date());
			System.out.println(note);
			Session session = FactoryProvider.getFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(note);
			transaction.commit();
			session.close();
			// Redirect to a JSP file after saving data
	        RequestDispatcher dispatcher = request.getRequestDispatcher("show_notes.jsp");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		doGet(request, response);
	}

}
