package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Feedback;
import jspservlet.vo.Product;
import jspservlet.vo.User;


public class UserDAOImpl implements UserDAO {

	
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
  
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;   
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            System.out.println(user.getUsername());
            while(rs.next()){  
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if(rs.getString("password").equals(user.getPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return flag;
	}

	public boolean regUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        try{
        	dbc = new DBConnect() ; 
	        String sql = "insert into userinfo values(?,?,?,?)";
	        pstmt = dbc.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, user.getUsername());  
	        pstmt.setString(2, user.getPassword()); 
	        pstmt.setString(3, user.getEmail()); 
	    //    pstmt.setString(4, user.getGender()); 
	        pstmt.setString(4, user.getAddress());
	        pstmt.executeUpdate();  
	        flag = true;
        }catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) { 
        	return false;  
        }  
        catch(SQLException e){
        	System.out.print(e);
        }
        pstmt.close() ;  
        dbc.close();   //关闭数据库连接
		return true;
	}

	public User getUserInformation(String name) throws Exception {
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        User user = new User();
		try {
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
            while(rs.next()){  
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if(rs.getString("username").equals(name)){             	
                	user.setUsername(rs.getString("username"));
                	user.setEmail(rs.getString("email"));
                	user.setAddress(rs.getString("address"));
                	user.setPassword(rs.getString("password"));
                	return user;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return user;
	}

	public boolean setFeedback(Feedback feedback) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        try{
        	dbc = new DBConnect() ; 
	        String sql = "insert into feedback(first_name,email,subject,details)values(?,?,?,?)";
	        pstmt = dbc.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, feedback.getFirstname());  
	        pstmt.setString(2, feedback.getEmail()); 
	        pstmt.setString(3, feedback.getSubject()); 
	        pstmt.setString(4, feedback.getDetails());
	        pstmt.executeUpdate();  
	        flag = true;
        }
        catch(SQLException e){
        	System.out.print(e);
        }
        pstmt.close() ;  
        dbc.close();   //关闭数据库连接
		return true;
	}

	public boolean setBoard(Feedback feedback, int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        try{
        	dbc = new DBConnect() ; 
	        String sql = "insert into board(username,message,pro_id)values(?,?,?)";
	        pstmt = dbc.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, feedback.getFirstname());  
	        pstmt.setString(2, feedback.getDetails()); 
	        pstmt.setInt(3, id); 
	        pstmt.executeUpdate();  
	        flag = true;
        }
        catch(SQLException e){
        	System.out.print(e);
        }
        pstmt.close() ;  
        dbc.close();   //关闭数据库连接
		return true;
	}

	public ArrayList<Feedback> getBoardInformation(int id) throws Exception {
		// TODO Auto-generated method stub
		DBConnect conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Feedback> list = new ArrayList<Feedback>(); // ��Ʒ����
		try {
			conn = new DBConnect();
			String sql = "select * from board where pro_id = '"+id+"'";
			pstmt = conn.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Feedback feedback = new Feedback();
				feedback.setFirstname(rs.getString("username"));
				feedback.setDetails(rs.getString("message"));
				list.add(feedback);
			}
			return list; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}

