<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | Today's News</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="static/css/default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<!-- start header -->
<div id="header">
	<h1><a href="#">Today's News</a></h1>
</div>
<!-- end header -->
<!-- star menu -->
<div id="menu">
	<ul>
		<li class="current_page_item"><a href="/">Home</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
</div>
<!-- end menu -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		
	<div id="login">
    	<form method="post" action="logged">
        <table>
            <tr>
                <td><h3>Email Id (Username) :</h3></td><td><input type="text" name="emailId" value="" />
                </td>
            </tr>
            <tr>
                <td><h3>Password  :</h3></td><td><input type="password" name="password" value=""  />
                </td>
            </tr>
            <tr>
            <td></td>
                <td style="padding-top: 10px;">
                    <input type="submit" name="login" value="Log In" style="font-size:14px; font-weight: bold;" />
                </td>
            </tr>
        </table>
    </form> 
</div>

	</div>
	<!-- end content -->

	<div id="extra" style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<!-- start footer -->
<div id="footer">
	<p class="legal"> &copy;2016 Today'sNews. All Rights Reserved.
		&nbsp;&nbsp;&bull;&nbsp;&nbsp; </p>
</div>
<!-- end footer -->
<div align=center><a href="#"><strong>Cybage Software Pvt. Ltd.</strong></a></div>
</body>
</html>