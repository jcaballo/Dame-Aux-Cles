function Hello($scope, $http) {
	
	$http.get('http://localhost:8081/users').success(
			function(data) {
				$scope.users = data;
			});
}