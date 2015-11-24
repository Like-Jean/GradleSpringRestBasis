//'use strict';

var rentControllers = angular.module('rentControllers', []);

rentControllers.controller("rentController", function($scope,$http,$routeParams) {

	$http.get('http://localhost:8080/GradleSpringRestBasis/myRent/car/').
	  success(function(data, status, headers, config) {
	  	$scope.carsList = data;
	  	$scope.selected = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });

	$scope.rent = function(selected) {
		$http.delete("http://localhost:8080/GradleSpringRestBasis/myRent/car/"+selected.plateNumber).
		success(function(data, status, headers, config) {
			alert("Rent successfully: "+selected.plateNumber);
		}).
			error(function(data, status, headers, config) {
				alert("Failed");
			});

	};
        
});

var getBackControllers = angular.module('getBackControllers', []);

getBackControllers.controller("getBackController", function($scope,$http,$routeParams) {
	$scope.GetBack = function(plateNumber) {
		$http.put("http://localhost:8080/GradleSpringRestBasis/myRent/car/" + plateNumber).
			success(function (data, status, headers, config) {
				alert("Return successfully: " + plateNumber);
			}).
			error(function (data, status, headers, config) {
				alert("Failed");
			});
	}
});
