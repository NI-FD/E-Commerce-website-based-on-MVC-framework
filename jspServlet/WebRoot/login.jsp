 <%@ page language="java" pageEncoding="GB18030"%>
 
<!--<html> 
	<head>
		<title>JSP for UserForm form</title>
	</head>
	<body>
		<form method="post" action="./login"> 
			username : <input type="text" name="username"/><br/>
			password : <input type="password" name="password"/><br/>
			<input type="SUBMIT" name="submit" value="Submit"> 
			<a href="register.jsp"> register </a>
		</form>
	</body>
</html>-->

<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="LRWeb/css/reset.css">
        <link rel="stylesheet" href="LRWeb/css/supersized.css">
        <link rel="stylesheet" href="LRWeb/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>
        <div class="page-container">
            <h1>Login</h1>
            <form action="login" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <button type="submit">Sign in</button>
                <div class="error"><span>+</span></div>
            </form>
            
        </div>
        <br>
        <a href="register.jsp" style="color:white;"> If you don't have account, please click here to create </a>
        <!-- Javascript -->
        <script src="LRWeb/js/jquery-1.8.2.min.js"></script>
        <script src="LRWeb/js/supersized.3.2.7.min.js"></script>
        <script src="LRWeb/js/supersized-init.js"></script>
        <script src="LRWeb/js/scripts.js"></script>

    </body>

</html>

