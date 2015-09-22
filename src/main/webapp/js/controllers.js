var app = angular.module('ngdemoApp.controllers', []);


app.controller('CtrlAreas', ['$scope','AreasFactory', function ($scope, AreasFactory) {
	AreasFactory.query({}, function (areas) {
		$scope.areas = areas;
	})
}]);

app.controller('CtrlHikings', ['$scope','HikingsFactory', function ($scope, HikingsFactory) {
	HikingsFactory.query({}, function (hikings) {
		$scope.hikings = hikings;
	})

	$scope.title = "List of all your Hikings";
	$scope.switchDetail = function (area) {
		area.isDetail =! area.isDetail;
		area.detailText = area.isDetail ? 'Hide Details' : 'Show Details';
	};
}]);


app.controller('CtrlAdvices', ['$scope','AdvicesFactory', function ($scope, AdvicesFactory) {
	AdvicesFactory.query({}, function (advices) {
		$scope.hikings = advices;
	})
	
	$scope.title = "Here some hikings advices";
	$scope.switchDetail = function (area) {
		area.isDetail =! area.isDetail;
		area.detailText = area.isDetail ? 'Hide Details' : 'Show Details';
	};

}]);


