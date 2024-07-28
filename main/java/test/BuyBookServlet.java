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
@WebServlet("/buy")
public class BuyBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession();
		BookBean bb;
		if(hs==null) {
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bcode = req.getParameter("bcode");
			ArrayList<BookBean> al = new ArrayList<BookBean>();
			Iterator<BookBean> it= al.iterator();
			while(it.hasNext()) {
				bb = it.next();
				if(bcode.equals(bb.getCode())) {
					break;
				}
			}
		    bb = new BuyBookDAO().buy(bcode);
			hs.setAttribute("bbean", bb);
			if(bb==null) {
				req.setAttribute("msg", "Invalid Book Code....<br>");
				req.getRequestDispatcher("Home.jsp").forward(req, res);
			}else {
				req.getRequestDispatcher("BuyBook.jsp").forward(req, res);
			}
		}
	}
}
