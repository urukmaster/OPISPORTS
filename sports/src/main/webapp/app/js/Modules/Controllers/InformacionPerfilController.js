/**
 * Created by JuanManuel on 09/07/2015.
 */


App.controller('EstablecimientosController', ['$scope','$http', '$stateParams', function($scope,$http, $stateParams) {
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
		$http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			var establecimientos = response.establecimientoDeportivo;
			for (var i = 0; i < establecimientos.length; i++) {
                if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                    $scope.establecimiento = establecimientos[i];
                    establecimientoCalendario = establecimientos[i];
                }
            }
		});
    };
    
    $scope.init();
    $state.go("app.perfil.informacion");
    
    
    $scope.mostrarReservaciones = function() {

    	$state.go("app.perfil.reservaciones");
	}

    $scope.mostrarInformacion = function(){
		$scope.mostrarCalendario = false;
		$state.go("app.perfil.informacion");
	}
			
	$scope.mostrarServicios = function(){
		$scope.mostrarCalendario = false;
		$state.go("app.perfil.servicios");
	}

    $scope.init();
}]);

App.controller('EstablecimientosFormController', ['$scope','$http', '$stateParams','$state', function($scope,$http, $stateParams,$state) {
    // no filter for inbox
	$scope.establecimientoForm = {};
    $scope.establecimientoForm.registrar = function () {

        var data = {
            "nombre": $scope.establecimientoForm.nombre,
            "telefono": $scope.establecimientoForm.telefono,
            "direccion": $scope.establecimientoForm.direccion,
            "pagina": $scope.establecimientoForm.pagina,
            "idUsuario": 1
        };
        $state.go('app.index');
    };
    
   

}]);


