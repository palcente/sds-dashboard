/**
 * Created by matt on 29/11/2015.
 */

var mainModule  = angular.module('mainModule', ['ngRoute']);

mainModule.config(function ($routeProvider) {
    $routeProvider
        .when('/',{
            controller: 'SimpleController',
            templateUrl: 'Dashboard.html'
        })
        .when('/View2',
            {
                controller: 'SimpleController',
                templateUrl: 'View2.html'
            })
        .otherwise({ redirectTo: '/'});
});

/*mainModule.controller('SimpleController', function($scope) {
    $scope.name = 'Mateusz';
});*/
