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
		<li><a href="#">Home</a></li>
		<li class="current_page_item"><a href="logged">News</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
		<li id="logout"><a href="logout">Log Out</a></li>
	</ul>
</div>
<!-- end menu -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		
	<div id="login">
    	<form method="post" action="save">
        <table>
            <tr>
                <td><h3>Date :</h3></td><td><input type="date" name="date" value="${news.date}" disabled="disabled"/>
                </td>
            </tr>
            <tr>
                <td><h3>Headline  :</h3></td><td><input type="text" name="headline" value="${news.headline}"  />
                </td>
            </tr>
            <tr>
            	<td><h3>Description  :</h3></td><td><input type="text" name="description" value="${news.description}"  /></td>
            </tr>
            <tr>
            	<td><input type="hidden" name="idnews" value="${news.idnews}"></td>
            </tr>
            <tr>
            <td></td>
                <td style="padding-top: 10px;">
                    <input type="submit" name="save" value="Save" style="font-size:14px; font-weight: bold;" />
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