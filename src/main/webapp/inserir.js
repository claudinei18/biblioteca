angular.module('biblioteca', ['ngFileUpload'])
    .controller('crudController', ['$scope', '$http' , function ($scope, Upload) {

        $scope.inserir = function () {
            console.log("inserir");
            console.log($scope.livro);

            $http.put('/api/inserir', {livro: $scope.livro})
                .then(function(data, status, headers, config) {
                    $scope.message = data;
                });
        };
    }]);