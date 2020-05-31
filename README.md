# E-Commerce-website-based-on-MVC-framework
This is a project three years ago.

## Induction
This is a simple website with front-end and back-end code, it can run on local. The project uses Mysql as the database, and it use MVC framework to build the website.

## Features
- Support user login and registration
- Support real-time product stock change
- Support shopping cart
- Support history query
- All data are stored on the Mysql database

## Server Logic
- **Product Display**:Click the corresponding button on the page to browse the names and prices of all products
- **Product Details**: Click on the product to display the product details
- **Shopping Cart**: You can add products to the shopping cart and delete items in the shopping cart
- **Purchase Product(connect to database)**: Purchased goods can be connected to the database to dynamically change the number of goods, and can be automatically written into the previous order list after the goods are purchased, and the shopping cart is emptied. (In the entire process of shopping, the quantity of the database of the shopping cart and the quantity of the product inventory are connected in series)
- **User Information Display**:Can display user registration information, past orders
- **Get User Feedback**: Store user feedback in the database
- **Check User Status**: Set different pages according to login status
- **Logout Function**: After the user logs in, he can manually choose to log out of the current account
- **Product Message Board Function**: The user can leave a message on the favorite product page and write the message into the database. Each product's message is one-to-one correspondence. It can determine whether the user is logged in. Only the logged-in user is allowed to submit a message and view the message

## Database
- **cart**: id , productname , prouct_id , number , price , total_price , username
- **feedback**: id , first_name , email , subject , details
- **items**: id , name , prouct_id price , tnumber , picture , details
- **olist**: id , productname , prouct_id , number , price , total_price , username
- **userinfo**: username , password , email , address
- **board**: id , username , message , pro_id

## Package Structure
- dao->
	- UserDAO.java(User function interface) 
	- ProductDAO.java(Product function interface)
	- CartDAO.java(Shopping cart function interface)
	
- Impl->
	- CartDAOImpl.java(Implementation of shopping cart function interface)
	- UserDAOImpl.java(Implementation of user function interface)
	- ProductDAOImpl.java(Implementation of product function interface)

- db->
	- DBConnect.java(Database connection interface)

- servlet->
	- LoginServlet.java(Generate web content at login)
	- RegisterServlet.java(Generate web content when registering)
	- CartServlet(Generate web content at the time of purchase)
	- FeedbackServlet(Users write feedback to produce web content)
	- BoardServlet(Produce web content when users write product reviews)

- vo->
	- Feedback.java(Store the attributes of the feedback object)
	- User.java(Store attributes of user details)
	- Product.java(Store attributes of product detail objects)

## Run
- Install and configure Mysql
- Use Tomcat(or other server to run the website locally)
