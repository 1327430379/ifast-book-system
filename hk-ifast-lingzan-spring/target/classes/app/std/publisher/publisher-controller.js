'use strict';
var app = angular.module('std.app');
app.controller('publisherController', function ($scope, $http) {


    $scope.showAddWindow = function () {
        document.getElementById('modal-window').style.display = 'block';
    }

    $scope.hideAddWindow = function () {
        document.getElementById('modal-window').style.display = 'none';
    }
    $scope.listAll = function () {
        $scope.hideAddWindow();
        $http({
            method: "GET",
            url: "http://localhost:8080/publisher/list"
        }).then(function (res) {
            $scope.publisherList = res.data.data;
        });
    };

    $scope.save = function (publisher) {
        console.log("请求参数：" + JSON.stringify(publisher));
        var url = "";
        if (publisher.id != null) {
            url = "http://localhost:8080/publisher/update";
        } else {
            url = "http://localhost:8080/publisher/add";
        }
        $http({
            method: "POST",
            url: url,
            data: publisher
        }).then(function (res) {

            $scope.listAll();
            console.log(res);
        });

    };

    $scope.getById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/publisher/info/" + id
        }).then(function (res) {
            $scope.publisherModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.remove = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/publisher/delete/" + id
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


