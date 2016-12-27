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
		<li><a href="user">Home</a></li>
		<li class="current_page_item"><a href="logged">News</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
		<li><a href="add">Add News</a></li>
		<li id="logout"><a href="logout">Log Out</a></li>
	</ul>
</div>
<!-- end menu -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		
	<h2>User : ${loggedUser.name}</h2>
			<table style="width: 400px">
				<tr>
						<th>Headline</th>
						<th>Description</th>
						<th>Date</th>
						<th>User</th>
						<th>Update</th>
						<th>Delete</th>
						
				</tr> 
				<c:forEach items="${news_list}" var="news" varStatus="status">
				
					<tr>
							<td><strong><c:out value="${news.headline}"></c:out></strong></td>
							<td><strong><c:out value="${news.description}"></c:out></strong></td>
							<td><strong><c:out value="${news.date}"></c:out></strong></td>
							<td><strong><c:out value="${news.user.name}"></c:out></strong></td>
							<td><a href="update?id=${news.idnews }"><input type="submit" value="Update"></a> </td>
							<td><a href="delete?id=${news.idnews }"><input type="submit" value="Delete"></a></td>
							
						</tr>
				</c:forEach>
			</table>

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