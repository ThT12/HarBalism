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

app.controller('CtrlHikings', ['$scope','HikingsFactory', function ($scope, HikingsFactory) {
	HikingsFactory.query({}, function (hikings) {
		$scope.hikings = hikings;
	})

	$scope.detail = false;
	$scope.$watch('detail', function(){
		$scope.detailText = $scope.detail ? 'Hide Details' : 'Show Details';
	})
}]);


