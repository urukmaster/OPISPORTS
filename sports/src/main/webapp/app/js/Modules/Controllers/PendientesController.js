var gridPendientes = {};

App.controller('PendientesController',['$scope','uiGridConstants','$http',
				function($scope, uiGridConstants, $http) {
	
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
			{name: 'acciones', cellTemplate:'<div ng-controller="ReservacionModalController" >' +
	            '<button ng-click="reservar(row.entity)" class="btn btn-primary" >' +
	            '<span class="fa fa-rocket"></span>' +
	            '</button>'+
	            '</div>'}
			],
		data : pendientes
	}
	
} ]);

App.controller('ReservacionModalController', ['$scope', '$http', '$state', function($scope, $http, $state){
	
	$scope.reservar = function(row){
		$http.post('rest/reservaciones/update', {
    			idCalendario : row.idCalendario,
    			fecha: row.start,
    			hora: row.start.getTime(),
    			estado : 'Reservado',
    			servicio : + row.servicio,
    			usuario : 1,
    			accion: 'Aceptar',
    			establecimiento : establecimientoCalendario.idEstablecimientoDeportivo
		 	})
		.	success(function(data){
				var toasterdata = {
						type:  'success',
						title: 'Establecimiento',
						text:  'Se ha aceptado la reservacion correctamente'
				};
				//$scope.pop(toasterdata);
				console.log(establecimientoCalendario);
				establecimientoCalendario = data;
				console.log(establecimientoCalendario);
				gridPendientes = establecimientoCalendario.pendientes;
				$state.reload();
		});
}
}]);