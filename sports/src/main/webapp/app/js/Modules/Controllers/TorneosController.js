
App.controller('TorneosController', ['$scope', 'uiGridConstants', function($scope, uiGridConstants){
	
	var torneos = [];
	
	angular.forEach(establecimientoCalendario.torneos, function(torneoPOJO, index){
		
		var torneo = {};
		var minutes;
		torneo.idTorneo = torneoPOJO.idTorneo;
		torneo.cupos = torneoPOJO.cupos;
		torneo.torneo = torneoPOJO.torneo;
		torneo.start = torneoPOJO.start;
		torneo.fecha = torneoPOJO.start.dayOfMonth + '/' + torneoPOJO.start.monthOfYear + '/' + torneoPOJO.start.year + ' ' +
						torneoPOJO.start.hourOfDay + ':00 - ' +
						torneoPOJO.end.hourOfDay + ':00';
		torneos.push(torneo);
	});
	
	gridTorneos = $scope.gridTorneos = {
			paginationPageSizes: [],
			paginationPageSize: 7,
			columnDefs : [
			              {
			            	  field: 'idTorneo', visible: false
			              },
			              {
			            	  field: 'torneo', name: 'Torneo'
			              },
			              {
			            	  field: 'fecha', name: 'Fecha'
			              },
			              {
			            	  field: 'cupos', name: 'Cupos disponibles'
			              },
			              {name: 'acciones', cellTemplate:'<div ng-controller="TorneoModalController" >' +
                              '<button ng-click="modificar(row)" class="btn btn-green" >' +
                              '<span class="fa fa-pencil"></span>' +
                              '</button><button ng-click="eliminar(row)" class="btn btn-warning"> ' +
                              '<span class="fa fa-trash"></span>' +
                              '</div>',width:120}
			              ],
			data: torneos
	};
}]);

App.controller('TorneoModalController', ['$scope', '$rootScope','$modal', '$timeout' ,'$http', 'toaster', function ($scope, $rootScope,$modal, $timeout ,$http) {
	
	
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
	 		if(data.code == 200){
	 		var toasterdata = {
					type:  'success',
					title: 'Establecimiento',
					text:  'Se ha aceptado la reservacion correctamente'
			};
			$scope.pop(toasterdata);
			establecimientoCalendario = data;
			gridTorneo = establecimientoCalendario.torneos;
			$state.reload();
	 		 }else{
	            	$rootScope.errorMessage = data.codeMessage;
	            	$state.go('page.error');
	            }
	 	})
	};
    
    var RegistrarTorneoInstanceCtrl = function ($scope, $modalInstance) {
    	
        $scope.accion = "Registrar";
        $scope.torneoForm = {};
        $scope.torneoForm.fecha = new Date();
        $scope.torneoForm.hora = new Date();
        $scope.torneoForm.hora.setMinutes(00);
        
        $scope.torneoForm.registrar = function () {
        	
        	var data = {
        			"precio": $scope.torneoForm.precio,
                    "fecha": $scope.torneoForm.fecha,
                    "establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo,
                    "accion" : $scope.accion,
                    "torneo" : true,
                    "estado" : "Reservado",
                    "servicio" : establecimientoCalendario.servicios[0],
                    "usuario" : 1,
                    "nombre" : $scope.torneoForm.nombre,
                    "cupos" : $scope.torneoForm.cupos,
                    "horasTorneos" : $scope.torneoForm.horasTorneos,
                    "hora" : $scope.torneoForm.hora.getTime()
                };
            $http.post('rest/reservaciones/save', data).
            success(function(data){
            	if(data.code == 200){
            	var toasterdata = {
			            type:  'success',
			            title: 'Servicio',
			            text:  'Se registro el servicio correctamente.'
			    };
    			$scope.pop(toasterdata);
            	gridTorneo.data = data.torneos;
            	establecimientoCalendario = data;
            	 }else{
                 	$rootScope.errorMessage = data.codeMessage;
                 	$state.go('page.error');
                 }
            });
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    
    RegistrarTorneoInstanceCtrl.$inject = ["$scope", "$modalInstance", "$http"];
    
    var ModificarTorneoInstanceCtrl = function ($scope, $modalInstance) {
    	
    	angular.forEach(establecimientoCalendario.torneos, function(torneoPOJO, index){
    		if(torneoPOJO.idTorneo == torneoModificar.idTorneo){
    			torneoModificar = torneoPOJO;
    		}
    	});
    	
		$scope.accion = "Modificar";
        $scope.torneoForm = {};
        
        $scope.torneoForm = torneoModificar;

        fecha = new Date(torneoModificar.start.millis);
        
        $scope.torneoForm.fecha = fecha;
        
        hora = new Date(torneoModificar.start.millis);
        hora.setMinutes(00);
        $scope.torneoForm.hora = hora
        
    	
        $scope.torneoForm.modificar = function () {
        	var data = {
        			"idCalendario" : $scope.torneoForm.idTorneo,
                	"fecha": $scope.torneoForm.fecha,
                    "establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo,
                    "accion" : $scope.accion,
                    "torneo" : true,
                    "estado" : "Reservado",
                    "servicio" : establecimientoCalendario.servicios[0].idServicio,
                    "usuario" : 1,
                    "nombre" : $scope.torneoForm.nombre,
                    "cupos" : $scope.torneoForm.cupos,
                    "horasTorneos" : $scope.torneoForm.horasTorneos,
                    "hora" : $scope.torneoForm.hora.getTime()
                };
                $http.post('rest/reservaciones/save', data).
                success(function(data){
                	if(data.code == 200){
                	var toasterdata = {
    			            type:  'success',
    			            title: 'Servicio',
    			            text:  'Se registro los cambios correctamente.'
    			    };
                	$scope.torneoForm = null;
        			$scope.pop(toasterdata);
        			gridTorneo.data = data.torneos;
        			establecimientoCalendario = data;
                	 }else{
                     	$rootScope.errorMessage = data.codeMessage;
                     	$state.go('page.error');
                     }
                });

            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
        	$scope.torneoForm = null;
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarTorneoInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);