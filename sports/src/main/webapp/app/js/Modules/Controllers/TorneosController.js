App.controller('TorneosController', ['$scope', 'uiGridConstants', 'toaster', '$http', 
    function($scope, uiGridConstants, toaster, $http){
	
	var data = [];

    gridTorneo = $scope.gridTorneo = {
        columnDefs: [
            { field: 'idCalendario',visible:false},
            { field: 'precio' , name:'Precio'},
            { field: 'fecha' , name:'Fecha'},
            {name: 'Acciones', cellTemplate:'<div ng-controller="ServicioModalController" >' +
            '<button ng-click="modificar(row)" class="btn btn-primary" >' +
            '<span class="fa fa-rocket"></span>' +
            '</button>'+
            '</div> <div ng-controller="ServicioModalController" >' +
                '<button ng-click="eliminar(row)" class="btn btn-primary" >' +
                '<span class="fa fa-rocket"></span>' +
                '</button>'+
            '</div>'}
        ],
        data: establecimientoCalendario.torneos
    }
    
    
	
}]);

var torneoModificar = {};

App.controller('TorneoModalController', ['$scope', '$modal', "$timeout" ,"$http", function ($scope, $modal, $timeout ,$http) {
	
	
	$scope.registrar = function () {

        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myTorneoModalContent.html',
            controller: RegistrarTorneoInstanceCtrl,
            size: 'lg'
        });

    };

    $scope.modificar = function ($row) {
        torneoModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myTorneoModalContent.html',
            controller: ModificarTorneoInstanceCtrl,
            size: 'lg'
        });
    };
    
    $scope.eliminar = function(row){
		$http.post('rest/reservaciones/delete', {
			idCalendario : row.idCalendario,
			establecimiento : establecimientoCalendario.idEstablecimientoDeportivo
	 	}).success(function(data){
	 		var toasterdata = {
					type:  'success',
					title: 'Establecimiento',
					text:  'Se ha aceptado la reservacion correctamente'
			};
			//$scope.pop(toasterdata);
			establecimientoCalendario = data;
			gridTorneo = establecimientoCalendario.torneos;
			$state.reload();
	 	})
	};
    
    var RegistrarTorneoInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.torneoForm = {};
        $scope.torneoForm.fecha = new Date();
        
        $scope.torneoForm.registrar = function () {
        	
            var data = {
            	"precio": $scope.torneoForm.precio,
                "fecha": $scope.torneoForm.fecha,
                "establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo,
                "accion" : $scope.accion
            };
            $http.post('rest/reservaciones/saveTorneo', data).
            success(function(data){
            	var toasterdata = {
			            type:  'success',
			            title: 'Servicio',
			            text:  'Se registro el servicio correctamente.'
			    };
    			$scope.pop(toasterdata);
            	gridTorneo.data = data.torneos;
            	establecimientoCalendario = data;
            });
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    
    RegistrarTorneoInstanceCtrl.$inject = ["$scope", "$modalInstance", "$http"];
    var ModificarTorneoInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Modificar";
        $scope.torneoForm = {};

        
        $scope.torneoModificar.idReservacion = torneoModificar.idCalendario;
        $scope.torneoForm.precio = servicioModificar.precio;

        fecha = new Date(torneoModificar.fecha.millis);
        
        $scope.torneoForm.fecha = fecha;
        
        
        $scope.servicioForm.modificar = function () {
        	var data = {
        			"idCalendario": torneoModificar.idReservacion,
                	"precio": $scope.torneoForm.precio,
                    "fecha": $scope.torneoForm.fecha,
                    "establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo,
                    "accion" : $scope.accion
                };
                $http.post('rest/reservaciones/saveTorneo', data).
                success(function(data){
                	var toasterdata = {
    			            type:  'success',
    			            title: 'Servicio',
    			            text:  'Se registro los cambios correctamente.'
    			    };
        			$scope.pop(toasterdata);
        			gridTorneo.data = data.torneos;
        			establecimientoCalendario = data;
                	
                });

            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarTorneoInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);

    
    