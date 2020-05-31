<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="jspservlet.dao.impl.ProductDAOImpl"%>
<%@ page import="jspservlet.dao.impl.CartDAOImpl"%>
<%@ page import="jspservlet.vo.Product"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Splash &mdash; Free Website Template, Free HTML5 Template by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="FreeHTML5.co" />


  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
	    <base href="<%=basePath%>">
    
    <title>My JSP 'carttest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="MainWeb/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="MainWeb/css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="MainWeb/css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="MainWeb/css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="MainWeb/css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="MainWeb/css/owl.carousel.min.css">
	<link rel="stylesheet" href="MainWeb/css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="MainWeb/css/style.css">

	<!-- Modernizr JS -->
	<link type="text/css" rel="stylesheet" href="cart/css/style1.css" />
	<script src="MainWeb/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="MainWeb/js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<div class="page-inner">
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="index.jsp"> </a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="features.jsp">About</a></li>
						<li><a href="product.jsp">Product</a></li>
						<li><a href="contact.jsp">Contact</a></li>
						<%  
                            String IN = (String)session.getAttribute("IN");
							if(!IN.equals("1"))
							{
						%>
							<li class="has-dropdown">
							<a href="#">User</a>
							<ul class="dropdown">			
								<li ><a href="login.jsp">Login in</a></li>	    
							</ul>
						</li>
						<% 
							}
							else
							{
						%>		
						<li class="has-dropdown">
							<a href="#">User</a>
							<ul class="dropdown">			
								<li><a href="cart.jsp">Cart</a></li>
								<li><a href="information.jsp">information</a></li>
								<li><a href="welcome.jsp">Login out</a></li>		    
							</ul>
						</li>
						<%
						    }
						 %>
					  <!--<li class="btn-cta"><a href="index.html"><span>Login</span></a></li>-->
					</ul>
				</div>
			</div>
			
		</div>
	</nav>
	
	
	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(MainWeb/images/img_1.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					<h1>Cart</h1>
					   <a href="index.jsp">Home</a> >> <a href="product.jsp">Product</a>
					   <hr> 
					   <div id="shopping">
					   <form action="" method="">		
								<table>
					 			<tr>
									<th>Name</th>
									<th>Unit Price</th>
									<th>Number</th>
									<th>Total Price</th>
									<th>Operation</th>
								</tr>
									<!-- 循环的开始 -->
									<% 
									CartDAOImpl cartdao = new CartDAOImpl();
									ArrayList<Product> productlist =cartdao.findAllList((String)session.getAttribute("username"));
									Product product = new Product();   
									for(int i = 0 ; i < productlist.size() ; i++){
											product = productlist.get(i);
									%> 
									<tr name="products" id="product_id_1">
									<td><front style="color:white"><%=product.getName() %></front></td>
									<td><front style="color:white">$<%=product.getPrice() %></front></td>
									<td >
										<front style="color:white"><%=product.getBuynum()%></front>				
									</td>         
									<td >
										<front style="color:white"><span>$<%=product.getTotalprice()%></span></front>
									</td>               
									<td >
										<front style="color:red"><a href="cart?count=2&id=<%=product.getId()%>&number=0">delete</a></front>					                  
									</td>
									</tr>			
									    <% 
									         }
									     %>
									<!--循环的结束-->
						
								</table>
					
							</form>
							<div>
								<a href="cart?count=3&id=<%=product.getId()%>&number=0" >Pay Now</a>
							</div>
						</div>
           </div>
				
	<!-- jQuery -->
	<script src="MainWeb/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="MainWeb/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="MainWeb/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="MainWeb/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="MainWeb/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="MainWeb/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="MainWeb/js/jquery.magnific-popup.min.js"></script>
	<script src="MainWeb/js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="MainWeb/js/main.js"></script>

	</body>
</html>


