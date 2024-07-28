package test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllBooksServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			ArrayList<BookBean> al = new ViewAllBooksDAO().retrieve();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllBooks.jsp").forward(req, res);
		}
	}
}
