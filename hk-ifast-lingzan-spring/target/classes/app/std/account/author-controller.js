var app = angular.module('std.app');
app.controller('authorController', function ($scope, $http) {


    $scope.authorList = [];
    $scope.currentAuthor = {};



    $scope.showAddWindow = function () {
        document.getElementById('modal-window').style.display = 'block';
    }

    $scope.hideAddWindow = function () {
        document.getElementById('modal-window').style.display = 'none';
    }

    $scope.listAll = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/author/list"
        }).then(function (res) {
            $scope.authorList = res.data.data;
            console.log($scope.authorList);
        });
    }

    $scope.save = function (author) {
        var url = "";
        if (author.id != null) {
            url = "http://localhost:8080/author/update";
        } else {
            url = "http://localhost:8080/author/add";
        }
        $http({
            method: "POST",
            url: url,
            data: author
        }).then(function (res) {
            $scope.listAll();
            console.log(res);
        });
        console.log("作者:" + author.name);

    };

    $scope.getById = function (id) {
        $http({
            method: "GET",
            url: "http://localhost:8080/author/info/" + id
        }).then(function (res) {
            $scope.authorModel = res.data.data;
            // alert($scope.currnetAuthor);
            console.log("result数据：" + JSON.stringify(res.data.data));
        });
    };

    $scope.remove = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/author/delete/" + id
        }).then(function (res) {
            $scope.listAll();
        });
    };


});

