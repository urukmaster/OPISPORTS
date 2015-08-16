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

App.controller('MisInscripcionesController', ['$scope', '$http', '$state','$rootScope', function($scope, $http, $state,$rootScope) {

	var listaInscripciones = [];
	$scope.init = function(){   	

    	$http.get('rest/inscripcion/getAll', {
		 	})
		.success(function(response){
	    	
	    	console.log(response);
			
	    	angular.forEach(response.inscripciones, function(inscripcion, index){
	    		if(inscripcion.usuario.idUsuario == $rootScope.usuario.idUsuario){
	    			listaInscripciones.push(inscripcion.listaTiquetes);
	    		}
	    	});

	    	$scope.Inscripciones = listaInscripciones;
			
		});
    	
    	console.log($scope.Inscripciones);
	}
	
    //Inicializa la página
    $scope.init();
    
}]);



/**==========================================================
 * Module: CancelarInscripcionModalController
 * Implementa el modal de cancelacion de una inscripcion
 ============================================================*/
App.controller('CancelarTiqueteModalController', ['$scope', '$modal', '$rootScope','$http', 'toaster','$state','$timeout', function ($scope, $modal, $rootScope, $http, toaster, $state, $timeout) {
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
	        	var toasterdata = {
			            type:  'success',
			            title: 'Tiquete',
			            text:  'Se canceló el tiquete.'
			    };
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
            	
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
	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"]; 

}]);