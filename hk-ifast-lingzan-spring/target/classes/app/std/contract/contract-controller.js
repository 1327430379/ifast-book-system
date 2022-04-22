'use strict';
var app = angular.module('std.app');
app.controller('contractController', function ($scope, $http,$rootScope) {
    // $scope.loginUser = {role: '', username: '', password: ''};
    // $rootScope.currentUserSession = {role:'guest',username:'',auth:''};

    $scope.showAddWindow = function () {
        document.getElementById('modal-window').style.display = 'block';
    }

    $scope.hideAddWindow = function () {
        document.getElementById('modal-window').style.display = 'none';
    }
    $scope.listAll = function () {
        //$scope.hideAddWindow();
        $http({
            method: "GET",
            url: "http://localhost:8080/contract/list"
        }).then(function (res) {
            $scope.contractList = res.data.data;
        });
    };

    $scope.save = function (contract) {
        console.log("请求参数：" + JSON.stringify(contract));
        var url = "";
        if (contract.id != null) {
            url = "http://localhost:8080/contract/update";
        } else {
            url = "http://localhost:8080/contract/add";
        }
        $http({
            method: "POST",
            url: url,
            data: contract
        }).then(function (res) {

            $scope.listAll();
            console.log(res);
        });

    };

    $scope.getById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/contract/info/" + id
        }).then(function (res) {
            $scope.contractModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.remove = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/contract/delete/" + id
        }).then(function (res) {
            $scope.response(res,"DELETE");
            $scope.listAll();
        });
    };

    $scope.response = function (res, method) {
        if (res.status !== 200) {
            alert('提交到服务器失败')
            return;
        }

        if (res.data.resultCode !== '0') {
            alert('服务端出错');
            return;
        }
        if ('POST' === method) {
            alert('提交到服务器成功');
        }
    }

});


