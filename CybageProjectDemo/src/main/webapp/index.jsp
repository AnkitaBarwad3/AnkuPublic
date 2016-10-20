<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="static/js/controller/user_controller.js"></script>
<script src="static/js/service/user_service.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp" ng-controller="myController">
<a href="home" >home</a>

<div>
<form>
<input type="hidden" ng-model="employee.id">
<input type="text" ng-model="employee.name"><br>
<input type="text" ng-model="employee.password"><br>
<input type="text" ng-model="employee.email"><br>
<button ng-click="createEmployee()" >Create Employee</button>
</form>
</div>

<table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                           
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                       
                              <td>
                         </tr>
                      </tbody>
                  </table>
</body>
</html>