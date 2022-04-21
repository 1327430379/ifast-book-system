'use strict';
var app = angular.module('std.app');
app.controller('categoryController', function ($scope, $http) {


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
                url: "http://localhost:8080/category/list"
            }).then(function (res) {
                $scope.categoryList = res.data.data;

            });
        };

        $scope.save = function (category) {
            var url = "";
            if (category.id != null) {
                url = "http://localhost:8080/category/update";
            } else {
                url = "http://localhost:8080/category/add";
            }
            $http({
                method: "POST",
                url: url,
                data: category
            }).then(function (res) {
                console.log(res);
                $scope.response(res,"POST");
                $scope.listAll();
            });

        };

        $scope.getById = function (id) {
            $http({
                method: "GET",
                url: "http://localhost:8080/category/info/" + id
            }).then(function (res) {
                $scope.categoryModel = res.data.data;
                console.log("result数据：" + JSON.stringify(res.data.data));
            });
        };

        $scope.remove = function (id) {
            $http({
                method: "DELETE",
                url: "http://localhost:8080/category/delete/" + id
            }).then(function (res) {
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


