'use strict';

angular.module('BootstrapApplication.controllers')
    .controller('ClientCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.clients = [];

        $scope.loadClients = function() {
            $http({
                method: 'GET',
                url: '/api/client'
            }).success(function(data) {
                $scope.clients = data;
            });

        };
    }]);