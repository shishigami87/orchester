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

    $scope.handleCreate = function () {
        $location.path('/adresse/create/')
    };
});

app.controller('AdresseCreateController', function ($scope, $route, $location, AdresseFactory) {
    $scope.title = "Adresse erstellen";

    $scope.handleSave = function () {
        var newAdresse = new AdresseFactory();
        newAdresse.plz = $scope.plz;
        newAdresse.ort = $scope.ort;
        newAdresse.strasse = $scope.strasse;
        newAdresse.hausnummer = $scope.hausnummer;
        newAdresse.$save();
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