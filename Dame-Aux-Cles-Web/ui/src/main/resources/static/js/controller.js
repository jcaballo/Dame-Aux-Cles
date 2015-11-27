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

)

applicationControllers.controller('createAlert', function($scope, $http) {

	$http.get('http://localhost:8081/alerts').success(function(data) {
		console.log(data);
		$scope.alerts = data;
	});
}

applicationControllers.controller('Raffraichir', function($scope, $http) {

	$http.get('http://localhost:8081/alerts').success(function(data) {
		console.log(data);
		$scope.feeds = [{
			  url: 'http://localhost:8081/alerts',
			  items: [ alert ]
			}];
	});
}

);