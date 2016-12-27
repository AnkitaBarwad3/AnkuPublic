<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News | Today's News</title>
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
		<li class="current_page_item"><a href="index">Home</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
		<li id="logout"><a href="login">Login</a></li>
	</ul>
</div>
<!-- end menu -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
			<div class="title">
				<h2><a href="#">About News Updates</a></h2>
				<!-- <p><small>Posted on August 20th, 2007 by <a href="#">Free CSS Templates</a></small></p> -->
			</div>
			<div class="entry">
				<p><strong>Today's News</strong> provides latest news from India and the world. Get today's news headlines from Business, Technology, Bollywood, Cricket, videos, photos, live news ... :)</p>
				<p></p>
			</div>
			<p class="links"> <a href="#" class="more">Read More</a> &nbsp;&nbsp;&nbsp; <a href="#" class="comments">No Comments</a> </p>
		</div>
		<div class="post">
			<div class="title">
				<h2><a href="#"> News</a></h2>
				<p><small>Recent News<a href="#">_________</a></small></p>
			</div>
			<div class="entry">
				<h2>News Flash </h2>
				<h2>${Result}</h2>
					<table style="width: 400px">
				<!-- <tr>
						<th>Headline</th>
						<th>Description</th>
						<th>Date</th>
						<th>User</th>
				</tr> -->
				<c:forEach items="${news_list}" var="news" varStatus="status">
				
							<tr><td><h4>HeadLine : <strong><c:out value="${news.headline}"></c:out></strong></h4></td></tr>
							<tr><td><strong>By : <c:out value="${news.user.name}"></c:out></strong></td><td><strong>Dated On : <c:out value="${news.date}"></c:out></strong></td></tr>
							<tr><td><h4> Description : <strong><c:out value="${news.description}"></c:out></strong></h4></td></tr>
							<tr><td><hr></td></tr>
		
				</c:forEach>
			</table>
			</div>
			<p class="links"> <a href="#" class="more">Read More</a> &nbsp;&nbsp;&nbsp; <a href="#" class="comments">No Comments</a> </p>
		</div>
	</div>
	<!-- end content -->
	<!-- start sidebar -->
	<div id="sidebar">
		<div id="search">
			<h2>Search</h2>
			<form id="searchform" method="get" action="search">
				<fieldset>
				<input type="date" name="s" id="s" size="15" value="" />
				<input type="submit" id="x" value="Search" />
				</fieldset>
			</form>
		</div>
		<ul>
			<li id="categories">
				<h2>Categories</h2>
				<ul>
					<li><a href="#">News</a> (1) </li>
					<li><a href="#">Videos</a> (4) </li>
				</ul>
			</li>
			<li id="calendar">
				<h2>Calendar</h2>
				<div id="calendar_wrap">
					<table id="wp-calendar" summary="Calendar">
						<caption>
						December 2016
						</caption>
						<thead>
							<tr>
								<th abbr="Monday" scope="col" title="Monday">M</th>
								<th abbr="Tuesday" scope="col" title="Tuesday">T</th>
								<th abbr="Wednesday" scope="col" title="Wednesday">W</th>
								<th abbr="Thursday" scope="col" title="Thursday">T</th>
								<th abbr="Friday" scope="col" title="Friday">F</th>
								<th abbr="Saturday" scope="col" title="Saturday">S</th>
								<th abbr="Sunday" scope="col" title="Sunday">S</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td abbr="July" colspan="3" id="prev"><a href="#">&laquo; Jul</a></td>
								<td class="pad">&nbsp;</td>
								<td abbr="September" colspan="3" id="next" class="pad"><a href="#">Sep &raquo;</a></td>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td colspan="2" class="pad">&nbsp;</td>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>5</td>
							</tr>
							<tr>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
								<td>10</td>
								<td>11</td>
								<td>12</td>
							</tr>
							<tr>
								<td>13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
								<td>17</td>
								<td>18</td>
								<td>19</td>
							</tr>
							<tr>
								<td>20</td>
								<td>21</td>
								<td>22</td>
								<td>23</td>
								<td>24</td>
								<td id="today">25</td>
								<td>26</td>
							</tr>
							<tr>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td>30</td>
								<td>31</td>
								<td class="pad" colspan="2">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</li>
		</ul>
	</div>
	<!-- end sidebar -->
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