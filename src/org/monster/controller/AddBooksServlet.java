package org.monster.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.monster.dao.IBooksDao;
import org.monster.entity.Books;
import org.monster.impl.BooksDaoImpl;

public class AddBooksServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddBooksServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //ת�����
		/**�ӱ���ȡ��ֵ**/
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		String price=request.getParameter("price"); //��Ҫת����Double����
		String publisherName=request.getParameter("publisherName");
		
		/**���������Ҹ�ֵ**/
	    Books books=new Books();
	    books.setIsbn(isbn);
	    books.setTitle(title);
	    books.setPrice(Double.parseDouble(price)); //���۸�ת��Ϊdouble����
	    books.setPubDt(new Date());
	    books.setPublisherName(publisherName);
	    
	    /**ִ����Ӳ���**/
	    IBooksDao dao=new BooksDaoImpl();
	    dao.addBooks(books);
	    
	    response.sendRedirect("BooksListServlet"); //ҳ����ת��booksList��
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
