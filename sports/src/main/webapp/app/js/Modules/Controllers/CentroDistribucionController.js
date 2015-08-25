/**=========================================================
 * Module: Distribucion
 =========================================================*/

App.controller('CentroDistribucionController', ['$scope', '$rootScope','uiGridConstants', '$http', function($scope, $rootScope,uiGridConstants, $http) {

	var data = [];
	gridDistribucion = $scope.gridDistribucion = {
			paginationPageSizes: [],
			paginationPageSize: 7,
			columnDefs: [
			{ field: 'idCentroDistribucion', visible:false},
			{ field: 'nombre', name:"Nombre"},
			{ field: 'direccion' , name:'Dirección'},
			{ field: 'telefono' , name:'Teléfono'},
			{ field: 'correo' , name:'Correo'},
			{ field: 'active', visible:false},
			{name: 'acciones', cellTemplate:
				
			'<div class="btn-group btn-group-justified" role="group">' +
			
				'<div class="btn-group" role="group" ng-controller="DistribucionModalController" >'+
					'<button ng-click="modificar(row)" class="btn btn-green" >' +
						'<span class="fa fa-pencil"></span>' +
						'</button>'+
				'</div>'+
				'<div class="btn-group" role="group" ng-controller="EliminarModalController">'+
					'<button ng-click="eliminar(row)" class="btn btn-warning" >' +
						'<span class="fa fa-trash"></span>' +
					'</button>'+
				'</div>'+
			
			'</div>',width:120}
			],data: data,
				onRegisterApi: function (gridApi) {
					$scope.gridApi = gridApi;
			    }
			};
			var ACentros  = [];
			$http.get('rest/centroDistribucion/getAll')
				.success(function(data) {
					if(data.code == 200){
					data.centrosDistribucion.forEach( function(centro, index) {
						var centroView = {};
						centroView.idCentroDistribucion = centro.idCentroDistribucion;
						centroView.nombre = centro.nombre;
						centroView.direccion = centro.direccion;
						centroView.telefono = centro.telefono;
						centroView.correo = centro.correo;
						centroView.active = centro.active;
						ACentros.push(centroView);	
			        });
			            $scope.gridDistribucion.data = ACentros;  
					}else{
                		$rootScope.errorMessage = data.codeMessage;
                		$state.go('page.error');
                	}
			});
			$scope.$on('actualizarGrid', function (event, responsedata) {
		    	$scope.gridDistribucion.data = responsedata.newGrid;   	
		    	
		    });
}]);

/**=========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion
 =========================================================*/
var distribucionModificar = {};
App.controller('DistribucionModalController', ['$rootScope','$scope', '$modal','$http','toaster',function ($rootScope,$scope, $modal,$http,toaster) {

	$scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myDistribucionModalContent.html',
            controller: RegistrarDistribucionInstanceCtrl,
            size: 'lg'
        });
    };
//-------------------------------------------------------------------------------------------------------
    $scope.modificar = function ($row) {
        distribucionModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myDistribucionModalContent.html',
            controller: ModificarDistribucionInstanceCtrl,
            size: 'lg'
        });

    };

//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    
    var RegistrarDistribucionInstanceCtrl = function ($scope, $rootScope,$modalInstance,$http) {
    	'use strict'; 
    	//validación
    	$scope.accion = 'Registrar';
        $scope.submitted = false;
        
        $scope.validateInput = function(name, type) {
            var input = $scope.formCentroDistribucion[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;
            if ($scope.formCentroDistribucion.$valid) {
            	$http.post('rest/centroDistribucion/save', {
            		nombre : $scope.nombre,
            		direccion : $scope.direccion,
            		telefono: $scope.telefono,
            		correo : $scope.correo
        		 	})
        		.success(function(data){
        			if(data.code == 200){
        			var ACentros = [];
					data.centrosDistribucion.forEach( function(centro, index) {
						var centroView = {};
						centroView.idCentroDistribucion = centro.idCentroDistribucion;
						centroView.nombre = centro.nombre;
						centroView.direccion = centro.direccion;
						centroView.telefono = centro.telefono;
						centroView.correo = centro.correo;
						centroView.active = centro.active;
						ACentros.push(centroView);	
			        });
        			var responsedata = {
        		            type:  'success',
        		            title: 'Centros de distribucion',
        		            text:  data.codeMessage,
        		            newGrid: ACentros
        		        	};
        			toaster.pop(responsedata.type, responsedata.title, responsedata.text);
        			$rootScope.$broadcast('actualizarGrid',responsedata);
        			$modalInstance.close('closed');
        		}else {
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
        		});        	
            	
            } else {
            	
                return false;
            }
        };
    	
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

    };
    RegistrarDistribucionInstanceCtrl.$inject = ["$scope", '$rootScope',"$modalInstance","$http"];

//---------------------------------------------------------------------------------------
    var ModificarDistribucionInstanceCtrl = function ($scope, $rootScope,$modalInstance,$http) {
        $scope.accion = "Modificar";
        $scope.reto = {};
        
        $scope.nombre = distribucionModificar.nombre;
        $scope.direccion = distribucionModificar.direccion;
        $scope.telefono = distribucionModificar.telefono;
        $scope.correo = distribucionModificar.correo;
        
        $scope.validateInput = function(name, type) {
            var input = $scope.formCentroDistribucion[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
        
        $scope.submitForm = function () {
        	$scope.submitted = true;
        	if ($scope.formCentroDistribucion.$valid) {
                $http.post('rest/centroDistribucion/update',{
                	idCentroDistribucion: distribucionModificar.idCentroDistribucion,
                	nombre : $scope.nombre,
            		direccion : $scope.direccion,
            		telefono: $scope.telefono,
            		correo : $scope.correo
                })
                .success(function(data){
                	if(data.code = 200){
                	var ACentros = [];
                	data.centrosDistribucion.forEach( function(centro, index) {
                		var centroView = {};
						centroView.idCentroDistribucion = centro.idCentroDistribucion;
						centroView.nombre = centro.nombre;
						centroView.direccion = centro.direccion;
						centroView.telefono = centro.telefono;
						centroView.correo = centro.correo;
						centroView.active = centro.active;
						ACentros.push(centroView);	
   						
   			     });                 
   				 var responsedata = {
   				              type:  'success',
   				              title: 'Centro distribucion',
   				              text:  data.codeMessage,
   				              newGrid: ACentros
   				  }; 
   				   toaster.pop(responsedata.type, responsedata.title, responsedata.text);
   				   $rootScope.$broadcast('actualizarGrid',responsedata);	
        		   $modalInstance.close('closed');  
                	}else{
                		$rootScope.errorMessage = data.codeMessage;
                		$state.go('page.error');
                	}
        		});   
        } else {
            return false;
        }
         
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarDistribucionInstanceCtrl.$inject = ["$scope", '$rootScope',"$modalInstance","$http"];

}]);
var centroEliminar = {};
App.controller('EliminarModalController', ['$rootScope','$scope', '$modal','$http','toaster',function ($rootScope,$scope, $modal,$http,toaster) {

	$scope.eliminar = function ($row) {
			centroEliminar = $row.entity;
			var modalInstance = $modal.open({
				templateUrl: '/modalEliminarCentro.html',
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
	
	
  	var ModalInstanceCtrl = function ($scope, $rootScope,$modalInstance,$http) {
	
	    $scope.ok = function () {
            $http.post('rest/centroDistribucion/delete',{
            	idCentroDistribucion: centroEliminar.idCentroDistribucion,
            	nombre : centroEliminar.nombre,
        		direccion : centroEliminar.direccion,
        		telefono: centroEliminar.telefono,
        		correo : centroEliminar.correo
            })
            .success(function(data){
            	if(data.code == 200){
            	var ACentros = [];
            	data.centrosDistribucion.forEach( function(centro, index) {
            		var centroView = {};
					centroView.idCentroDistribucion = centro.idCentroDistribucion;
					centroView.nombre = centro.nombre;
					centroView.direccion = centro.direccion;
					centroView.telefono = centro.telefono;
					centroView.correo = centro.correo;
					centroView.active = centro.active;
					ACentros.push(centroView);	
						
			     });                 
				 var responsedata = {
				              type:  'success',
				              title: 'Centro distibucion',
				              text:  data.codeMessage,
				              newGrid: ACentros
				  }; 
				   toaster.pop(responsedata.type, responsedata.title, responsedata.text);
				   $rootScope.$broadcast('actualizarGrid',responsedata);	
				   $modalInstance.close('closed');  
            	}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
    		});   
	    };
	    
	    
	     
	$scope.cancel = function () {
	  $modalInstance.dismiss('cancel');
	};
	
	};
	  
	  ModalInstanceCtrl.$inject = ["$scope", '$rootScope',"$modalInstance","$http"];
}]);