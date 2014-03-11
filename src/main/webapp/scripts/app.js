var app = angular.module('app', [
    'ngRoute',
    'ngResource',
    'mgcrea.ngStrap'
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

    $routeProvider.when('/person/', {
        templateUrl: 'partials/person/overview.html',
        controller: 'PersonOverviewController'
    });

    $routeProvider.when('/person/create/', {
        templateUrl: 'partials/person/create.html',
        controller: 'PersonCreateController'
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
        $scope.newAdresse.$save(function() {
            $location.path('/adresse/');
        });
    };

    $scope.handleBack = function () {
        $location.path('/adresse/');
    };
});

app.controller('PersonOverviewController', function ($scope, $route, $location, PersonFactory, InstrumentFactory) {
    $scope.title = "Personen";
    $scope.newInstrument = new InstrumentFactory();
    $scope.personen = PersonFactory.query();

    $scope.handleCreate = function() {
        $location.path('/person/create/')
    };

    $scope.handleSelect = function(person) {
        $scope.selectedPerson = person;
    };

    $scope.handleUpdate = function() {
        $scope.selectedPerson.$save().$promise.then(
            function(value) {
                $scope.personen = PersonFactory.query();
            }
        );
    };

    $scope.handleDelete = function(id) {
        PersonFactory.delete({ id: id }, function() {
            $scope.personen = PersonFactory.query();
        });
    };

    $scope.handleAddInstrument = function() {
        $scope.newInstrument.person = $scope.selectedPerson;
        $scope.newInstrument.$save({ personId : $scope.selectedPerson.id}, function() {
            $scope.selectedPerson = PersonFactory.get({ id : $scope.selectedPerson.id });
        });
    };

    $scope.handleRemoveInstrument = function(instrument) {
        InstrumentFactory.delete({ personId : $scope.selectedPerson.id, id : instrument.id }, function() {
            $scope.selectedPerson = PersonFactory.get({ id : $scope.selectedPerson.id });
        });
    };

});

app.controller('PersonCreateController', function ($scope, $route, $location, PersonFactory) {
    $scope.title = "Person erstellen";
    $scope.newPerson = new PersonFactory();

    $scope.handleSave = function () {
        $scope.newPerson.$save(function() {
            $location.path('/person/');
        });

    };

    $scope.handleBack = function () {
        $location.path('/person/');
    };
});

app.factory('AdresseFactory', function ($resource) {
    return $resource('/api/adresse/:id', {
        id: '@id'
    });
});

app.factory('PersonFactory', function ($resource) {
    return $resource('/api/person/:id', {
        id: '@id'
    });
});

app.factory('InstrumentFactory', function ($resource) {
    return $resource('/api/person/:personId/instrument/:id', {
        personId: '@personId',
        id: '@id'
    });
});