/**
 * Created by matt on 29/11/2015.
 */
var mainModule  = angular.module('mainModule', ['ngRoute']);
var stompClient = null;

mainModule.controller('dashboardController',function($scope,stepService) {
    $scope.orderByField = 'jobExecutionId';
    $scope.reverseSort = true;
    $scope.filterField = 'jobName';
    $scope.gettingSteps = function(id){
        stepService.gettingSteps(id).then(function(response) {
            $scope.step = response.data;
        }, function(error) {
            alert(error.message);
        });
    }



    var socket = new SockJS('/dashboard');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/dashboardEntries', callback);
            console.log('Subscribed: ' + frame)
        });

    $scope.$on("$destroy", function() {
            stompClient.disconnect(function(){
                console.log('Unsubscribed!')
            });
        });

     var callback  = function(message){
        console.log('Called Websocket onReceive callback')
        $scope.resp = JSON.parse(message.body);
        $scope.$digest();
    }

    $scope.getRowColour = function (status) {
        if (status == ("COMPLETED"))
            return null;
        else if (status == ("FAILED"))
            return "danger";
        else if (status == ("UNKNOWN"))
            return "warning";
    }
});

mainModule.filter("dateFilter", function() {
    return function(x){
        if(x.length == 5){
            x.push(0);
        }
        date = new Date(x[0],x[1]-1,x[2],x[3],x[4],x[5]);
        return date;
    };
});
/*
function sendDate() {
    stompClient.send("/app/dashboard", {}, JSON.stringify({'date': 'HELLO'}));
}*/
