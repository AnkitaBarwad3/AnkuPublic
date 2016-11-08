<header>
	<h1>Welcome to CybageNet</h1>
	<h5>Requirement Management System</h5>

</header>
<nav>

	<a href="#createRequirement">Create Requirement</a>
	 <a href="#/viewAllRequirements">View All Requirements</a>
	  <a href="#/searchRequirement">Search Requirement</a>
</nav>


<a href="#/test" >test</a>


<h1>{{userName}}</h1>

<%-- <h1>{{uid}}</h1>

<div class="container" >
		<section id="content">

<form>
description<input type="text" ng-model="requirement.description"><br>
priority<input type="text" ng-model="requirement.priority"><br>
shortTitle<input type="text" ng-model="requirement.shortTitle"><br>
status<input type="text" ng-model="requirement.status"><br>
title<input type="text" ng-model="requirement.title"><br>
type<input type="text" ng-model="requirement.type"><br>
version<input type="text" ng-model="requirement.version"><br>
attachment<input type="file" ng-model="attachment"><button ng-click="addAttachments()">Add a Attachments</button><br>
prerequisite<input type="text" ng-model="requirement.prerequisite"><br>
elaboration<input type="text" ng-model="elaboration"><button ng-click="addElaborations()">Add a Elaboration</button><br>
links<input type="text" ng-model="link"><button ng-click="addLink()">Add a links</button><br>
<button ng-click="createRequirement()" >Create Requirement</button>
<button ng-click="deleteRequirement()" >Delete Requirement</button>

</form>
</div>
<a href="#/test" >test</a>
<button ng-click="fetchAllRequirements()" >show Requirement</button>

<table border="2">
	<thead>
		<tr>
			<th>Title</th>
			<th>shortTitle</th>
			<th>description</th>
			<th>priority</th>
			<th>status</th>
			<th>type</th>
			<th>version</th>
			<th>elaboration</th>
			<th>links</th>
			<th>attachment</th>
			<th>Update</th>

		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="req in requirements">
			<form ng-submit="updateRequirement()">
			<input type="hidden" ng-model="requirements.requirementId">
			<td><input type="text" name="bookId" value="${book.bookId}"
								readonly /></td>
							<td><input type="text" name="bookName"
								value="${book.bookName}" readonly /></td>
							<td><input type="text" name="author" value="${book.author}"
								readonly /></td>
							<td><input type="text" name="category"
								value="${book.category}" readonly /></td>
							<td><input type="text" name="price" value="${book.price}"
								readonly /></td>
							<td align="center"><input type="submit" value="Remove"
								name="removeBookBtn" /></td>
			<td>{{req.title}}</td>
			<td>{{req.shortTitle}}</td>
			<td>{{req.description}}</td>
			<td>{{req.priority}}</td>
			<td>{{req.status}}</td>
			<td>{{req.type}}</td>
			<td>{{req.version}}</td>
			<td>
				<table border="1" style="color: red">
					<tr ng-repeat="reqElaboration in req.elaborations">
						<td>{{reqElaboration}}</td>
					</tr>
				</table>
			</td>
			<td>
				<table border="1" style="color: red">
					<tr ng-repeat="reqLinks in req.links">
						<td>{{reqLinks}}</td>
					</tr>
				</table>
			</td>
			<td>
				<table border="1">
					<tr ng-repeat="reqAttachment in req.attachments">
						<td>{{reqAttachment}}</td>
					</tr>
				</table>
			</td>
			<td>
			<input type="submit" value="Log in" />
			</td>
			</form>
		</tr>
	</tbody>
</table>


</section>
		<!-- content -->
	</div> --%>