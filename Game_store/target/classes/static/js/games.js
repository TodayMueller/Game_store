var app = angular.module('games', []).config(function ($httpProvider) {
    csrftoken = $("meta[name='_csrf']").attr("content");
    csrfheader = $("meta[name='_csrf_header']").attr("content");
    $httpProvider.defaults.headers.common["X-CSRF-TOKEN"] = csrftoken;
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(csrfheader, csrftoken);
    });
});

app.controller("GamesController", function ($scope, $http) {

    $scope.successGetGamesCallback = function (response) {                
         $scope.gamesList = response.data;
        $scope.errormessage="";
    };

    $scope.errorGetGamesCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get list of Games";
    };

    $scope.getGames = function () {
        $http.get('/public/rest/games').then($scope.successGetGamesCallback, $scope.errorGetGamesCallback);
    };

    $scope.successDeleteGameCallback = function (response) {
        for (var i = 0; i < $scope.gamesList.length; i++) {
            var j = $scope.gamesList[i];
            if (j.id === $scope.deletedId) {
                $scope.gamesList.splice(i, 1);
                break;
            }
        }
        $scope.errormessage="";
    };

    $scope.errorDeleteGameCallback = function (error) {
        console.log(error);
        if (error.status === 405) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
        if (error.status === 403) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
            $scope.errormessage = "Unable to delete game; check if there are any related records exist. Such records should be removed first";
    };

    $scope.deleteGame = function (id) {
        $scope.deletedId = id;
        $http.delete('/public/rest/games/' + id).then($scope.successDeleteGameCallback, $scope.errorDeleteGameCallback);
    };


    $scope.successGetGameCallback = function (response) {
        $scope.gamesList.splice(0, 0, response.data);
        $scope.errormessage="";
    };

    $scope.errorGetGameCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on game "+$scope.inputname;
    };

    $scope.successAddGameCallback = function (response) {
        $http.get('/public/rest/games/' + $scope.inputname).then($scope.successGetGameCallback, $scope.errorGetGameCallback);
        $scope.errormessage="";
    };

    $scope.errorAddGameCallback = function (error) {
        console.log(error);
        if (error.status === 405) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
        if (error.status === 403) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
            $scope.errormessage = "Impossible to add new game; check if it's number is unique";
    };

    $scope.addGame = function () {
        $http.post('/public/rest/games/' + $scope.inputname + "/" + $scope.inputyear + "/" + $scope.inputdeveloper + "/" + $scope.inputprice).then($scope.successAddGameCallback, $scope.errorAddGameCallback);
    };

});
