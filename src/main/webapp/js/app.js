var app = angular.module('ngdemoApp', ['ngRoute','ngdemoApp.services','ngdemoApp.controllers']);


app.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/view1', {templateUrl: 'view/view1.html', controller: 'MyCtrl1'})
	.when('/', {controller: 'MyCtrl1', templateUrl: 'view/view1.html'});
  $routeProvider.otherwise({redirectTo: '/view1'});

  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

