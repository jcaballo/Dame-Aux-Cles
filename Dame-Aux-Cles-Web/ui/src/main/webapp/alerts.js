function Hello($scope, $http) {
	
	$http.get('http://localhost:8081/users').success(
			function(data) {
				$scope.users = data;
			});
}

function Alerts($scope, $http) {
	
	$http.get('http://localhost:8081/alerts').success(
			function(data) {
				$scope.alerts = data;
			});
}