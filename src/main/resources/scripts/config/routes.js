/**
 * Created by matt on 29/11/2015.
 */

mainModule.config(function($routeProvider){
    $routeProvider.when('/',
        {
            controller: 'dashboardController',
            templateUrl: 'partials/Dashboard.html'
        })
        .when(
            '/browse',
            {
                controller:'BrowseController',
                template : 'partials/Browse.html'
            }
        )
        .otherwise({redirectTo: '/'})
});
