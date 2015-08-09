/**
 * Created by JuanManuel on 09/07/2015.
 * 
 * Modulo Controlador para modificar evento 
 * author: Mauricio Fernandez
 * Fecha: 04/08/2015
 * Revision: 1.1 
 */

App.controller('EstablecimientosController', ['$scope','$http', '$stateParams', '$rootScope', 'toaster', '$timeout', '$state', function($scope,$http, $stateParams, $rootScope, toaster, $timeout, $state) {

    $scope.init = function(){  	
	    $http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			$scope.Establecimientos = response.establecimientosDeportivos;
			
		});
    };
    $scope.init(); 
    
    $scope.buscarServicios = function(establecimiento){
    	cambiarServicios(establecimiento);
    };
    
    function cambiarServicios(establecimiento) {
        $scope.serviciosEstablecimiento = establecimiento.servicios;
    }
    

    $scope.$on('eliminar', function (event) {
        $scope.init(); 
    });
	
}]);   

var tipoServicios = [];


App.controller('InformacionPerfilController', ['$scope', '$http', '$stateParams', '$state', function($scope, $http, $stateParams,$state) {
       
	$scope.init = function(){
		
		$http.get('rest/tipoServicio/getAll')
	    .success(function(data) {
	    	tipoServicios = data.tipoServicio;
	    });
		
		$http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			var establecimientos = response.establecimientosDeportivos;
			for (var i = 0; i < establecimientos.length; i++) {
                if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                    $scope.establecimiento = establecimientos[i];
                    establecimientoCalendario = establecimientos[i];
                    $scope.Reviews = establecimientos[i].reviews;
                }
            }
		});
    };
    
    
    $scope.init();
    $state.go("app.perfil.informacion");
    
    
    $scope.mostrarReservaciones = function() {

    	$state.go("app.perfil.reservaciones");
	}

    $scope.mostrarInformacion = function(){
		$state.go("app.perfil.informacion");
	}
			
	$scope.mostrarServicios = function(){
		$state.go("app.perfil.servicios");
	}

    $scope.init();
    

}]);

App.controller('EstablecimientosFormController', ['$scope','$http', '$stateParams','$state','toaster','$timeout','$route', function($scope,$http, $stateParams,$state,toaster,$timeout,$route) {
	'use strict'; 
	//validación
    $scope.submitted = false;
    $scope.validateInput = function(name, type) {
        var input = $scope.formEstablecimiento[name];
        return (input.$dirty || $scope.submitted) && input.$error[type];
    };
    // Submit form
    $scope.submitForm = function() {
        $scope.submitted = true;
        if ($scope.formEstablecimiento.$valid) {        	
        	$http.post('rest/establecimientoDeportivo/save', {
        		direccion : $scope.establecimiento.direccion,
        		nombre : $scope.establecimiento.nombre,
        		paginaWeb : $scope.establecimiento.paginaWeb,
        		telefono : $scope.establecimiento.telefono,
        		idUsuario : 1
    		 	})
    		.success(function(data){
    			var toasterdata = {
    			            type:  'success',
    			            title: 'Establecimiento',
    			            text:  data.codeMessage
    			        	};
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    			
    		});        	
        	
        } else {
        	var toasterdata = {
		            type:  'error',
		            title: 'Establecimiento',
		            text:  data.errorMessage
		        	};
        	$scope.pop(toasterdata);
            return false;
        }
    };
    //notificacion
   
    
    $scope.pop = function(toasterdata) {
        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
    };
    
    $scope.callAtTimeout = function(){
    	$state.go("app.index");
    }

}]);

App.controller('EliminarModalController', ['$scope', '$modal', '$rootScope','$http', 'toaster', function ($scope, $modal, $rootScope, $http, toaster) {
	var id;
	
	$scope.open = function (pid) {
		id = pid;
	var modalInstance = $modal.open({
		templateUrl: '/modalEliminarEstablecimiento.html',
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
	    	
	        $http.post('rest/establecimientoDeportivo/delete', id).
	        success(function(){
	        	var toasterdata = {
			            type:  'success',
			            title: 'Establecimiento',
			            text:  'Se eliminó el establecimiento.'
			    };                
	        	toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	        });
			$rootScope.$broadcast('eliminar');
	    	$modalInstance.close('closed');
	    };
	    $scope.pop = function(toasterdata) {
	        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	    };
	
	$scope.cancel = function () {
	  $modalInstance.dismiss('cancel');
	    };
	  };
	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"]; 

}]);
