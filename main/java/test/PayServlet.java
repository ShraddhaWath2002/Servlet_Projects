package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/pay")
public class PayServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String required = req.getParameter("req");
			String code = req.getParameter("code");	
			BookBean bb = new PayDAO().getBookDetails(code);
			
			float pay = (bb.getPrice() * Integer.parseInt(required));
			int rem= (bb.getQty() - Integer.parseInt(required));
			
			bb.setQty(rem);
			
			int k = new PayDAO().update(bb);
			if(k > 0) {
				req.setAttribute("payable", pay);
				req.getRequestDispatcher("Pay.jsp").forward(req, res);
			}
		}
	}
}
