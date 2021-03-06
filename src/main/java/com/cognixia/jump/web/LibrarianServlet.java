package com.cognixia.jump.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookDAO;
import com.cognixia.jump.dao.BookDAOImpl;
import com.cognixia.jump.dao.LibrarianDAO;
import com.cognixia.jump.dao.LibrarianDAOImpl;
import com.cognixia.jump.model.Book;

@WebServlet("/librarian")
public class LibrarianServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LibrarianDAO librarianDAO;
	private BookDAO bookDAO;
	
	@Override
	public void init() {
		// creates connection and the DAO once needed
		librarianDAO = new LibrarianDAOImpl();
		bookDAO = new BookDAOImpl();
	}
	
	@Override
	public void destroy() {
		//close connection, ConnectionManager uses Singleton Design so closes same connection
		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String action = request.getServletPath();
		switch(action) {
		case "/addBook":
			addBook(request,response);
			break;
		case "/updateBook":
			updateBook(request,response);
			break;
		}
	}
	
	// Note: Will add librarian functions after sending changes to master
	private void addBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		boolean rented = Boolean.parseBoolean(request.getParameter("rented"));
		String addedToLibrary = request.getParameter("addedToLibrary");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAddedToLibrary = null;
		try {
			dateAddedToLibrary = (Date) format.parse(addedToLibrary);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (bookDAO.addBook(
				new Book(isbn, title, desc, rented, dateAddedToLibrary)))
			System.out.println("New book added: " + title);
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		boolean rented = Boolean.parseBoolean(request.getParameter("rented"));
		String addedToLibrary = request.getParameter("addedToLibrary");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAddedToLibrary = null;
		try {
			dateAddedToLibrary = (Date) format.parse(addedToLibrary);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(bookDAO.updateBook(
				new Book(isbn, title, desc, rented, dateAddedToLibrary)))
			System.out.println("Book updated: " + title);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
}