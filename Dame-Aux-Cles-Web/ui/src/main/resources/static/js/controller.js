var applicationControllers = angular.module('applicationControllers', []);

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

);