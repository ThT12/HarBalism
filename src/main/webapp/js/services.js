

var services = angular.module('ngdemoApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/HarBalism';

services.factory('AreasFactory', function ($resource) {
    return $resource(baseUrl + '/rest/areas', {}, {
    	query: { method: 'GET', params: {} }
    })
});

services.factory('HikingsFactory', function ($resource) {
    return $resource(baseUrl + '/rest/hikings', {}, {
    	query: { method: 'GET', params: {} }
    })
});

services.factory('AdvicesFactory', function ($resource) {
    return $resource(baseUrl + '/rest/advices', {}, {
    	query: { method: 'GET', params: {} }
    })
});
