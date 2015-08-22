App.controller('ReservacionesController', ['$scope','$state', function($scope,$state){
	$scope.init = function(){  	
		if(establecimientoCalendario != undefined){
			$state.go('app.perfil.reservaciones.calendario');
		}
    };
    $scope.init();
    
    $scope.calendario = function(){
    	$scope.init();
    }
    
    $scope.pendientes = function(){
    	$state.go('app.perfil.reservaciones.pendientes');
    }
    
    $scope.torneos = function(){
    	$state.go('app.perfil.reservaciones.torneos');
    }
}]);

App.controller('ModalReservacionesController', ['$rootScope', '$scope', '$modal', '$http', '$state','toaster','$timeout','$route','$stateParams', function ($rootScope, $scope, $modal, $http, $state, moment,toaster,$timeout,$route,$stateParams) {
	var servicioActual;
    $scope.open = function (size, idServicioActual) {
    	servicioActual = idServicioActual;

        var modalInstance = $modal.open({
            templateUrl: '/modalReservaciones.html',
            controller: ModalInstanceCtrl,
            size: size
        });

        var state = $('#modal-state');
        modalInstance.result.then(function () {
            state.text('Modal dismissed with OK status');
        }, function () {
            state.text('Modal dismissed with Cancel status');
        });
    };
        
    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var ModalInstanceCtrl = function ($scope, $modalInstance, toaster, $timeout, $route, $stateParams) {
    	$scope.reservacion = {};	
    	var horaInicial = new Date();
    	horaInicial.setMinutes(00, 00, 00);
    	horaInicial.setSeconds(00, 00);
        $scope.reservacion.hora = horaInicial;
    	
		$scope.ok = function () {
        	
        	var fecha = $scope.reservacion.fecha;
        	var hora = $scope.reservacion.hora;
        	
        	var registrar = true;
        	
        	angular.forEach(establecimientoCalendario.calendario, function(reservacion, index){
        		if(validarCalendario(servicioActual, hora, fecha)){
        			registrar = false;
        		}
        	})
        	
        	if(registrar == true){
        	$scope.registrarReservacion(fecha, hora);

			
        	}else{
        		var toasterdata = {
			            type:  'error',
			            title: 'Reservación',
			            text:  'El servicio seleccionado se encuentra ocupado a la hora seleccionada. \n Intente nuevamente.'
			    };
    			$scope.pop(toasterdata);
        	}
        	
        	$modalInstance.close('closed');  
        	
            
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        
        $scope.registrarReservacion = function(fecha, hora){
        	$http.post('rest/reservaciones/save', {
    			fecha: fecha,
    			hora: hora.getTime(),
    			estado : 'Pendiente',
    			servicio : servicioActual,
    			usuario : 1,
    			establecimiento : establecimientoCalendario.idEstablecimientoDeportivo,
    			accion:'Regsitrar'
    		 	})
    		.success(function(data){
    			if(data.code = 200){
    			var toasterdata = {
			            type:  'success',
			            title: 'Establecimiento',
			            text:  'Debe esperar a que la reservación sea aprobada\n por el administrador'
			    };
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    			$http.get('rest/establecimientoDeportivo/getAll')
        		.success(function(response) {
        			if(response.code == 200){
        			var establecimientos = response.establecimientosDeportivos;
        			for (var i = 0; i < establecimientos.length; i++) {
                        if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                            establecimientoCalendario = establecimientos[i];
                        }
                    }
        			}else{
                		$rootScope.errorMessage = response.codeMessage;
                		$state.go('page.error');
                	}
        		});
    			$('#calendarioContent').remove();
    			$rootScope.$broadcast("actualizar");
    			}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
    		});
        }
        
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        $scope.callAtTimeout = function(){
        	$route.reload();
        }
        
        function validarCalendario(servicio, hora, fecha){
        	var valido = false;
        	angular.forEach(establecimientoCalendario.servicios, function(servicioEstablecimiento, index){
        		if(servicioEstablecimiento.idServicio == servicio){
        			angular.forEach(servicioEstablecimiento.reservaciones, function(reservacion, index){
        				var horaReservacion = hora.toTimeString();
        				mes = function(){
        					if(fecha.getMonth()+1 > 10){
        						return '0'+ fecha.getMonth()+1; 
        					}else{
        						return fecha.getMonth()+1;
        					}
        				}
        				var fechaReservacion = fecha.getFullYear() + '-' + mes +
        				fecha.getDate();
        				
        				horaReservacion = horaReservacion.split(' ')[0];
        				if(reservacion.hora == horaReservacion && fechaReservacion == reservacion.fecha){
        					valido = true;
        				}
        			});
        		}
        	});
        	return valido;
        }
               
    };
    
    
    ModalInstanceCtrl.$inject = ["$scope", "$modalInstance", "toaster","$timeout", "$route", "$stateParams"];

}]);