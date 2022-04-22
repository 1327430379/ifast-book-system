'use strict';
var app = angular.module('std.app');

app.controller('headerController', function ($scope, $rootScope, $http) {
    $scope.loginUser = {role: '', username: '', password: ''};
    $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
    $scope.init = function () {
        console.log($rootScope.currentUserAuth)
    };

    $scope.initCurrentUser = function () {
        // $rootScope.currentUserSession = sessionStorage.getItem('currentLoginUser');
        // console.log("登录用户信息：" + JSON.stringify($rootScope.currentUserSession));
        // $scope.currentUserSession.auth = $scope.currentUserSession.id + "_" + $scope.currentUserSession.username;
    }

    $scope.showRegisterUserWindow = function () {
        document.getElementById('modal-register').style.display = 'block';
    }

    $scope.hideRegisterUserWindow = function () {
        document.getElementById('modal-register').style.display = 'none';
    }
    $scope.showEditUserWindow = function () {
        document.getElementById('editUserModal').style.display = 'block';
    }

    $scope.hideEditUserWindow = function () {
        document.getElementById('editUserModal').style.display = 'none';
    }

    $scope.showLoginWindow = function (role) {
        $rootScope.currentRole = role;

        document.getElementById('modal-login').style.display = 'block';
    }

    $scope.hideLoginWindow = function () {
        document.getElementById('modal-login').style.display = 'none';
    }

    $scope.login = function (user) {
        user.role = $rootScope.currentRole;
        $http({
            method: "POST",
            url: "http://localhost:8080/user/login",
            data: user
        }).then(function (res) {
            if (res.status === 200 && res.data.resultCode === '0' && res.data.data !== null) {
                alert('登录成功');
                var user = res.data.data;
                var token = user.id + "_" + user.username;
                user.token = token;
                console.log("token:" + token);
                //  $httpProvider.defaults.headers.common = {'auth': token};
                $rootScope.currentUserAuth = token;
                $scope.copyUserSession(user);
                console.log("登录的用户session:"+JSON.stringify($rootScope.currentUserSession))
                sessionStorage.setItem('currentLoginUser', $rootScope.currentUserSession);
                $scope.initCurrentUser();
                $scope.hideLoginWindow();
            } else {
                alert('登录失败：' + res.data.resultMsg);
            }
        });
    };
    $scope.copyUserSession = function (user) {
        $rootScope.currentUserSession['role'] = user.role;
        $rootScope.currentUserSession['username'] = user.username;
        $rootScope.currentUserSession['auth'] = user.auth;
    };


    $scope.logout = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/user/list"
        }).then(function (res) {
            $scope.userList = res.data.data.data;
            $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
            $rootScope.currentUserAuth = undefined;
            console.log("用户列表：" + JSON.stringify($scope.userList));
        });
    };

    $scope.listAll = function () {
        $scope.hideLoginWindow();
        $scope.hideRegisterUserWindow();
        $http({
            method: "GET",
            url: "http://localhost:8080/user/list",
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
                $scope.register();
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
            $scope.response(res, 'DELETE');
            $scope.userModel = res.data.data;
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.remove = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/user/delete/" + id
        }).then(function (res) {
            $scope.response(res, 'DELETE');
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
            $scope.response(res, 'POST');
            $scope.listAll();
        });
    };

    $scope.approve = function (id) {
        $http({
            method: "POST",
            url: "http://localhost:8080/user/approve?id=" + id
        }).then(function (res) {
            $scope.response(res, 'POST');
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


