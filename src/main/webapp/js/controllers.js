var app = angular.module('ngdemoApp.controllers', []);


app.controller('MyCtrl1', ['$scope','UserFactory', function ($scope, UserFactory) {
	 $scope.bla = 'bla from controller';
	 UserFactory.query({}, function (data) {
	    $scope.message = data.name;
	  })
}]);
