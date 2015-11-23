var applicationControllers = angular.module('applicationControllers', []);

<<<<<<< HEAD
applicationControllers.controller('connexion', function($scope, $http, $location, $rootScope) {
	$scope.connexion = function(user) {;
		$http.get('http://localhost:8081/user?loginPersonne='+user.login).success(function(data) {
			if(data.mdpPersonne == user.mdp) {
				$rootScope.currentUser = data;
				console.log($rootScope.currentUser);
				$location.path("/viewAlerts");
			} else {
				alert("Mot de passe incorrect");
			}
		});
	};
=======
applicationControllers.controller('connexion', function($scope, $http) {
	$http.get('http://localhost:8081/user?loginPersonne=').success(
			function(data) {
				$scope.users = data;
			});
>>>>>>> 080fd4e96bcadb7a55d7f2981e817354e90768b6
});

applicationControllers.controller('viewAlerts', function($scope, $http) {
	$http.get('http://localhost:8081/alerts').success(function(data) {
		$scope.alerts = data;
	});
}

)

applicationControllers.controller('createAlert', function($scope, $http, $rootScope) {
	$scope.createAlert = function(alert) {
		console.log(alert);
		alert.idpersonne = $rootScope.currentUser.idPersonne;
		$http.post('http://localhost:8081/alert', alert).success(function(data) {
			console.log(data);
		});
	};
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