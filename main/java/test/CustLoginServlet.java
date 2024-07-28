package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/custLog")
public class CustLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CustomerBean cb = new CustLoginDAO().login(req.getParameter("uname"), req.getParameter("pword"));
		if(cb == null) {
			req.setAttribute("msg", "Invalid Login credentials....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			HttpSession hs = req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("CustLogin.jsp").forward(req, res);
		}
	}
}
