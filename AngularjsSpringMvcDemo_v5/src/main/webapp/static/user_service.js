

angular.module('myApp').service('UserService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/RequirementManagement/requirements/' ;
	var REST_SERVICE_URI1 = 'http://localhost:8080/RequirementManagement/deleteRequirements/' ;
	var REST_SERVICE_URI2 = 'http://localhost:8080/RequirementManagement/viewAllRequirements/' ;
	var REST_SERVICE_URI3 = 'http://localhost:8080/RequirementManagement/updateRequirement/' ;





	this.fetchAllRequirements= function () {
		alert(REST_SERVICE_URI2);
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI2)
		.then(
				function (response) {
					alert(response.data);
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}



	this.createRequirement = function (requirement)
	{
		alert("requirement service");
		var deferred = $q.defer();
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
	}
	

	this.updateRequirement = function (requirement)
	{
		alert("updateRequirement service");
		var deferred = $q.defer();
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
	}
	
	
	this.deleteRequirement = function (requirement)
	{
		alert("requirement service deleteRequirement method...");
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI1,requirement)
		.then(
				function(response) {
					deferred.resolve(response.data);
					
				},
				function(reason) {
					console.error("Error while deleting user");
					deferred.reject(reason);
		
				});
		
		return deferred.promise;
	}

}]);