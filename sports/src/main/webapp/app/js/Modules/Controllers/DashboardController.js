/**
 * Modulo Controlador para traer los datos de mis inscripciones
 * author: Mauricio Fernandez
 * Fecha: 15/08/2015
 * Revision: 1.0
 */

/**==========================================================
 * Modulo: MisInscripcionesController
 * Este controlador se encarga de mostrar cada uno de las inscricpiones
 * para un cliente.
 ============================================================*/

App.controller('MisInscripcionesController', ['$scope', '$rootScope','$http', '$state','$rootScope', function($scope, $rootScope,$http, $state,$rootScope) {

	var listaInscripciones = [];
	$scope.init = function(){   	

    	$http.get('rest/inscripcion/getAll', {
		 	})
		.success(function(response){
	    	if(response.code == 200){
	    	
	    	angular.forEach(response.inscripciones, function(inscripcion, index){
	    		if(inscripcion.usuario.idUsuario == $rootScope.usuario.idUsuario){
	    			listaInscripciones.push(inscripcion.listaTiquetes);
	    		}
	    	});

	    	$scope.Inscripciones = listaInscripciones;
	    	}else{
        		$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
        	}
			
		});
    	
	}
	
    //Inicializa la página
    $scope.init();
    
}]);
App.controller('SuscripcionController', ['$scope', '$http', '$state','$rootScope', function($scope, $http, $state,$rootScope) {

	var listaSuscripciones = [];
	$scope.init = function(){   	

    	$http.get('rest/suscripcion/getAll', {
		 	})
		.success(function(response){
	    	console.log(response);
	    	angular.forEach(response.suscripciones, function(suscripcion, index){
	    		if(suscripcion.usuario.idUsuario == $rootScope.usuario.idUsuario){
	    			listaSuscripciones.push(suscripcion);
	    		}
	    	});

	    	$scope.Suscripciones = listaSuscripciones;
			
		});
    	
	}
	
    //Inicializa la página
    $scope.init();
    
}]);



/**==========================================================
 * Module: CancelarInscripcionModalController
 * Implementa el modal de cancelacion de una inscripcion
 ============================================================*/
App.controller('CancelarTiqueteModalController', ['$scope', '$rootScope','$modal', '$rootScope','$http', 'toaster','$state','$timeout', function ($scope, $rootScope,$modal, $rootScope, $http, toaster, $state, $timeout) {
	var id;
    
	$scope.cancelarTiquete = function (idTiquete) {
	id = idTiquete;
	var modalInstance = $modal.open({
		templateUrl: '/modalCancelarTiquete.html',
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
	
	
  	var ModalInstanceCtrl = function ($scope, $modalInstance) {
	
	    $scope.ok = function () {
	        $http.post('rest/tiquete/delete', id).
	        success(function(){
	        	if(data.code == 200){
	        	var toasterdata = {
			            type:  'success',
			            title: 'Tiquete',
			            text:  'Se canceló el tiquete.'
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
	    	$state.reload();	
	    }
	
	    $scope.cancel = function () {
	    	$modalInstance.dismiss('cancel');
	    };
	    
	  };
	  ModalInstanceCtrl.$inject = ["$scope", '$rootScope',"$modalInstance"]; 

}]);
App.controller('EliminarSuscripcionModalController', ['$scope', '$modal', '$rootScope','$http', 'toaster','$timeout','$state', function ($scope, $modal, $rootScope, $http, toaster,$timeout,$state) {
	var id;
	
	$scope.open = function (pid) {
		id = pid;
	var modalInstance = $modal.open({
		templateUrl: '/modalEliminarSuscripcion.html',
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
	
	
  	var ModalInstanceCtrl = function ($scope, $modalInstance) {
	
	    $scope.ok = function () {
	        $http.post('rest/suscripcion/delete', id).
	        success(function(){
	        	var toasterdata = {
			            type:  'success',
			            title: 'Suscripcion',
			            text:  'Se eliminó las suscripcion.'
			    };                
	        	toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	        	$timeout(function(){ $scope.callAtTimeout(); }, 1000);
	        });
	    	$modalInstance.close('closed');
	    };
	    $scope.pop = function(toasterdata) {
	        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	    };
	
	    $scope.callAtTimeout = function(){	
	    	$state.reload();	
	    }
	    $scope.cancelar = function () {
	    	$modalInstance.dismiss('cancelar');
	    };
	    
	  };
	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"]; 

}]);
