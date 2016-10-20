'use strict'

var app = angular.module('myApp', []);


app.controller('myController',['$scope','UserService',function($scope,UserService) {
	$scope.employee= {id:null,name:'',password:'',email:''};
	$scope.users=[];
	
	fetchAllEmployee();
	  
	    function fetchAllEmployee(){
	    	alert('controller');
	        UserService.fetchAllEmployee()
	            .then(
	            	
	            function(d) {
	              $scope.users = d;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	            }
	        );
	    }
	    
	  $scope.createEmployee= function()
	    {
	    	UserService.createEmployee($scope.employee).then(fetchAllEmployee,function(errorMsg){
	    		console.error('Failed to create');
	    	});
	    }
	
}])
