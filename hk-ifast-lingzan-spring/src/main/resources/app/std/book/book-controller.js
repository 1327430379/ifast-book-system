'use strict';
var app = angular.module('std.app');
app.controller('bookController', function ($scope, $http, $rootScope) {
    // $scope.loginUser = {role: '', username: '', password: ''};
    // $rootScope.currentUserSession = {role:'guest',username:'',auth:''};
    $scope.init = function () {
        $rootScope.currentUserSession
        console.log(JSON.stringify($rootScope.currentUserSession))
    };

    $scope.showAddWindow = function () {
        document.getElementById('modal-window').style.display = 'block';
    }

    $scope.hideAddWindow = function () {
        document.getElementById('modal-window').style.display = 'none';
    }

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
            $scope.hideAddWindow();
            $scope.bookList = res.data.data;
        });
    };

    $scope.listAllCategory = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/category/list"
        }).then(function (res) {
            $scope.categoryList = res.data.data;

        });
    };

    $scope.listAllAuthor = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/author/list"
        }).then(function (res) {
            $scope.authorList = res.data.data;
            console.log($scope.authorList);
        });
    }

    $scope.listAllPublisher = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/publisher/list"
        }).then(function (res) {
            $scope.publisherList = res.data.data;

        });
    };

    $scope.save = function (book) {
        alert(JSON.stringify(book));
        var url = "";
        if (book.id != null) {
            url = "http://localhost:8080/book/update";
        } else {
            url = "http://localhost:8080/book/add";
        }
        $http({
            method: "POST",
            url: url,
            data: book
        }).then(function (res) {
            $scope.listAll();
            console.log(res);
        });

    };

    $scope.saveBook = function (book) {
        alert(JSON.stringify(book));
        var file = document.getElementById("file").files[0];
        var formData = new FormData();
        book.file = file;
        formData.append('file', file);
        formData.append('subject', book.subject);
        formData.append('description', book.description);
        formData.append('isbn', book.isbn);
        formData.append('contentType', book.type);
        formData.append('author', book.author);
        formData.append('category', book.category);
        formData.append('publisher', book.publisher);
        formData.append('price', book.price);
        var url = "";
        if (book.id != null) {
            url = "http://localhost:8080/book/update";
        } else {
            url = "http://localhost:8080/book/add";
        }

        // formData.append('book',JSON.stringify(book));
        $http({
            method: 'POST',
            url: 'http://localhost:8080/book/add',
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).then(function (res) {
            $scope.listAll();
            console.log(res);
        });


    };

    $scope.buy = function (id, paymentMode) {
        $http({
            method: "POST",
            url: "http://localhost:8080/book/buy?id=" + id + "&paymentMode=" + paymentMode
        }).then(function (res) {
            if (res.status === 200 && res.data.resultCode === '0') {
                alert('购买成功');
            } else {
                alert('购买失败：' + res.data.resultMsg);

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

    $scope.remove = function (id) {
        $http({
            method: "DELETE",
            url: "http://localhost:8080/book/delete/" + id
        }).then(function (res) {
            $scope.listAll();
        });
    };

});


