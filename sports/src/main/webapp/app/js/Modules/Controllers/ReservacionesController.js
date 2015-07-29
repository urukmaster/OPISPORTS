App.controller('ReservacionesController', ['$scope','$state', function($scope,$state){
	$scope.init = function(){  	
	    $state.go('app.perfil.reservaciones.calendario')
    };
    $scope.init();
    
    $scope.calendario = function(){
    	$scope.init();
    }
    
    $scope.pendientes = function(){
    	$state.go('app.perfil.reservaciones.pendientes');
    }
}]);