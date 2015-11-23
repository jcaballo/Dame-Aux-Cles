var applicationControllers = angular.module('applicationControllers', []);

applicationControllers.controller('connexion', function($scope, $http) {
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

)

applicationControllers.controller('usersManagement', function($scope, $http) {

	$http.get('http://localhost:8081/users?isAdmin=0').success(
			function(data) {
				console.log(data);
				$scope.users = data;
				$scope.removeUser = function(user) {
					$http.post('http://localhost:8081/deleteUser', user).success(
							function() {
								var index = $scope.users.indexOf(user);
								$scope.users.splice(index, 1);
							});
				};
			});
}

)

applicationControllers.controller('signIn', function($scope, $http, $location) {

	$scope.signIn = function(user) {
		user.isAdmin = false;
		$http.post('http://localhost:8081/signInUser', user).success(
				function() {
					console.log(user + "signed in");
					$location.path("/");
				});
	};
}

);