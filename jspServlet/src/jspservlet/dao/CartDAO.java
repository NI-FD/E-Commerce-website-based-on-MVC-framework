package jspservlet.dao;

import java.util.ArrayList;
import java.util.List;

import jspservlet.vo.Product;

public interface CartDAO {
	public boolean addCart(int num , int id , String username) throws Exception;
	public boolean clearCart(int id, String username) throws Exception;
	public boolean deleteCart(int id, String username) throws Exception;
	public boolean updataCartNum(int num , int id, String username) throws Exception;
	public ArrayList<Product> findAllList(String username)  throws Exception;
	public boolean addList(ArrayList<Product> productlist , String username) throws Exception;
	public ArrayList<Product> updataCart(int num , int id, String username) throws Exception;
	public boolean addSameCartList(ArrayList<Product> productlist , String username) throws Exception;
	
}