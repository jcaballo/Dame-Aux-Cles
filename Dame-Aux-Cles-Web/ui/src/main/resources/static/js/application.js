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
	}).when('/signIn', {
		templateUrl : 'partials/signIn.html',
		controller : 'signIn'
	}).otherwise({
		redirectTo : '/'
	});
} ]);

application.directive('file', function(){
    return {
        scope: {
            file: '='
        },
        link: function(scope, el, attrs){
            el.bind('change', function(event){
                var files = event.target.files;
                var file = files[0];
                scope.file = file ? file.name : undefined;
                scope.$apply();
            });
        }
    };
});



