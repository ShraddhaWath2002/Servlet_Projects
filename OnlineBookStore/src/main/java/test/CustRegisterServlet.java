package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class CustRegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("uname"));
		cb.setPword(req.getParameter("pword"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setMid(req.getParameter("mid"));
		cb.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k = new CustRegisterDAO().register(cb);
		if(k > 0) {
			req.setAttribute("msg", "Customer Registered Successfully....<br>");
			req.getRequestDispatcher("CustRegister.jsp").forward(req, res);
		}
	}
}
