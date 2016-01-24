/**
 * Created by Mateusz on 24/01/2016.
 */
mainModule.factory('stepService', function($http) {
    return {
        gettingSteps: function(id) {
            return $http.get('batchStepExecutionPerJobExecutionId/' + id);
        }
    }
});