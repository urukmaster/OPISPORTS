/**
 * Created by JuanManuel on 09/07/2015.
 */
var gridEstablecimientos = {};

App.controller('EstablecimientosController', ['$scope','$http', '$stateParams','uiGridConstants', function($scope,$http, $stateParams,uiGridConstants) {
    // no filter for inbox
	
    $scope.init = function(){  	
	    $http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			$scope.Establecimientos = response.establecimientoDeportivo;
		});

    };
    $scope.init();

}]);
       
App.controller('InformacionPerfilController', ['$scope', '$http', '$stateParams', '$state', function($scope, $http, $stateParams,$state) {
	
	$scope.init = function(){
		$scope.mostrarCalendario = false; 	
	    $http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			var establecimientos = response.establecimientoDeportivo;
			for (var i = 0; i < establecimientos.length; i++) {
                if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                    $scope.establecimiento = establecimientos[i];
                }
            }
		});
    };
    $scope.init();
    $state.go("app.perfil.informacion");
    
    
    $scope.mostrarReservaciones = function() {
    		$scope.mostrarCalendario = true;
			$('#calendar').fullCalendar('render');
	}
			
	$scope.mostrarInformacion = function(){
		$scope.mostrarCalendario = false;
		$state.go("app.perfil.informacion");
	}
			
	$scope.mostrarServicios = function(){
		$scope.mostrarCalendario = false;
		$state.go("app.perfil.servicios");
	}

}]);
