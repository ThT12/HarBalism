var app = angular.module('ngdemoApp', ['ngRoute','ngdemoApp.services','ngdemoApp.controllers']);


app.config(function ($routeProvider, $httpProvider) {
  $routeProvider
    .when('/areas', {templateUrl: 'view/areas.html', controller: 'CtrlAreas'})
    .when('/view1', {templateUrl: 'view/view1.html', controller: 'CtrlArea'})
	.when('/', {controller: 'CtrlArea', templateUrl: 'view/view1.html'});
  $routeProvider.otherwise({redirectTo: '/view1'});

  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

app.filter("unique",function(){return function(e,t){if(t===!1)return e;if((t||angular.isUndefined(t))&&angular.isArray(e)){var n={},r=[],i=function(e){return angular.isObject(e)&&angular.isString(t)?e[t]:e};angular.forEach(e,function(e){var t,n=!1;for(var s=0;s<r.length;s++)if(angular.equals(i(r[s]),i(e))){n=!0;break}n||r.push(e)}),e=r}return e}});