 /**
 * Modulo Controlador para calendario
 * author: Luis Esteban López Ramírez
 * Fecha: 8/07/2015
 * Revision: 1.0

 */


/**==========================================================
 * Modulo: CalendarController
 * Este controlador se encarga de renderizar e inicializar el
 * calendario
 ============================================================*/
App.controller('SuscripcionController', [ '$rootScope','$scope', '$http', function($rootScope, $scope, $http) {
	 	

	$scope.Suscripciones = $rootScope.usuario.subscripciones;

}]);

App.controller('EliminarSuscripcionModalController', ['$scope', '$modal', '$rootScope','$http', 'toaster', function ($scope, $modal, $rootScope, $http, toaster) {
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
	        });
	    	$modalInstance.close('closed');
	    };
	    $scope.pop = function(toasterdata) {
	        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	    };
	
	$scope.cancelar = function () {
	  $modalInstance.dismiss('cancelar');
	    };
	  };
	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"]; 

}]);
