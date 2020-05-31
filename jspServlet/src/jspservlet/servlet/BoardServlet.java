package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.Feedback;

public class BoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			 int judge = 0;
			 UserDAOImpl userdao = new UserDAOImpl();
			 Feedback feedback = new Feedback();
			 feedback.setFirstname((String)req.getSession().getAttribute("username"));
			 feedback.setDetails(req.getParameter("message"));
			 int pro_id = Integer.parseInt(req.getParameter("id"));
			 System.out.print(feedback.getFirstname().length());
			 
			 if(feedback.getFirstname().length() == 0 ){
				 judge = 1; 
			 }
			 
			 else if(feedback.getDetails().length() == 0  ){
				 judge = 2;
			 }
			 
		 if(judge != 1 && judge != 2){
			 
			 try {
					userdao.setBoard(feedback , pro_id); //向数据库写入留言的内容
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 res.sendRedirect("feedbacksuccess.jsp");
		 }
		 
		 else if(judge == 1){
			 res.sendRedirect("needlogin.jsp");
		 }
		 
		 else{
			 res.sendRedirect("tip.jsp");
		 }
		
	}

}
