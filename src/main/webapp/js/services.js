

var services = angular.module('ngdemoApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/HarBalism';

services.factory('UserFactory', function ($resource) {
    return $resource(baseUrl + '/rest/area', {}, {
    	query: { method: 'GET', params: {} }
    })
});
