var application = angular.module('application', [ 'ngRoute', 'applicationControllers' 
]);

application.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'partials/connexion.html',
		controller : 'connexion'
	}).when('/viewAlerts', {
		templateUrl : 'partials/viewAlerts.html',
		controller : 'viewAlerts'
	}).when('/createAlert', {
		templateUrl : 'partials/createAlert.html',
		controller : 'createAlert'
	}).when('/usersManagement', {
		templateUrl : 'partials/usersManagement.html',
		controller : 'usersManagement'
	}).otherwise({
		redirectTo : '/'
	});
} ]);



