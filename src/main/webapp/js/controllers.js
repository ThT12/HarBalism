var app = angular.module('ngdemoApp.controllers', []);


app.controller('CtrlArea', ['$scope','AreaFactory', function ($scope, AreaFactory) {
	AreaFactory.query({}, function (area) {
	    $scope.areasize = area.size;
	  })
}]);

app.controller('CtrlAreas', ['$scope','AreasFactory', function ($scope, AreasFactory) {
	AreasFactory.query({}, function (areas) {
	    $scope.areas = areas;
	  })
}]);
