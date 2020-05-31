package jspservlet.dao;

import java.util.ArrayList;

import jspservlet.vo.Feedback;
import jspservlet.vo.User;

public interface UserDAO {	
	public int queryByUsername(User user) throws Exception;
	public boolean regUserInfo(User user) throws Exception;
	public User getUserInformation(String username) throws Exception;
	public boolean setFeedback(Feedback feedback) throws Exception;
	public boolean setBoard(Feedback feedback , int id) throws Exception;
	public ArrayList<Feedback> getBoardInformation(int id) throws Exception;
	
}
