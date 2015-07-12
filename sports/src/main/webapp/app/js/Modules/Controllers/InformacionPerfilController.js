/**
 * Created by JuanManuel on 09/07/2015.
 */
var gridEstablecimientos = {};
App.controller('EstablecimientosController', ['$scope','$http', '$stateParams','uiGridConstants', function($scope,$http, $stateParams,uiGridConstants) {
    // no filter for inbox
    var path = 'server/establecimientos.json';

        $http.get(path).then(function (resp) {
            $scope.Establecimientos = resp.data;
        });



}]);

App.controller('InformacionPerfilController', ['$scope', '$http', '$stateParams', function($scope, $http, $stateParams) {
    var path = 'server/establecimientos.json';
    $scope.init = function(){
        console.log("entrarndo")
        $http.get(path).then(function (resp) {
            console.log("ressssp",resp)
            var establecimientos = resp.data;
            for (var i = 0; i < establecimientos.length; i++) {
                if (establecimientos[i].id == $stateParams.mid){
                    $scope.establecimiento = establecimientos[i];
                }
            }
        });
    }

    $scope.init();
}]);
