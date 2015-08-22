/**
 * Modulo Controlador para traer los datos del modificar evento * 
 * author: Mauricio Fernandez
 * Fecha: 02/08/2015
 * Revision: 1.1 
 */

/**==========================================================
 * Modulo: ModificarEstablecimientoController
 * Este controlador se encarga de consultar y modificar la 
 * información de un establecimiento deportivo.
 ============================================================*/

App.controller('ModificarEstablecimientoController', ['$scope', '$rootScope','$http', '$stateParams', 'toaster','$timeout', '$state', function($scope, $rootScope,$http, $stateParams, toaster, $timeout, $state) {
	var provinciaActual;
	var cantonActual;
	var distritoActual;
	
	//Trae un establecimiento deportivo por Id
	$scope.init = function(){
		$http.post('rest/establecimientoDeportivo/getEstablecimiento', $stateParams.id)
		.success(function(response) {
			if(response.code ==200){
            $scope.Establecimiento = response.establecimientoDeportivo;
            provinciaActual = response.idProvincia;
            cantonActual = response.idCanton;
            distritoActual = response.establecimientoDeportivo.distrito.idDistrito;
			}else{
        		$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
        	}
		});		
		
		//Trae las provinciar registradas
		$http.get('rest/provincia/getAll')
		.success(function(response) {
			if(response.code = 200){
			$scope.Provincias = response.provincias;
			angular.forEach($scope.Provincias, function(provincia, index){
				if(provincia.idProvincia == provinciaActual){
					$scope.idProvincia = provincia.idProvincia;
					$scope.cargarCantones(provincia);
				}
			});
			//Busca el cantón asociado a la provincia escogida
		    $scope.buscarCantones = function(){
		    	angular.forEach($scope.Provincias, function(provincia, index){
		    		if(provincia.idProvincia == $scope.idProvincia){
		    			$scope.Cantones = provincia.listaCantones;
		    		}
		    	});
		    };
			}else{
        		$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
        	}
		});	    
	    
    };
    
    //Inicializa la página
    $scope.init();
    
    //Busca el distrito asociado al cantón escogido
    $scope.buscarDistritos = function(){
    	angular.forEach($scope.Cantones, function(canton, index){
    		if($scope.idCanton == canton.idCanton){
    			$scope.Distritos = canton.listaDistritos;
    		};
    	});
        
    };
    
    //Carga los cantones asociados a la provincia escogida
    $scope.cargarCantones = function(provincia){
        $scope.Cantones = provincia.listaCantones;
        
		angular.forEach($scope.Cantones, function(canton, index){
			if(canton.idCanton == cantonActual){
				$scope.idCanton = canton.idCanton;
				$scope.buscarDistritos(canton);				
			}
		})
    };
    
    //Carga los distritos asociados al cantón escogido
    $scope.cargarDistritos = function(distrito){
        $scope.Distritos = canton.listaDistritos;
        
		angular.forEach($scope.Distritos, function(distrito, index){
			if(distrito.idDistrito == distritoActual){
				$scope.idDistrito = distrito.idDistrito;			
			}
		})
    };
	
    //Valida el formulario de modificación
      $scope.submitted = false;
      $scope.validateInput = function(name, type) {
          var input = $scope.formModificarEstablecimiento[name];
          return (input.$dirty || $scope.submitted) && input.$error[type];
      };
      
      //Envío del formulario
      $scope.submitForm = function() {
          $scope.submitted = true;
          if ($scope.formModificarEstablecimiento.$valid) {
          	
          	$http.post('rest/establecimientoDeportivo/save', {
          		idEstablecimientoDeportivo : $scope.Establecimiento.idEstablecimientoDeportivo,
          		direccion : $scope.Establecimiento.direccion,
          		nombre : $scope.Establecimiento.nombre,
          		paginaWeb : $scope.Establecimiento.paginaWeb,
          		telefono : $scope.Establecimiento.telefono,
          		idDistrito : $scope.Establecimiento.distrito.idDistrito,
          		accion : "Modificar",
          		idUsuario : $rootScope.usuario.idUsuario
      		 	})
      		 	
      		.success(function(data){
      			if(data.code == 200){
      			var toasterdata = {
      			            type:  'success',
      			            title: 'Establecimiento',
      			            text:  'Se modificó satisfactoriamente'
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
      
      //Despliegue de confirmación    
      $scope.pop = function(toasterdata) {
          toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
      };
      
      $scope.callAtTimeout = function(){
      	$state.go("app.establecimientos");
      }
    
}]);