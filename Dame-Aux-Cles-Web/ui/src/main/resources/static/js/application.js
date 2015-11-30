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
	}).when('/viewAlerts', {
		templateUrl : 'partials/viewAlerts.html',
		controller : 'Raffraichir'
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

(function(){

    'use strict';

    function ngRedirectTo($window) {
        return {
            restrict: 'A',
            link: function(scope, element, attributes) {
                element.bind('click', function (event) {
                    //assign ng-Redirect-To attribute value to location
                    $window.location.href = attributes.ngRedirectTo;
                });
            }
        };
    }
    application.directive('ngRedirectTo', ngRedirectTo);
    //inject $window service for redirection
    redirectTo.$inject = ['$window'];
}());




