package jspservlet.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

public class RegServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
	 }
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
		 
		 int count = 1;
		 User user = new User();
		 user.setUsername(req.getParameter("username"));
		 user.setPassword(req.getParameter("password"));
		 user.setEmail(req.getParameter("email"));
		 user.setAddress(req.getParameter("address"));
		 req.getSession().setAttribute("regUser", user);
		 UserDAO dao = new UserDAOImpl();   
		 
		 try {		
			 if(!dao.regUserInfo(user)){  //判断是否登录
				 res.sendRedirect("./register.jsp");
				 count = 0;
			 }
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(count == 1){
			 res.sendRedirect("./login.jsp");
		 }
		 
	 }
}
	 
