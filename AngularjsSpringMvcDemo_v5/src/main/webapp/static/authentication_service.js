
angular.module('myApp').service('AuthenticationService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/RequirementManagement/user/' ;
	
	
	
	this.verifyUser = function (requirement,headers)
	{
		alert("authentication service");
		var deferred = $q.defer();
		$http.defaults.headers.common = headers;
		
		$http({
			   method : 'POST',
			   url    : REST_SERVICE_URI,
			   headers: headers,
			   data   : requirement}).
			   then(function(response){ 
				   
				           deferred.resolve(response.data);
				           
				        },
			        function(reason){ 
				        	console.error("Error while creating user");
							deferred.reject(reason);				
						}
					);
		
		return deferred.promise;
	}	
	

/*	this.verifyUser = function (requirement,headers)
	{
		alert("authentication service");
		var deferred = $q.defer();
		$http.defaults.headers.common = headers;
		$http.post(REST_SERVICE_URI,requirement)
		.then(
				function(response) {
					deferred.resolve(response.data);					
				},
				function(reason) {
					console.error("Error while creating user");
					deferred.reject(reason);
		
				});
		
		return deferred.promise;
	}	*/
	
}]);