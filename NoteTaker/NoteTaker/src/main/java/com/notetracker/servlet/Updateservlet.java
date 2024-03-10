package com.notetracker.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetracker.entity.Note;
import com.notetracker.helper.FactoryProvider;

/**
 * Servlet implementation class Updateservlet
 */
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			String updateTitle = request.getParameter("updateTitle");
			String updateDescription = request.getParameter("updateContent");
			Session session = FactoryProvider.getFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Note note = session.get(Note.class, noteId);
			note.setDescription(updateDescription);
			note.setTitle(updateTitle);
			note.setCreatedDate(new Date());
			session.save(note);
			transaction.commit();
			session.close();
			response.sendRedirect("show_notes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
