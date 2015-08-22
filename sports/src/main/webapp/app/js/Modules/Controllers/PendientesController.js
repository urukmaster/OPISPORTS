var gridPendientes = {};

App.controller('PendientesController',['$scope','$rootScope','uiGridConstants','$http',
				function($scope, $rootScope,uiGridConstants, $http) {
	
	var pendientes = [];
	
	angular.forEach(establecimientoCalendario.pendientes, function(pendiente, index){
		var pendienteView = {};
		pendienteView.idCalendario = pendiente.idCalendario;
		pendienteView.reservacion = pendiente.title;
		pendienteView.inicio = getFechaHora(pendiente.start.millis);
		pendienteView.fin = getFechaHora(pendiente.end.millis);
		pendienteView.start = new Date(pendiente.start.millis);
		pendienteView.servicio = pendiente.servicio;
		pendientes.push(pendienteView);
	});
	
	function getFechaHora(miliSegundos){
		
		var fechaHora = new Date(miliSegundos);
		var fecha = fechaHora.getDate()+'/';
		if(fechaHora.getMonth()+1<=10){
			fecha += fechaHora.getMonth() + 1 + '/';
		}else{
			fecha = '0'+fechaHora.getMonth()+ 1 + '/';
		}
		fecha+= fechaHora.getFullYear();
		
		var hora;
		if(fechaHora.getHours()>= 10){
			hora = fechaHora.getHours() + ':';
		}else{
			hora= '0'+fechaHora.getHours() + ':';
		}
		if(fechaHora.getMinutes() >= 10){
			hora += fechaHora.getMinutes();
		}else{
			hora += '0'+ fechaHora.getMinutes();
		}
		return fecha + ' ' + hora;
	}
	
	gridPendientes = $scope.gridPendientes = {
		paginationPageSizes: [],
		paginationPageSize: 7,
		columnDefs : [
			{
				field : 'idCalendario',
				visible : false
			},
			{
				field: 'start',
				visible: false
			},
			{
				field: 'servicio',
				visible: false
			},
			{
				field : 'reservacion',
				name : "Reservación"
			},
			{
				field:'inicio',
				name:'Hora incial'
			},
			{
				field: 'fin',
				name:'Hora final'
			},
			{name: 'Reservar', cellTemplate:
			'<div class="btn-group btn-group-justified" role="group">' +
				'<div class="btn-group" role="group" ng-controller="ReservacionModalController" >' +
	            	'<button ng-click="reservar(row.entity)" class="btn btn-green" >' +
	            		'<span class="fa fa-check"></span>' +
	            	'</button>'+
	            '</div>'+
	        '</div>',width:90},
	        {name: 'Cancelar', cellTemplate:
	        '<div class="btn-group btn-group-justified" role="group">' +
	        	'<div class="btn-group" role="group" ng-controller="ReservacionModalController" >' +
		            '<button ng-click="eliminar(row.entity)" class="btn btn-warning" >' +
		            	'<span class="fa fa-close"></span>' +
		            '</button>'+
		     	'</div>'+
		     '</div>',width:90}
			],
		data : pendientes
	}
	
} ]);

App.controller('ReservacionModalController', ['$scope', '$rootScope','$http', '$state', '$modal', 'toaster', '$stateParams',function($scope, $rootScope,$http, $state, $modal, toaster, $stateParams){
	var accion = '';
	var pregunta = '';
	var reserva = {};
	
	$scope.eliminar = function(row){
		reserva = row;
		accion = 'Eliminar';
		pregunta = '¿Desea eliminar la solicitud de reservación?'
		var modalInstance = $modal.open({
            templateUrl: '/modalPendientes.html',
            controller: ModalInstanceCtrl,
            size: ''
        });
	}
	
	$scope.reservar = function(row){
		reserva = row; 
		accion = 'Reservar';
		pregunta = '¿Seguro que desea reservar la solicitud?'
		var modalInstance = $modal.open({
            templateUrl: '/modalPendientes.html',
            controller: ModalInstanceCtrl,
            size: ''
        });
	}
	
	var ModalInstanceCtrl = function ($scope, $modalInstance, toaster, $timeout, $route) {
		$scope.accion = accion;
		$scope.pregunta = pregunta;
	
		$scope.confirmar = function(){
			var rest = '';
			var data = {};
			data.idCalendario = reserva.idCalendario;
			data.establecimiento = establecimientoCalendario.idEstablecimientoDeportivo;
			if($scope.accion == 'Eliminar'){
				rest = 'rest/reservaciones/delete';
			}else{
				rest = 'rest/reservaciones/update';
				data.estado = 'Reservado';
				data.accion = 'Aceptar';
				data.usuario = 1;
				data.fecha = reserva.start;
				data.hora = reserva.start.getTime();
				data.servicio = reserva.servicio;
				data.torneo = false;
			}
			
			$http.post(rest, data)
			.success(function(data){
				if(data.code == 200){
					var toasterdata = {
							type: 'success',
							title: 'Reservaciones',
							text: data.codeMessage
					};
					$scope.pop(toasterdata);
					$http.get('rest/establecimientoDeportivo/getAll')
	        		.success(function(response) {
	        			if(response.code == 200){
	        			var establecimientos = response.establecimientosDeportivos;
	        			for (var i = 0; i < establecimientos.length; i++) {
	                        if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
	                            establecimientoCalendario = establecimientos[i];
	                            gridPendientes.data = establecimientoCalendario.pendientes;
	                        }
	                    }
	        			}else{
	                		$rootScope.errorMessage = response.codeMessage;
	                		$state.go('page.error');
	                	}
	        		});
					gridPendientes.data = establecimientoCalendario.pendientes;
				}else{
					$rootScope.errorMessage = data.codeMessage;
					$state.go('page.error');
				}
			});
			 $scope.pop = function(toasterdata) {
		          toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
		      };
		      $modalInstance.close('closed');  
	        	
		}
	}
}]);