

var services = angular.module('ngdemoApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/HarBalism';

services.factory('AreaFactory', function ($resource) {
    return $resource(baseUrl + '/rest/area', {}, {
    	query: { method: 'GET', params: {} }
    })
});

services.factory('AreasFactory', function ($resource) {
    return $resource(baseUrl + '/rest/areas', {}, {
    	query: { method: 'GET', params: {} }
    })
});
