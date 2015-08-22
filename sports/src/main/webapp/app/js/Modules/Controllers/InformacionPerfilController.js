/**==========================================================
 * Modulo: EstablecimientosController
 * Este controlador se encarga de carga cada uno de los establecimientos
 * deportivos registrados y de inicializar la página
 ============================================================*/
var establecimientoCalendario = {};
App.controller('EstablecimientosController', ['$scope','$rootScope','$http', '$stateParams', 'toaster', '$timeout', '$state', function($scope,$rootScope,$http, $stateParams, toaster, $timeout, $state) {

	//Trae los establecimientos deportivos registrados
    $scope.init = function(){
	    $http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			if(response.code == 200){
			$scope.Establecimientos = response.establecimientosDeportivos;
			}else{
        		$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
        	}
			
		});
    };
    
    //Inicializa la aplicación
    $scope.init(); 
    
    //Validar usuario
    $scope.validarUsuarioId = function(establecimiento){	
		
		if(angular.equals({},$rootScope.usuario)){
			return false;
		}else{			
				if(establecimiento.idUsuario == $rootScope.usuario.idUsuario){
						return true;
				}						
		}
		
	};
	
	$scope.validarUsuarioRol = function(){	
		
		if(angular.equals({},$rootScope.usuario)){
			return false;
		}else{	
			for(i=0;i<$rootScope.usuario.roles.length;i++){				
					if($rootScope.usuario.roles[i].rol == "Administrador"){
						return true;
					}
					if($rootScope.usuario.roles[i].rol == "Administrador Establecimiento"){
						return true;
					}
					if($rootScope.usuario.roles[i].rol == "Usuario Cliente"){
						return false;
					}
				
			}					
		}
		
	};
	
    
    

    //Recibe la llamada del broadcast de eliminar para refrescar la página
    $scope.$on('eliminar', function (event) {
    	$scope.init(); 
    });
}]);   



App.controller('InformacionPerfilController', ['$scope', '$rootScope','$http', '$stateParams', '$state', function($scope, $rootScope,$http, $stateParams,$state) {

       
	$scope.init = function(){
		
		$http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			if(response.code == 200){
			var establecimientos = response.establecimientosDeportivos;
			for (var i = 0; i < establecimientos.length; i++) {
                if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                    $scope.establecimiento = establecimientos[i];
                    establecimientoCalendario = establecimientos[i];
                    console.log(establecimientoCalendario);
                    $scope.Reviews = establecimientos[i].reviews;
                }
            }
			}else{
        		$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
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

    //Validar usuario
    $scope.validarUsuarioId = function(establecimiento){	
		
		if(angular.equals({},$rootScope.usuario)){
			return false;
		}else{	
				
				if(establecimiento.idUsuario == $rootScope.usuario.idUsuario){
						return true;
				}						
		}
		
	}; 
}]);

App.controller('EstablecimientosFormController', ['$scope','$http', '$stateParams','$state','toaster','$timeout','$route','$rootScope', function($scope,$http, $stateParams,$state,toaster,$timeout,$route,$rootScope) {

	$scope.init = function(){
		$http.get('rest/provincia/getAll')
		.success(function(response) {
			$scope.Provincias = response.provincias;
			

		});	    
    };
    $scope.init();
	
    $scope.buscarCantones = function(){
    	angular.forEach($scope.Provincias, function(provincia, index){
    		if(provincia.idProvincia == $scope.idProvincia){
    			$scope.Cantones = provincia.listaCantones;
    		}
    	});
    };
    
    //Busca el distrito asociado al cantón escogido
    $scope.buscarDistritos = function(){
    	angular.forEach($scope.Cantones, function(canton, index){
    		if($scope.idCanton == canton.idCanton){
    			$scope.Distritos = canton.listaDistritos;
    		};
    	});
    };
    

    
    $scope.eliminar = function(id) {
    	$http.post('rest/review/delete', {
    		idComentario : id
		 	})
		.success(function(data){
			if(data.code == 200){
			$state.reload();
			}else{
        		$rootScope.errorMessage = data.codeMessage;
        		$state.go('page.error');
        	}
		});        	
  	}
    

	//Método que redirecciona a la página de reporte de retos
	$scope.consultarRetos = function(pidEstablecimiento){
        $state.go('app.reporteRetos',{id: pidEstablecimiento});
	}

 

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
        		idDistrito : $scope.idDistrito,
        		accion : "Registrar",
        		idUsuario : $rootScope.usuario.idUsuario
    		 	})
    		.success(function(data){
    			if(data.code = 200){
    			var toasterdata = {
    			            type:  'success',
    			            title: 'Establecimiento',
    			            text:  data.codeMessage
    			        	};
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    			}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
    			
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
App.controller('FormReviewController', ['$scope', '$http', '$stateParams','$state','toaster','$timeout','$route','$rootScope', function($scope,$http, $stateParams,$state,toaster,$timeout,$route,$rootScope) {
	'use strict'; 
//	$scope.submitted = false;
//    
//    $scope.validateInput = function(name, type) {
//        var input = $scope.formCentroDistribucion[name];
//        return (input.$dirty || $scope.submitted) && input.$error[type];
//    };
    
    // Submit form
//    $scope.submitForm = function() {
//        $scope.submitted = true;
//        if ($scope.formCentroDistribucion.$valid) {
	$scope.registrarReview = function() {
        	$http.post('rest/review/save', {
        		review : $scope.comentario,	
        		idUsuario : $rootScope.usuario.idUsuario,
        		idEstablecimientoDeportivo : establecimientoCalendario.idEstablecimientoDeportivo,
        		active : 1
    		 	})
    		.success(function(data){
    			if(data.code == 200){
    			$state.reload();
    			}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
    		});        	
//        } else {
//        	
//            return false;
//        }
//    };   	
	}
}]);

/**==========================================================
 * Modulo: EliminarModalController
 * Este controlador se encarga de eliminar un establecimiento deportivo
 ============================================================*/

App.controller('EliminarModalController', ['$scope', '$rootScope','$modal','$http', 'toaster', function ($scope, $rootScope,$modal, $http, toaster) {
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
	
	
  	var ModalInstanceCtrl = function ($scope, $modalInstance, $rootScope) {
	
	    $scope.ok = function () {
	    	
	        $http.post('rest/establecimientoDeportivo/delete', id).
	        success(function(data){
	        	if(data.code == 200){
	        	var toasterdata = {
			            type:  'success',
			            title: 'Establecimiento',
			            text:  'Se eliminó el establecimiento.'
			    };                
	        	toaster.pop(toasterdata);
	        	}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
	        });
	    	$modalInstance.close('closed');
			$rootScope.$broadcast('eliminar');
	    };
	    $scope.pop = function(toasterdata) {
	        toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
	    };
	    
  	};
	
	$scope.cancel = function () {
    	$modalInstance.dismiss('cancel');
	};	
  	
  	ModalInstanceCtrl.$inject = ["$scope", '$rootScope',"$modalInstance"]; 

}]);
var reviewEliminar = {};
App.controller('EliminarComentario', ['$scope', '$modal', '$rootScope','$http', 'toaster','$state', function ($scope, $modal, $rootScope, $http, toaster,$state) {
	//Validar usuario
    $scope.validarUsuarioId = function(review){		
		if(angular.equals({},$rootScope.usuario)){
			return false;
		}else{	
			if(review.idUsuario == $rootScope.usuario.idUsuario){
				return true;
			}						
		}
	};
	
    $scope.eliminar = function(pid){
    	reviewEliminar = pid;
    	var modalInstance = $modal.open({
    		templateUrl: '/modalEliminarReview.html',
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
    	$http.post('rest/review/delete', {
    		idComentario : reviewEliminar
    		 	})
    		.success(function(data){
    			$modalInstance.close('closed'); 
    			$state.reload();
    		});        	
    };
    
    $scope.cancel = function () {
  	  $modalInstance.dismiss('cancel');
  	    };
	
	};
	  
	 ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"];
	
}]);
