<%@ page language="java" pageEncoding="GB18030"%>
 
<html> 
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
            <h1>Register</h1>
            <form action="register" method="post">
                <input type="text" name="email" placeholder="Email">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <input type="text" name="address" placeholder="Your Address">
                <button type="submit">Register</button>
                <button type="reset">reset</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
        <!-- Javascript -->
        <script src="LRWeb/js/jquery-1.8.2.min.js"></script>
        <script src="LRWeb/js/supersized.3.2.7.min.js"></script>
        <script src="LRWeb/js/supersized-init.js"></script>
        <script src="LRWeb/js/scripts.js"></script>

    </body>

</html>



