/**
 * Modulo Controlador para traer los datos de un evento deportivo
 * author: Mauricio Fernandez
 * Fecha: 23/07/2015
 * Revision: 1.1 
 */

var eventoActual = {};
var cantTiquetesReservados;
var distribuciones = {};
/**==========================================================
 * Modulo: EventoModalController
 * Este controlador se encarga de consultar y modificar la 
 * información de un evento deportivo.
 ============================================================*/
App.controller('EventoModalController', ['$scope', '$rootScope','$modal', "$timeout" ,"$http", "$state", 'toaster', function ($scope, $rootScope,$modal, $timeout ,$http, $state, toaster) {
	
	//Abre el "Modal" de modificación
	$scope.modificar = function () {
		var ModificarModalInstance = $modal.open({
            templateUrl: '/myEventoModalContent.html',
            controller: ModificarEventoInstanceCtrl,
            size: 'lg'
        });
    };

//------------------------------------------------------------------------------------
    var ModificarEventoInstanceCtrl = function ($scope, $modalInstance) {
    	
    	var fecha = new Date(eventoActual.fechaModificar.millis);
    	var hora = new Date(eventoActual.horaModificar.millis);
    	
    	$scope.eventoForm = {};
        $scope.eventoForm.hora = hora;
        $scope.eventoForm.fecha = fecha;
        $scope.eventoForm.nombre = eventoActual.nombre;
        $scope.eventoForm.precio = eventoActual.precio;
        $scope.eventoForm.informacion = eventoActual.informacion;
        $scope.eventoForm.tipoEvento = eventoActual.tipoEvento;
        $scope.eventoForm.cupo = eventoActual.cupo;
        $scope.eventoForm.direccion = eventoActual.direccion;
        
        //Guarda la modificación del evento
        $scope.eventoForm.modificar = function () {
        	var data = {
        		"idEvento" : eventoActual.idEvento,
        		"nombre": $scope.eventoForm.nombre,
                "precio": $scope.eventoForm.precio,
                "hora": $scope.eventoForm.hora.getTime(),
                "fecha": $scope.eventoForm.fecha,
                "informacion": $scope.eventoForm.informacion,
                "tipoEvento" : 1,
                "establecimiento" : 1,
                "active" : 1,
                "cupo" : $scope.eventoForm.cupo,
                "direccion" : $scope.eventoForm.direccion,
                "accion" : "Modificar"
            };
            
            $http.post('rest/evento/save', data).
            success(function(data){
            	if(data.code ==200){
            	var toasterdata = {
			            type:  'success',
			            title: 'Evento',
			            text:  'Se registro el evento correctamente.'
			    };

      			$scope.pop(toasterdata);
      			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
            	$modalInstance.dismiss('cancel');
            	}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
            });
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        
        //Despliegue de confirmación    
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        $scope.callAtTimeout = function(){
        	$state.reload();	
        }
    };

    ModificarEventoInstanceCtrl.$inject = ["$scope", "$modalInstance", "$http"];
    
}]);

/**==========================================================
 * Modulo: PerfilEventoController
 * Este controlador se traer un evento deportivo por medio del Id
 ============================================================*/

App.controller('PerfilEventoController', ['$scope','$http', '$stateParams','$state', '$modal', '$rootScope', function($scope, $http, $stateParams, $state, $modal, $rootScope) {

    $scope.init = function(){
		$http.post('rest/evento/getEvento', $stateParams.id)
		.success(function(response) {
			if(response.code == 200){
			cantTiquetesReservados = $scope.obtenerCantTiquetes(response.evento.tiquetes);
            $scope.evento = response.evento;
            eventoActual = $scope.evento;
            eventoActual.horaModificar = response.hora;
            eventoActual.fechaModificar = response.fecha;
            $scope.Distribuciones = response.distribuciones;
			}else{
        		$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
        	}
		});
    };
	
	$scope.obtenerCantTiquetes = function(listaTiquetes){
		var cant = 0;
		for(i = 0; i < listaTiquetes.length; i++){
			if(listaTiquetes[i].estado == 'reservado'){
				cant++;
			}
		}
		return cant;
	}
    
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

/**==========================================================
 * Module: EliminarEventoModalController
 * Implementa el modal de eliminacion de un evento
 ============================================================*/
App.controller('EliminarEventoModalController', ['$scope', '$rootScope','$modal', '$http', 'toaster','$state','$timeout', function ($scope, $rootScope,$modal, $http, toaster, $state, $timeout) {
	var id;
	$scope.open = function (pid) {
	id = pid;
	var modalInstance = $modal.open({
		templateUrl: '/modalEliminarEvento.html',
		controller: ModalInstanceCtrl,
		size: 'sm'
	});
	
	var state = $('#modal-state');
	modalInstance.result.then(function () {
	  state.text('Modal dismissed with OK status');
	}, function () {
	  state.text('Modal dismissed with Cancel status');
	    });
	};
	
	//Método que redirecciona a la página de reporte de tiquetes
	$scope.consultarTiquetes = function(pnombreEvento){
        $state.go('app.reporteTiquetes',{nombre: pnombreEvento});
	}
	
	
  	var ModalInstanceCtrl = function ($scope, $modalInstance) {
	
	    $scope.ok = function () {
	    	$http.post('rest/evento/delete', id).
	        success(function(data){
	        	if(data.code == 200){
	        	var toasterdata = {
			            type:  'success',
			            title: 'Evento',
			            text:  'Se eliminó el evento.'
			    };
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
	        	}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
	        });
	    	$modalInstance.close('closed');
	    };
	    
	    //notificacion
	    $scope.pop = function(toasterdata) {
	        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	    };
	    
	    $scope.callAtTimeout = function(){
	    	$state.go("app.eventosIndex");
	    }
	
	    $scope.cancel = function () {
	    	$modalInstance.dismiss('cancel');
	    };
	    
	  };
	  
	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"]; 

}]);

/**==========================================================
 * Modulo: InscripcionModalController
 * Este controlador se encarga de de realizar el registro de
 * una inscripción a un evento deportivo.
 ============================================================*/
App.controller('InscripcionModalController', ['$scope', '$rootScope','$modal', "$timeout" ,"$http", "$state", '$rootScope', 'toaster', function ($scope, $rootScope,$modal, $timeout ,$http, $state, $rootScope, toaster) {
	
	/*Abre el "Modal" de inscripción si el usuario esta logueado, de lo 
	contrario lo lleva a la página de login*/
	$scope.inscripcion = function () {
		
		if($rootScope.usuario == null){
        	var toasterdata = {
		            type:  'error',
		            title: 'Evento',
		            text:  'Por favor ingresar.'
		    };
			$scope.pop(toasterdata);
			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
			
		}else{
			
			var ModificarModalInstance = $modal.open({
	            templateUrl: '/modalInscripciones.html',
	            controller: InscripcionInstanceCtrl,
	            size: 'sm'
	        });
			
		}
		
    };
    
    //notificacion de error
    $scope.pop = function(toasterdata) {
        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
    };
    
    //Redireccionamiento a la página de login
    $scope.callAtTimeout = function(){
    	$state.go("app.login");
    }
    
//------------------------------------------------------------------------------------
    var InscripcionInstanceCtrl = function ($scope, $rootScope,$modalInstance) {
    	
    	$scope.inscripcionForm = {};
        $scope.inscripcionForm.nombre = eventoActual.nombre;
        $scope.inscripcionForm.precio = eventoActual.precio;
        $scope.inscripcionForm.fecha = eventoActual.fecha;
        $scope.inscripcionForm.total = eventoActual.precio;
        
        //Seteo de la fecha de caducidad
        var fechaCaducidad = new Date();
        fechaCaducidad.setDate(fechaCaducidad.getDate() + eventoActual.diasParaRetiro);
        
        /*var str = $rootScope.usuario.nombre;*/
        var codigo = eventoActual.idEvento + $rootScope.usuario.nombre.slice(0, 3) + $rootScope.usuario.apellido.slice(0, 3);
        
        //Guarda la modificación del evento
       $scope.inscripcionForm.inscribir = function () {
    	   
    	   var cantTiquetesTotal = $scope.inscripcionForm.cantidad + cantTiquetesReservados;
    	   var cantDisponible = eventoActual.cupo - cantTiquetesReservados;
    	   
    	   if(cantTiquetesTotal > eventoActual.cupo ){
    		   
           	var toasterdata = {
		            type:  'error',
		            title: 'Inscripción',
		            text:  'Por favor escoja menos tiquetes.\nQuedan ' + cantDisponible + ' tiquetes disponibles.'
		    };
        	
  			$scope.pop(toasterdata);
	    	$modalInstance.close('closed');
    		   
    	   }else{
    		   
    		   var data = {
        		"estado" : 'reservado',
        		"fechaCaducidad": fechaCaducidad,
                "precio": $scope.inscripcionForm.precio,
                "evento": eventoActual.idEvento,
                "usuario": $rootScope.usuario.idUsuario,
                "accion" : "Registrar",
                "active" : 1,
                "inscripcion": 1,
                "codigo" : codigo,
                "cantidad" : $scope.inscripcionForm.cantidad,
                "nombreEvento" : eventoActual.nombre
            };
        	       	
            //Llamada para registrar la inscripcion
            $http.post('rest/tiquete/save', data).
            success(function(data){
            	if(data.code == 200){
            	var toasterdata = {
			            type:  'success',
			            title: 'Inscripción',
			            text:  'Se registro la inscripción correctamente.'
			    };
            	
      			$scope.pop(toasterdata);
      			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    	    	$modalInstance.close('closed');
            	}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
            });
        };
    		   
    	}
        //Despliegue de confirmación    
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        //Calculo del total a pagar
        $scope.calcularTotal = function(){
        	$scope.inscripcionForm.total = $scope.inscripcionForm.cantidad * $scope.inscripcionForm.precio;        	
        	
        };
        
        $scope.callAtTimeout = function(){
        	$state.reload();	
        }
    	
        //Cierra el modal
        $scope.cancel = function () {
        	$modalInstance.dismiss('cancel');
        };
    };

    InscripcionInstanceCtrl.$inject = ["$scope", '$rootScope',"$modalInstance", "$http"];
    
}]);