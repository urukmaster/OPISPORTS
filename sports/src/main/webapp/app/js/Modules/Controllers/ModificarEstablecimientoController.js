App.controller('ModificarEstablecimientoController', ['$scope', '$http', '$stateParams', function($scope, $http, $stateParams) {

	$scope.init = function(){
		$http.post('rest/establecimientoDeportivo/getEstablecimiento', $stateParams.id)
		.success(function(response) {
			
            $scope.Establecimiento = response.establecimientoDeportivo;
            
            
		});		

	    $http.get('rest/provincia/getAll')
		.success(function(response) {
			$scope.Provincias = response.provincias;
			
		});
    };
   
    $scope.init();
    
    $scope.buscarCantones = function(provincia){
        $scope.Cantones = provincia.listaCantones;
    };
    
    $scope.buscarDistritos = function(canton){
        $scope.Distritos = canton.listaDistritos;
    };
    
    
    
App.controller('ModificarEstablecimientosFormController', ['$scope','$http', '$stateParams','$state','toaster','$timeout','$route', function($scope,$http, $stateParams,$state,toaster,$timeout,$route) {
	'use strict'; 
    
  //validación
    $scope.submitted = false;
    $scope.validateInput = function(name, type) {
        var input = $scope.formModificarEstablecimiento[name];
        return (input.$dirty || $scope.submitted) && input.$error[type];
    };
    // Submit form
    $scope.submitForm = function() {
        $scope.submitted = true;
        if ($scope.formModificarEstablecimiento.$valid) {
        	
        	console.log($scope.Establecimiento.idEstablecimientoDeportivo);
        	
        	$http.post('rest/establecimientoDeportivo/save', {
        		idEstablecimientoDeportivo : $scope.Establecimiento.idEstablecimientoDeportivo,
        		direccion : $scope.Establecimiento.direccion,
        		nombre : $scope.Establecimiento.nombre,
        		paginaWeb : $scope.Establecimiento.paginaWeb,
        		telefono : $scope.Establecimiento.telefono,
        		distrito : $scope.Provincias.idDistrito,
        		accion : "Modificar",
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
    	$state.go("app.establecimientos");
    }

}]);

}]);