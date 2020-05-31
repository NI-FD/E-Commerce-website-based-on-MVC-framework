package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import jspservlet.dao.CartDAO;
import jspservlet.db.DBConnect;

import jspservlet.vo.Product;

public class CartDAOImpl implements CartDAO{

	public boolean addCart(int num , int id , String username) throws Exception {
		boolean flag = false;
		ProductDAOImpl pdao = new ProductDAOImpl();
		Product product = pdao.getProductById(id);
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        try{
        	dbc = new DBConnect() ; 
	        String sql = "insert into cart(productname,product_id,number,price,total_price,username)values(?,?,?,?,?,?)";
	        pstmt = dbc.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, product.getName());  
	        pstmt.setInt(2, product.getId());  
	        pstmt.setInt(3, num); 
	        pstmt.setInt(4, product.getPrice()); 
	        pstmt.setDouble(5, (product.getPrice() * num)); 
	        pstmt.setString(6, username);
	        pstmt.executeUpdate();  
	        flag = true;
        }catch (Exception e) { 
        	return flag;  
        }  
        pstmt.close() ;  
        dbc.close();   //关闭数据库连接
		return flag;
	}

	public boolean clearCart( int id, String username) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from cart where username = '"+username+"'";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		int rs =0;
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeUpdate(sql);
			
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			dbc.close();
		}
		if(rs>0){
			return true;
		}
		return false;
	}

	public boolean deleteCart(int id, String username) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from cart where product_id = '"+id+"' and  username = '"+username+"'";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		int rs =0;
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeUpdate(sql);
			
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			dbc.close();
		}
		if(rs>0){
			return true;
		}
		return false;
	}

	public ArrayList<Product> findAllList(String username) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from cart where username = '"+username+"'";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		ArrayList<Product> list = new ArrayList<Product>();

		// ������������ݿ�ľ������
		try {
			// �������ݿ�
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				Product cart = new Product();
				cart.setId(rs.getInt("product_id"));
				cart.setName(rs.getString("productname"));
				cart.setPrice(rs.getInt("price"));
				cart.setTotalprice(rs.getInt("total_price"));
				cart.setBuynum(rs.getInt("number"));
				list.add(cart);
			}
			rs.close(); // ���ر�
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// �ر����ݿ�����
			dbc.close();
		}
		return list;
	}

	public boolean updataCartNum(int num , int id, String username) throws Exception {
		// TODO Auto-generated method stub
		int bool = 0;
		String sql = "select * from cart where username = '"+username+"' and product_id = '"+id+"'";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		// ������������ݿ�ľ������
		try {
			// �������ݿ�
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				if(rs.getInt("product_id") == id){	
					bool = 1;
				}
			}
			rs.close(); // ���ر�
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// �ر����ݿ�����
			dbc.close();
		}
		if(bool == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean addList(ArrayList<Product> productlist , String username) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		ProductDAOImpl pdao = new ProductDAOImpl();
		Product product = new Product();
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        try{
        	dbc = new DBConnect() ; 
	        String sql = "insert into olist(productname,product_id,number,price,total_price,username)values(?,?,?,?,?,?)";
	        pstmt = dbc.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        for(int i = 0 ; i<productlist.size(); i++){
	        	product = productlist.get(i);
	        	if(pdao.getProductNumberById(product.getId()) >= product.getBuynum()){
	        		pdao.updataProductNumber(product.getBuynum() , product.getId());
			        pstmt.setString(1, product.getName());  
			        pstmt.setInt(2, product.getId());  
			        pstmt.setInt(3, product.getBuynum()); 
			        pstmt.setInt(4, product.getPrice());
			        pstmt.setDouble(5, product.getTotalprice());
			        pstmt.setString(6, username);
			        pstmt.executeUpdate();  
	        	}
	        	else {
	        		return flag;
	        	}
	        }
	        flag = true;
        }catch (Exception e) { 
        	return flag;  
        }  
        pstmt.close() ;  
        dbc.close();   //关闭数据库连接
		return flag;
	}

	public ArrayList<Product> updataCart(int num, int id, String username) throws Exception {
		// TODO Auto-generated method stub
		int bool = 0;
		String sql = "select * from cart where username = '"+username+"'";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		ArrayList<Product> list = new ArrayList<Product>();
		int sum;

		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				Product cart = new Product();
				cart.setId(rs.getInt("product_id"));
				cart.setName(rs.getString("productname"));
				cart.setPrice(rs.getInt("price"));
				cart.setTotalprice(rs.getDouble("total_price"));
				cart.setBuynum(rs.getInt("number"));
				list.add(cart);
			}
			rs.close(); // ���ر�
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// �ر����ݿ�����
			dbc.close();
		}
		return list;
	}

	public boolean addSameCartList(ArrayList<Product> productlist, String username) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		ProductDAOImpl pdao = new ProductDAOImpl();
		Product product = new Product();
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        try{
        	dbc = new DBConnect() ; 
	        String sql = "insert into cart(productname,product_id,number,price,total_price,username)values(?,?,?,?,?,?)";
	        pstmt = dbc.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        for(int i = 0 ; i<productlist.size(); i++){
	        	product = productlist.get(i);
		        pstmt.setString(1, product.getName());  
		        pstmt.setInt(2, product.getId());  
		        pstmt.setInt(3, product.getBuynum()); 
		        pstmt.setInt(4, product.getPrice()); 
		        pstmt.setDouble(5, product.getTotalprice()); 
		        pstmt.setString(6, username);
		        pstmt.executeUpdate();  
	        }
	        flag = true;
        }catch (Exception e) { 
        	return flag;  
        }  
        pstmt.close() ;  
        dbc.close();   //关闭数据库连接
		return flag;
	}


}
