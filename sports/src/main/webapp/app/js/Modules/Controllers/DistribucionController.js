/**=========================================================
 * Module: Distribucion
 =========================================================*/

App.controller('DistribucionController', ['$scope', function($scope) {
	
	$scope.centros = eventoActual.distribuciones;
	
}]);

App.controller('DistribucionesController', ['$scope', function($scope) {
	$scope.init= function(){
		$scope.centros = eventoActual.distribuciones;
	};
	$scope.init();
	
}]);

/**=========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion
 =========================================================*/
var distribucionModificar = {};
App.controller('AsociarController', ['$scope', '$rootScope','toaster','$rootScope','$http','$state', function ($scope, $rootScope,toaster,$rootScope,$http,$state) {
	
		
    	$scope.init = function(){
    		$http.get('rest/centroDistribucion/getAll')
    		.success(function(response) {
    			if(response.code ==200){
                $scope.Centros = response.centrosDistribucion;
                $scope.idCentroDistribucion =1;
    			}else{
            		$rootScope.errorMessage = response.codeMessage;
            		$state.go('page.error');
            	}
    		});	
    	};

    	 $scope.init();
    	'use strict'; 
    	//validación
    	$scope.accion = 'Asociar';
        $scope.submitted = false;
        
        $scope.validateInput = function(name, type) {
            var input = $scope.formCentroDistribucion[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
        var is = false;
        
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;   
            if ($scope.formCentroDistribucion.$valid) {
            	
            	$http.post('rest/distribucion/save', {
            		idCentroDistribucion : $scope.idCentroDistribucion,
            		idEvento : eventoActual.idEvento
        		 	})
        		.success(function(data){
        			if(data.code == 200){        			
        			$state.reload();
        		}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
        			
        		});        	
            	
            } else {
            	
                return false;
            }
         
        };
}]);



//var centroEliminar = {};
//App.controller('EliminarModalController', ['$scope', '$rootScope','$modal', '$rootScope','$http', 'toaster', function ($scope, $modal, $rootScope, $http, toaster) {
//
//	$scope.eliminar = function ($row) {
//	centroEliminar = $row.entity;
//	var modalInstance = $modal.open({
//		templateUrl: '/modalEliminarCentro.html',
//		controller: ModalInstanceCtrl,
//		size: 'sm'
//	});
//	
//	var state = $('#modal-state');
//	modalInstance.result.then(function () {
//	  state.text('Modal dismissed with OK status');
//	}, function () {
//	  state.text('Modal dismissed with Cancel status');
//	    });
//	  };
//	
//	
//  	var ModalInstanceCtrl = function ($scope, $modalInstance) {
//	
//	    $scope.ok = function () {
//            $http.post('rest/centroDistribucion/delete',{
//            	idCentroDistribucion: centroEliminar.idCentroDistribucion,
//            	nombre : centroEliminar.nombre,
//        		direccion : centroEliminar.direccion,
//        		telefono: centroEliminar.telefono,
//        		correo : centroEliminar.correo
//            })
//            .success(function(data){
//            	if(data.code == 200){
//            	var ACentros = [];
//            	data.centrosDistribucion.forEach( function(centro, index) {
//            		var centroView = {};
//					centroView.idCentroDistribucion = centro.idCentroDistribucion;
//					centroView.nombre = centro.nombre;
//					centroView.direccion = centro.direccion;
//					centroView.telefono = centro.telefono;
//					centroView.correo = centro.correo;
//					centroView.active = centro.active;
//					ACentros.push(centroView);	
//						
//			     });                 
//				 var responsedata = {
//				              type:  'success',
//				              title: 'Centro distibucion',
//				              text:  data.codeMessage,
//				              newGrid: ACentros
//				  }; 
//				   toaster.pop(responsedata.type, responsedata.title, responsedata.text);
//				   $rootScope.$broadcast('actualizarGrid',responsedata);	
//				   $modalInstance.close('closed');  
//            	}else{
//            		$rootScope.errorMessage = data.codeMessage;
//            		$state.go('page.error');
//            	}
//    		});   
//	    };
//	    
//	    
//	     
//	$scope.cancel = function () {
//	  $modalInstance.dismiss('cancel');
//	    };
//	};
//	  
//	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"];
//}]);