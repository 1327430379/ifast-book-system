'use strict';
var app = angular.module('std.app');

app.controller('userAccountController', function ($scope, $http,$rootScope) {

    $scope.currnetSelectId = null;
    $scope.transRecordModel = {id: '', amount: '', remarks: ''};
    // $scope.loginUser = {role: '', username: '', password: ''};
    // $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
    $scope.init = function () {
        console.log($rootScope.currentUserAuth)
    };

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
        $scope.transRecordModel.id = accountId;
        $scope.currnetSelectId = accountId;
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

        url = "http://localhost:8080/trans/record/add";
        transRecord.accountId = $scope.currnetSelectId;
        $http({
            method: "POST",
            url: url,
            data: transRecord
        }).then(function (res) {
            console.log(res);
            $scope.response(res, "POSxT");
            $scope.hideAddWindow();
            $scope.queryTransRecord(transRecord.accountId);
            $scope.listAllAccount();

        });

    };

    $scope.updateTransRecord = function (transRecord) {
        var url = "http://localhost:8080/trans/record/update";
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

    $scope.removeTransRecord = function (accountId,id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/trans/record/delete?id=" + id
        }).then(function (res) {
            $scope.queryTransRecord(accountId);
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


