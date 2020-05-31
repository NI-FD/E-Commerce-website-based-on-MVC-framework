package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.Feedback;
import jspservlet.vo.User;

public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			 boolean judge = true;
			 UserDAOImpl userdao = new UserDAOImpl();
			 Feedback feedback = new Feedback();
			 feedback.setFirstname(req.getParameter("name"));
			 feedback.setEmail(req.getParameter("email"));
			 feedback.setSubject(req.getParameter("subject"));
			 feedback.setDetails(req.getParameter("message"));
			 
			 if(feedback.getFirstname().length() == 0 || feedback.getEmail().length() == 0 || feedback.getDetails().length() == 0 || feedback.getSubject().length() == 0 ){
				 judge = false;    //判断是否在文本框输入信息
			 }
		    if(judge){   //如果为true，向数据库写入反馈
			 
			 try {
					userdao.setFeedback(feedback);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 res.sendRedirect("feedbacksuccess.jsp");
		 }
		    
		 else{
			 res.sendRedirect("tip.jsp");  //如果反馈没写对格式，跳转到提示错误的页面
		 }
 
	}

}
