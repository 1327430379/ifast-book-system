'use strict';
var app = angular.module('std.app');
app.controller('userController', function ($scope, $http) {
    $scope.loginUser = {role: 'guest', username: '', password: ''};
    $scope.currentUserSession = {};

    $scope.showRegisterUserWindow = function () {
        document.getElementById('modal-register').style.display = 'block';
    }

    $scope.hideRegisterUserWindow = function () {
        document.getElementById('modal-register').style.display = 'none';
    }

    $scope.showLoginWindow = function (role) {
        $scope.loginUser.role = role;
        document.getElementById('modal-login').style.display = 'block';
    }

    $scope.hideLoginWindow = function () {
        document.getElementById('modal-login').style.display = 'none';
    }

    $scope.logout = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/user/list"
        }).then(function (res) {
            $scope.userList = res.data.data.data;
            console.log("用户列表：" + JSON.stringify($scope.userList));
        });
    };

    $scope.listAll = function () {
        $scope.hideLoginWindow();
        $scope.hideRegisterUserWindow();
        $http({
            method: "GET",
            url: "http://localhost:8080/user/list"
        }).then(function (res) {
            $scope.userList = res.data.data.data;
            console.log("用户列表：" + JSON.stringify($scope.userList));
        });
    };

    $scope.save = function (user) {
        console.log("请求参数：" + JSON.stringify(user));
        var url = "";
        var tips = "";
        if (user.id != null) {
            url = "http://localhost:8080/user/update";
        } else {
            url = "http://localhost:8080/user/add";
        }
        $http({
            method: "POST",
            url: url,
            data: user
        }).then(function (res) {
            $scope.listAll();
            console.log(res);
        });

    };

    $scope.register = function (user) {
        if (user.password !== user.confirmPassword) {
            alert('两次输入的密码不一致');
            return;
        }
        user.role = 'customer';
        console.log("请求参数：" + JSON.stringify(user));
        $http({
            method: "POST",
            url: 'http://localhost:8080/user/register',
            data: user
        }).then(function (res) {
            console.log(res);
            if (res.data.resultCode === '0') {
                alert('注册成功');
            } else {
                alert('注册失败,原因：' + res.data.resultMsg);
            }
            $scope.listAll();
        });

    };

    $scope.getById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/user/info/" + id
        }).then(function (res) {
            $scope.response(res,'DELETE');
            $scope.userModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.remove = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/user/delete/" + id
        }).then(function (res) {
            $scope.response(res,'DELETE');
            $scope.listAll();
        });
    };

    $scope.updateStatus = function (id, status) {
        var updateStatusVal = status === 0 ? 1 : 0;
        console.log("id:" + id, "status:" + updateStatusVal);
        $http({
            method: "POST",
            url: "http://localhost:8080/user/status/update?id=" + id + "&status=" + updateStatusVal
        }).then(function (res) {
            $scope.response(res,'POST');
            $scope.listAll();
        });
    };

    $scope.approve = function (id) {
        $http({
            method: "POST",
            url: "http://localhost:8080/user/approve?id=" + id
        }).then(function (res) {
            $scope.response(res,'POST');
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


