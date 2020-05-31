package jspservlet.dao;

import java.util.ArrayList;

import jspservlet.vo.Product;

public interface ProductDAO {
	public ArrayList<Product> getAllProduct() throws Exception;
	public Product getProductById(int id) throws Exception;
	public ArrayList<Product> getOrdeList(String username) throws Exception;
	public boolean updataProductNumber(int buy_number , int id) throws Exception;
	public int getProductNumberById(int id) throws Exception;
}
