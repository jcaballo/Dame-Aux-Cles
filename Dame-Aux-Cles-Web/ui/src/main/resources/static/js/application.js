var application = angular.module('application', [ 'ngRoute', 'applicationControllers' 
]);

application.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'partials/connexion.html',
		controller : 'connexion'
	}).when('/viewAlerts', {
		templateUrl : 'partials/viewAlerts.html',
		controller : 'viewAlerts'
	}).otherwise({
		redirectTo : '/'
	});
} ]);



