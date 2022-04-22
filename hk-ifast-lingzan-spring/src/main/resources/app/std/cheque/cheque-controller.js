'use strict';
var app = angular.module('std.app');
app.controller('chequeController', function ($scope, $http,$rootScope) {

    // $scope.loginUser = {role: '', username: '', password: ''};
    // $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
    $scope.listAll = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/cheque/list"
        }).then(function (res) {
            $scope.chequeList = res.data.data;
            console.log("合同列表：" + JSON.stringify($scope.chequeList));
        });
    };



    $scope.getById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/cheque/info/" + id
        }).then(function (res) {
            $scope.chequeModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };


    $scope.updateStatus = function (id, status) {
        var updateStatusVal = status === 0 ? 1 : 0;
        console.log("id:" + id, "status:" + updateStatusVal);
        $http({
            method: "POST",
            url: "http://localhost:8080/cheque/status/update?id=" + id + "&status=" + updateStatusVal
        }).then(function (res) {
            $scope.listAll();
        });
    };

    $scope.approve = function (id) {
        $http({
            method: "POST",
            url: "http://localhost:8080/cheque/approve?id=" + id
        }).then(function (res) {
            $scope.listAll();
        });
    };

    $scope.voiding = function (id) {
        $http({
            method: "POST",
            url: "http://localhost:8080/cheque/void?id=" + id
        }).then(function (res) {
            $scope.listAll();
        });
    };

});


