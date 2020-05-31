package jspservlet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservlet.dao.impl.CartDAOImpl;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.vo.Product;


public class CartServlet extends HttpServlet {
	
	private ProductDAOImpl idao = new ProductDAOImpl();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		boolean judge = true;
		try{    //判断商品数量是否输入正确
			int number =Integer.parseInt(req.getParameter("number"));
		}catch(NumberFormatException e){
			judge = false;
		}
		
		if(judge){     //数量输入正确则执行加入购物车
			
			CartDAOImpl cartdao = new CartDAOImpl();
			ProductDAOImpl pdao = new ProductDAOImpl();
			int pro_id = Integer.parseInt(req.getParameter("id"));
			String user_name = (String)req.getSession().getAttribute("username");
			String IN = (String)req.getSession().getAttribute("IN");
			int count =Integer.parseInt(req.getParameter("count"));
			boolean over = false;
			System.out.println(count);
			
			if(IN.equals("1")){
				
				if(count == 1){   //向购物车加入商品
					
					try {
						int number =Integer.parseInt(req.getParameter("number"));
						if(pdao.getProductNumberById(pro_id) >= number){
							if(cartdao.updataCartNum(number , pro_id , user_name)){    //判断是加入的商品是否与购物车中的相同
								cartdao.addCart(number , pro_id , user_name);  //没有相同产品则执行
							}
							else{   //有相同商品则执行
								ArrayList<Product> newproduct = cartdao.updataCart(number , pro_id , user_name);
								cartdao.clearCart( pro_id , user_name );
								for(int i = 0 ; i<newproduct.size(); i++){
									if(newproduct.get(i).getId() == pro_id){
										int newbuy = (newproduct.get(i).getBuynum() + number );
										double sum = (double)(newbuy * newproduct.get(i).getPrice());
										newproduct.get(i).setBuynum(newbuy);
										newproduct.get(i).setTotalprice(sum);
									}
								}
								cartdao.addSameCartList( newproduct , user_name );
							}
						}
						else{
							over = true;
						}
		
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(over){
						res.sendRedirect("noproduct.jsp");
					}
					
					else{
						res.sendRedirect("cart.jsp");
					}
				
				}
				
				
				else if(count == 2){   //删除购物车中商品
					
					try {
						cartdao.deleteCart(pro_id , user_name);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					res.sendRedirect("cart.jsp");
				}
				 
				
				
				else if(count == 3){    //支付并清空购物车
					ArrayList<Product> productlist = new ArrayList<Product>();

						try {
							 productlist = cartdao.findAllList(user_name);
							} catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						 if(productlist.size() != 0){
							 
						 try {
							cartdao.addList( productlist , user_name );
							cartdao.clearCart( pro_id , user_name );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
								res.sendRedirect("buysuccess.jsp");
				        }
						 
						 else{
							 res.sendRedirect("tip.jsp");
						 	}
						}
				}
			
			else{
				res.sendRedirect("needlogin.jsp");
			}
		}
		
		else{
			res.sendRedirect("tip.jsp");
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param req the req send by the client to the server
	 * @param res the res send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		    doGet(req,res);
	}
}