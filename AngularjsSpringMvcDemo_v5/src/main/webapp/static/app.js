var app = angular.module("myApp", ["ngRoute"]);


app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "login.jsp",
        controller : "verificationController"
    })
    .when("/login", {
        templateUrl : "login.jsp",
        controller : "verificationController"
    })
    .when("/success", {resolve: {"check":function($location,$rootScope){
    	if(!$rootScope.loggedin)
    		{
    		  $location.url("/");
    		}
        }
    },
        templateUrl : "home.jsp",
        controller : "myController"
    })
    .when("/createRequirement", {resolve: {"check":function($location,$rootScope){
    	if(!$rootScope.loggedin)
		{
		  $location.url("/");
		}
    }
},
    templateUrl : "static/views/createRequirement.html",
    controller : "myController"
}).when("/searchRequirement", {resolve: {"check":function($location,$rootScope){
	if(!$rootScope.loggedin)
	{
	  $location.url("/");
	}
}
},
templateUrl : "static/views/searchRequirement.html",
controller : "myController"
}).when("/viewAllRequirements", {resolve: {"check":function($location,$rootScope){
	if(!$rootScope.loggedin)
	{
	  $location.url("/");
	}
	else
		{
		$rootScope.fetchAllRequirements1();
		}
}
},
templateUrl : "static/views/viewAllRequirements.html",
controller : "myController"
});
});


app.controller('verificationController',function($scope,$location,$rootScope,AuthenticationService) {
	  $scope.msg="Hello";	  

		  
	  $scope.verifyUser=function(){
		  $scope.headers = {authorization : "Basic "
		        + btoa( $scope.user.userName + ":" +  $scope.user.password)
		    };
		  alert("in function");
		  AuthenticationService.verifyUser($scope.user,$scope.headers).then(function(value) {
			  alert("sucess");
			  $rootScope.loggedin=true;
			  $rootScope.userName=$scope.user.userName;
			  $location.url("/success")
		  	
		  }, function(reason) {
			  alert("failed");
			  
			  $rootScope.loggedin=false;
			  $location.url("/login")
		  }, function(value) {
		  	
		  });
		 
	  };

});





app.controller('myController',['$scope','UserService','$rootScope',function($scope,UserService,$rootScope) {
	$scope.requirement= {
			userName:$rootScope.userName,
			requirementId:'',
			description:'',
			prerequisite:'',
			priority:'',
			shortTitle:'',
			status:'',
			title:'',
			type:'',
			version:'',
			attachments:[],
			elaborations:[],
			links:[]};
	
	//fetchAllRequirements();
	
	$rootScope.fetchAllRequirements1=function(){
	    	alert('Requirments fetched...');
	        UserService.fetchAllRequirements()
	            .then(
	            	
	            function(d) {
	            	alert(d);
	            	$rootScope.requirements = d;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	            }
	        );
	    };
   
     $scope.fetchAllRequirements=function(){
    	alert('Requirments fetched...');
        UserService.fetchAllRequirements()
            .then(
            	
            function(d) {
            	alert(d);
              $scope.requirements = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    };
    
	
	  $scope.addLink = function () {
	        $scope.requirement.links.push($scope.link);
	    };
	    $scope.addElaborations = function () {
	        $scope.requirement.elaborations.push($scope.elaboration);
	    };
	    $scope.addAttachments = function () {
	        $scope.requirement.attachments.push($scope.attachment);
	    };
	
	$scope.deleteRequirement= function()
	{
		alert("deleteRequirement controller");
		UserService.deleteRequirement($scope.requirement).then(fetchAllRequirements, function(reason) {
			console.error("failed to delete");
		})

	};

	$scope.createRequirement= function()
	{
		alert("create requirement controller ---");
		UserService.createRequirement($scope.requirement).then(fetchAllRequirements, function(reason) {
			console.error("failed to create");
		})

	};
	
	$scope.specificRequirement=function(abc)
	{
		alert("verify"+abc);
		$scope.test=abc;
		$scope.verify=true;
	}
	
	$scope.updateRequirement= function()
	{
		alert("update requirement controller ---");
		UserService.updateRequirement($scope.requirement).then(fetchAllRequirements, function(reason) {
			console.error("failed to create");
		})

	};
	

}]);
