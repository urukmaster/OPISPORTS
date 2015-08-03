/**
 * Fecha: 23-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 */

var eventoModificar = {};

App.controller('EventoModalController', ['$scope', '$modal', "$timeout" ,"$http", "$state", function ($scope, $modal, $timeout ,$http, $state) {
	
	$scope.modificar = function () {
		var ModificarModalInstance = $modal.open({
            templateUrl: '/myEventoModalContent.html',
            controller: ModificarEventoInstanceCtrl,
            size: 'lg'
        });
    };

//------------------------------------------------------------------------------------
    var ModificarEventoInstanceCtrl = function ($scope, $modalInstance) {
    	
    	var fecha = new Date(eventoModificar.fechaModificar.millis);
    	var hora = new Date(eventoModificar.horaModificar.millis);
    	
    	$scope.eventoForm = {};
        $scope.eventoForm.hora = hora;
        $scope.eventoForm.fecha = fecha;
        $scope.eventoForm.nombre = eventoModificar.nombre;
        $scope.eventoForm.precio = eventoModificar.precio;
        $scope.eventoForm.informacion = eventoModificar.informacion;
        $scope.eventoForm.tipoEvento = eventoModificar.tipoEvento;
        $scope.eventoForm.cupo = eventoModificar.cupo;
        $scope.eventoForm.direccion = eventoModificar.direccion;
        
        $scope.eventoForm.modificar = function () {
        	console.log($scope.eventoForm.fecha);
        	var data = {
        		"idEvento" : eventoModificar.idEvento,
        		"nombre": $scope.eventoForm.evento,
                "precio": $scope.eventoForm.precio,
                "hora": $scope.eventoForm.hora.getTime(),
                "fecha": $scope.eventoForm.fecha,
                "informacion": $scope.eventoForm.informacion,
                "tipoEvento" : 1,
                "establecimiento" : 1,
                "cupo" : $scope.eventoForm.cupo,
                "direccion" : $scope.eventoForm.direccion,
                "accion" : "Modificar"
            };
            
            $http.post('rest/evento/save', data).
            success(function(data){
            	var toasterdata = {
			            type:  'success',
			            title: 'Evento',
			            text:  'Se registro el evento correctamente.'
			    };
    			//$scope.pop(toasterdata);
            	$modalInstance.dismiss('cancel');
            	$state.reload();
            });
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

    ModificarEventoInstanceCtrl.$inject = ["$scope", "$modalInstance", "$http"];
}]);

App.controller('PerfilEventoController', ['$scope','$http', '$stateParams','$state', function($scope, $http, $stateParams, $state) {

    
    $scope.init = function(){
		$http.post('rest/evento/getEvento', $stateParams.id)
		.success(function(response) {

            $scope.evento = response.evento;
            eventoModificar = $scope.evento;
            eventoModificar.horaModificar = response.hora;
            eventoModificar.fechaModificar = response.fecha;
		});
    };
    
    $scope.init();
    $state.go("app.perfilEvento.informacion");

    $scope.mostrarInformacion = function(){
		$state.go("app.perfilEvento.informacion");
	}
    
	$scope.mostrarPuntosDeRetiro = function(){
		$state.go("app.perfilEvento.puntosRetiro");
	}

    $scope.init();
}]);