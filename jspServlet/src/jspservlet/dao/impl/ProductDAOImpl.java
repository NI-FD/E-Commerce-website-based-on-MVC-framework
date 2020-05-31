package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jspservlet.dao.ProductDAO;
import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Product;

public class ProductDAOImpl implements ProductDAO {
	// ������е���Ʒ��Ϣ
	public ArrayList<Product> getAllProduct() {
		DBConnect conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>(); // ��Ʒ����
		try {
			conn = new DBConnect();
			String sql = "select * from items;"; // SQL���
			pstmt = conn.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setNumber(rs.getInt("number"));
				product.setPrice(rs.getInt("price"));
				product.setPicture(rs.getString("picture"));
				product.setDetails(rs.getString("details"));
				list.add(product);// ��һ����Ʒ���뼯��
			}
			return list; // ���ؼ��ϡ�
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

// ������Ʒ��Ż����Ʒ����
public Product getProductById(int id) {
	DBConnect conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn = new DBConnect();
		String sql = "select * from items where id=?;"; // SQL���
		pstmt = conn.getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			Product item = new Product();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setNumber(rs.getInt("number"));
			item.setPrice(rs.getInt("price"));
			item.setPicture(rs.getString("picture"));
			item.setDetails(rs.getString("details"));
			item.setBuynum(1);
			return item;
		} else {
			return null;
		}

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

public ArrayList<Product> getOrdeList(String username) throws Exception {
	// TODO Auto-generated method stub
	String sql = "select * from olist where username = '"+username+"'";
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

public boolean updataProductNumber(int buy_number, int id) throws Exception {
	// TODO Auto-generated method stub
	if( getProductNumberById(id) >= buy_number){
		int number = (getProductNumberById(id)-buy_number);
		String sql = "update items set number='"+number+"' where id = '"+id+"'";
		System.out.print(sql);
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
		return true;
	}
	else{
		return false;
	}
	
}

public int getProductNumberById(int id) throws Exception {
	// TODO Auto-generated method stub
	String sql = "select * from items where id = "+ id +"";
	PreparedStatement pstmt = null;
	DBConnect dbc = null;
    int number = 0;
	try {
		dbc = new DBConnect();
		pstmt = dbc.getConnection().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) { 
			if(rs.getInt("id") == id){
				number = rs.getInt("number");
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
	return number;
}

}
