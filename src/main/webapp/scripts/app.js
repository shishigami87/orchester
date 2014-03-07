var app = angular.module('app', [
    'ngRoute',
    'ngResource'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'partials/home.html',
        controller: 'HomeController'
    });

    $routeProvider.when('/adresse/', {
        templateUrl: 'partials/adresse/overview.html',
        controller: 'AdresseOverviewController'
    });

    $routeProvider.when('/adresse/create/', {
        templateUrl: 'partials/adresse/create.html',
        controller: 'AdresseCreateController'
    });

    $routeProvider.otherwise({
        redirectTo: '/'
    });
});

app.controller('HomeController', function ($scope, $route) {
    $scope.title = "Home";
});

app.controller('AdresseOverviewController', function ($scope, $route, $location, AdresseFactory) {
    $scope.title = "Adressen";
    $scope.adressen = AdresseFactory.query();

    $scope.handleCreate = function() {
        $location.path('/adresse/create/')
    };

    $scope.handleSelect = function(adresse) {
        $scope.selectedAdresse = adresse;
    };

    $scope.handleUpdate = function() {
        $scope.selectedAdresse.$save().$promise.then(
            function(value) {
                $scope.adressen = AdresseFactory.query();
            }
        );
    };

    $scope.handleDelete = function(id) {
        AdresseFactory.delete({ id: id }).$promise.then(
            function(value) {
                $scope.adressen = AdresseFactory.query();
            }
        );
    };
});

app.controller('AdresseCreateController', function ($scope, $route, $location, AdresseFactory) {
    $scope.title = "Adresse erstellen";
    $scope.newAdresse = new AdresseFactory();

    $scope.handleSave = function () {
        $scope.newAdresse.$save();
        $location.path('/adresse/');
    };

    $scope.handleBack = function () {
        $location.path('/adresse/');
    };
});


app.factory('AdresseFactory', function ($resource) {
    return $resource('/api/adresse/:id', {
        id: '@id'
    });
});