'use strict';
var app = angular.module('std.app');
app.controller('accountController', function ($scope, $http) {


    $scope.showAddWindow = function () {
        document.getElementById('modal-window').style.display = 'block';
    }

    $scope.hideAddWindow = function () {
        document.getElementById('modal-window').style.display = 'none';
    }
    $scope.listAllAccount = function () {
        $scope.hideAddWindow();
        $http({
            method: "GET",
            url: "http://localhost:8080/account/list"
        }).then(function (res) {
            $scope.accountList = res.data.data;
        });
    };


    $scope.queryTransRecord = function (accountId) {
        alert('查询流水记录：accountId:' + accountId);
        $scope.hideAddWindow();
        $http({
            method: "GET",
            url: "http://localhost:8080/trans/record/list?accountId=" + accountId
        }).then(function (res) {
            $scope.transRecordList = res.data.data;

        });
    };

    $scope.saveTransRecord = function (transRecord) {
        var url = "";
        if (category.id != null) {
            url = "http://localhost:8080/trans/record/update";
        } else {
            url = "http://localhost:8080/trans/record/add";
        }
        $http({
            method: "POST",
            url: url,
            data: transRecord
        }).then(function (res) {
            console.log(res);
            $scope.response(res, "POST");
            $scope.listAll();
        });

    };

    $scope.getTransRecordById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/trans/record/info/" + id
        }).then(function (res) {
            $scope.transRecordModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.removeTransRecord = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/trans/record?id=" + id
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


