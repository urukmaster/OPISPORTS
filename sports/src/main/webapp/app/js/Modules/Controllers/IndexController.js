/**=========================================================
 * Module: Index
 =========================================================*/

App.controller('IndexController', ['$scope','$http','$state', function($scope,$http,$state) {
    
    $scope.ConsultarEventos = function () {
        $state.go('app.eventosIndex');
    };  

}]);