'use strict';
var app = angular.module('std.app');
app.controller('bookUserController', function ($scope, $http,$rootScope) {
    // $scope.loginUser = {role: '', username: '', password: ''};
    // $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
    $scope.init = function () {
        console.log(JSON.stringify($rootScope.currentUserSession))
    };

    $scope.showBuyWindow = function () {
        document.getElementById('modal-buy-window').style.display = 'block';
    }

    $scope.hideBuyWindow = function () {
        document.getElementById('modal-buy-window').style.display = 'none';
    }

    $scope.listAll = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/book/list"
        }).then(function (res) {
            $scope.hideBuyWindow();
            $scope.bookList = res.data.data;
        });
    };


    $scope.buy = function (id,paymentMode) {
        $http({
            method: "POST",
            url: "http://localhost:8080/book/buy?id=" + id + "&paymentMode=" + paymentMode
        }).then(function (res) {
            if (res.status === 200 && res.data.resultCode === '0') {
                alert('购买成功');
            }else {
                alert('购买失败：'+res.data.resultMsg);

            }
            // $scope.bookModel = res.data.data;
            // console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.getById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/book/info/" + id
        }).then(function (res) {
            $scope.bookModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };


});


