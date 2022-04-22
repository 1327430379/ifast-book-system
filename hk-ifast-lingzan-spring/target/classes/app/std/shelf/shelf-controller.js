'use strict';
var app = angular.module('std.app');
app.controller('shelfController', function ($scope, $http,$rootScope) {

    // $scope.loginUser = {role: '', username: '', password: ''};
    // $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
    $scope.listAll = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/shelf/list"
        }).then(function (res) {
            $scope.shelfList = res.data.data;
        });
    };


    $scope.read = function (id) {
        $http({
            method: "POST",
            url: "http://localhost:8080/shelf/read?id=" + id,
            responseType: "arraybuffer" //注意此参数
        }).success(function (data, status, headers, config) {
            headers = headers();
            var contentType = headers['content-type'];
            var linkElement = document.createElement('a');
            try {
                var blob = new Blob([data], {type: contentType});
                var url = window.URL.createObjectURL(blob);
                linkElement.setAttribute('href', url);
                linkElement.setAttribute("download", name);
                var clickEvent = new MouseEvent("click", {
                    "view": window,
                    "bubbles": true,
                    "cancelable": false
                });
                linkElement.dispatchEvent(clickEvent);
            } catch (ex) {
                console.log(ex);
            }
        }).error(function (data, status, headers, config) {
        });
    };

});


