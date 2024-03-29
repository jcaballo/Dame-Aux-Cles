var applicationControllers = angular.module('applicationControllers', []);

applicationControllers.controller('connexion', function($scope, $http,
		$location, $rootScope) {
	$scope.connexion = function(user) {
		$http.get('http://localhost:8081/user?loginPersonne=' + user.login)
				.success(function(data) {
					if (data.mdpPersonne == user.mdp) {
						$rootScope.currentUser = data;
						console.log($rootScope.currentUser);
						$location.path("/viewAlerts");
					} else {
						alert("Mot de passe incorrect");
					}
				});
	}
	$scope.inscription = function() {
		$location.path("/signIn");
	}
});

applicationControllers.controller('viewAlerts', function($scope, $http,
		$location, $rootScope) {
	$http.get('http://localhost:8081/alerts/user?loginPersonne='
					+ $rootScope.currentUser.loginPersonne).success(
			function(data) {
				$scope.alerts = data;
			});
	$scope.updateAlert = function(alert) {
		console.log("Coucou " + alert.idalerte)
		$http.get('http://localhost:8081/updateAlerte?idAlerte='
								+ alert.idalerte).success(function(data) {
					alert = data;
				});
	};
}

)

applicationControllers.controller('createAlert', function($scope, $http,
		$rootScope) {
	$scope.createAlert = function(alert) {
		alert.idpersonne = $rootScope.currentUser;
		alert.delaisalerte = new Date(alert.delaisalerte).getTime();
		console.log(alert);
		$http.post('http://localhost:8081/alert', alert).success(
				function(data) {
					console.log(data);
				});
	};
}

)

applicationControllers.controller('usersManagement', function($scope, $http,
		$rootScope) {
	if ($rootScope.currentUser.isAdmin == true) {
		$http.get('http://localhost:8081/users?isAdmin=0').success(
				function(data) {
					console.log(data);
					$scope.users = data;
					$scope.removeUser = function(user) {
						$http.post('http://localhost:8081/deleteUser', user)
								.success(function() {
									var index = $scope.users.indexOf(user);
									$scope.users.splice(index, 1);
								});
					};
				});
	}
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