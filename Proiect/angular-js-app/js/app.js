var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/cosmetice';

    $scope.cosmetice = [];
    $scope.fields = [];
    $scope.cosmetica = {};


    $scope.cosmetic = {};
    $scope.editCosmetic = {};



    $http.get(url).then(function successCallback(response) {

        $scope.cosmetice = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.cosmetice);
        //console.log($scope.fields);

    });
    

    $scope.addCosmetica = function(cosmetica) {
        cosmetica.id = parseInt(cosmetica.id);
        console.log(cosmetica.id);
        $http({
            method: 'POST',
            url: url,
            data: cosmetica
        }).then(function successCallback(response) {
            console.log(response);
            $scope.cosmetice.push(cosmetica);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteCosmetica = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.cosmetice = $scope.cosmetice.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateCosmetic = function(cosmetic) {
        $scope.editCosmetic = cosmetic;
    };


    $scope.updateCosmetic = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editCosmetic
        }).then(function successCallback(response) {
            $scope.editCosmetic = {};
            console.log(response);
            // $scope.cosmetice.push($scope.editcosmetic);
            // done.
        }, function errorCallback(response) {
            $scope.editCosmetic = {};
            console.log(response);
        });
    };

}]);





app.controller('HomController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/produs';

    $scope.produse = [];
    $scope.fields = [];
    $scope.produs = {};


    $scope.product = {};
    $scope.editProduct = {};



    $http.get(url).then(function successCallback(response) {

        $scope.produse = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.produse);
        //console.log($scope.fields);

    });
    

    $scope.addProdus = function(produs) {
        produs.id = parseInt(produs.id);
        console.log(produs.id);
        $http({
            method: 'POST',
            url: url,
            data: produs
        }).then(function successCallback(response) {
            console.log(response);
            $scope.produse.push(produs);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteProdus = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.produse = $scope.produse.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateProduct = function(product) {
        $scope.editProduct = product;
    };


    $scope.updateProduct = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editProduct
        }).then(function successCallback(response) {
            $scope.editProduct = {};
            console.log(response);
            // $scope.produse.push($scope.editproduct);
            // done.
        }, function errorCallback(response) {
            $scope.editProduct = {};
            console.log(response);
        });
    };

}]);


app.controller('HoController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/fruct';

    $scope.fructe = [];
    $scope.fields = [];
    $scope.fruct = {};


    $scope.fruit = {};
    $scope.editFruit = {};



    $http.get(url).then(function successCallback(response) {

        $scope.fructe = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.fructe);
        //console.log($scope.fields);

    });
    

    $scope.addFruct = function(fruct) {
        fruct.id = parseInt(fruct.id);
        console.log(fruct.id);
        $http({
            method: 'POST',
            url: url,
            data: fruct
        }).then(function successCallback(response) {
            console.log(response);
            $scope.fructe.push(fruct);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteFruct = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.fructe = $scope.fructe.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateFruit = function(fruit) {
        $scope.editFruit = fruit;
    };


    $scope.updateFruit = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editFruit
        }).then(function successCallback(response) {
            $scope.editFruit = {};
            console.log(response);
            // $scope.fructe.push($scope.editfruit);
            // done.
        }, function errorCallback(response) {
            $scope.editFruit = {};
            console.log(response);
        });
    };

}]);










