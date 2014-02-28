var app = angular.module('app', [
    'ngRoute',
    'ngResource'
]);

app.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'partials/home.html',
        controller: 'HomeController'
    });

    $routeProvider.otherwise({
        redirectTo: '/'
    });
});

app.controller('HomeController', function($scope, $route, AdresseFactory) {
    $scope.title = "Home";
    $scope.adressen = AdresseFactory.query();
});

app.factory('AdresseFactory', function($resource) {
    return $resource('/api/adresse/:id', {
        id : '@id'
    });
});