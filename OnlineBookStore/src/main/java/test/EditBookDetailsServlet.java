package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookDetailsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);
		if(hs ==null) {
			req.setAttribute("msg", "Session expired....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bcode = req.getParameter("bcode");
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("alist");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bcode.equals(bb.getCode())) {
					break;
				}
			}
			req.setAttribute("bbean", bb);
			req.getRequestDispatcher("EditBookDetails.jsp").forward(req, res);
		}
	}
}
