var myApp = angular.module("autoComplete", []);


myApp.controller('searchController', ['$scope', '$http', '$timeout',function($scope, $http, $timeout) {

    $scope.textChanged = function() {
        $scope.isLoading = true;

       var url = '/search/' + $scope.prefix;

        console.log("testesttest");

        console.log($scope.prefix);

        $http({
                method: 'GET',
                url: url
              }).then(function successCallback(response) {

                          console.log(response.data);

                            $('#query').typeahead({
                                    local: response.data
                            });
                            $('.tt-query').css('background-color','#fff');

                          $scope.isLoading=false;

                        }, function errorCallback(error) {
                          $scope.isLoading=false;
                     });
    };


}]);

