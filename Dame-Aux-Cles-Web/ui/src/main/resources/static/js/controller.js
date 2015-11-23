var applicationControllers = angular.module('applicationControllers', []);

applicationControllers.controller(
		'connexion',
		function($scope, $http) {
			$http.get('http://localhost:8081/user?loginPersonne=').success(
					function(data) {
						$scope.users = data;
					});
		});


applicationControllers.controller('viewAlerts', function($scope, $http) {

	$http.get('http://localhost:8081/alerts').success(function(data) {
		console.log(data);
		$scope.alerts = data;
	});
}

);