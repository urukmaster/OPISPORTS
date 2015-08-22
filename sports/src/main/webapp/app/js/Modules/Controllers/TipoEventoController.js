	/**
 * Created by JuanManuel on 30/07/2015.
 */

App.controller('TiposEventosController', ['$scope','$rootScope','$http','toaster', function($scope,$rootScope,$http,toaster) {
	
       
    var data = [];
    $scope.gridTiposEventos = {	
    		paginationPageSizes: [],
			paginationPageSize: 7,
			enableFiltering: true,
        columnDefs: [
            {field: 'idTipoEvento', visible:false},
            {field: 'tipo', name: 'tipo', displayName: 'Tipo de Evento Deportivo'},
            {name: 'acciones', cellTemplate:
            '<div class="btn-group btn-group-justified" role="group" ng-controller="TipoEventoModalController">' +   			
            	'<div class="btn-group" role="group">'+
					'<button ng-click="modificar(row)" class="btn btn-sm btn-green" >' +
						'<span class="fa fa-pencil"></span>' +
					'</button>'+
				'</div>'+			
				'<div class="btn-group" role="group">'+
					'<button ng-click="eliminar(row)" class="btn btn-sm btn-warning" >' +
						'<span class="fa fa-trash"></span>' +
					'</button>'+
				'</div>'+			
			'</div>',width:120}
        ],
        data: data,
        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
        }
    };
    
    var aTipos = [];
    $http.get('rest/tipoEvento/getAll')
        .success(function(data) {
        	if(data.code = 200){
        	data.tiposEventos.forEach(
        			function(tipo,index){
        				var tipoView = {};
        				tipoView = {
        						idTipoEvento: tipo.idTipoEvento,
        						tipo: tipo.tipo,
        						active: tipo.active
        				}
        				
        				if(tipoView.active == 0){
        					
        				}else{
        					aTipos.push(tipoView);
        				}
        			}
        			
        	);
        	$scope.gridTiposEventos.data = aTipos;
        	}else{
        		$rootScope.errorMessage = data.codeMessage;
        		$state.go('page.error');
        	}
        });
    
    $scope.$on('actualizarGrid', function (event, responsedata) {
    	$scope.gridTiposEventos.data = responsedata.newGrid;   	
    	
    });
    
}]);

/**==========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion de Usuario
 ============================================================*/
var tipoModificar = {};
App.controller('TipoEventoModalController', ['$rootScope','$scope', '$modal','$http','toaster',function ($rootScope,$scope, $modal,$http,toaster) {

    $scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myTipoEventoModalContent.html',
            controller: RegistrarTipoEventoInstanceCtrl,
            size: 'lg'
        });


    };
    
    $scope.modificar = function ($row) {
    	tipoModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
        	templateUrl: '/myTipoEventoModalContent.html',
        	controller: ModificarTipoEventoInstanceCtrl,
            size: 'lg'
        });


    };
    
    $scope.eliminar = function ($row) {
    	tipoModificar = $row.entity;
    	var modalInstance = $modal.open({
			templateUrl: '/modalEliminarTipoEvento.html',
			controller: EliminarTipoEventoInstanceCtrl,
			size: 'sm'
		});
		var state = $('#modal-state');
		modalInstance.result.then(function () {
		  state.text('Modal dismissed with OK status');
		}, function () {
		  state.text('Modal dismissed with Cancel status');
		});  	  
     
    };
    
   
    
    


    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var RegistrarTipoEventoInstanceCtrl = function ($scope, $modalInstance,$http) {
    	'use strict'; 
    	//validación
    	$scope.accion = 'Registrar';
        $scope.submitted = false;
        $scope.validateInput = function(name, type) {
            var input = $scope.formTipoEvento[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
    	
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;
            if ($scope.formTipoEvento.$valid) {
            	$http.post('rest/tipoEvento/save', {
            		tipo : $scope.tipoEvento.nombre
        		 	})
        		.success(function(data){
        			if(data.code == 200){
        			var aTipos = [];
        			data.tiposEventos.forEach(
                			function(tipo,index){
                				var tipoView = {};
                				tipoView = {
                						idTipoEvento: tipo.idTipoEvento,
                						tipo: tipo.tipo,
                						active: tipo.active
                				}
                				
                				if(tipoView.active == 0){        					
                				}else{
                					aTipos.push(tipoView);
                				}
                			}
                			
                	);
        			var responsedata = {
        		            type:  'success',
        		            title: 'Tipos de Eventos',
        		            text:  data.codeMessage,
        		            newGrid: aTipos
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
    RegistrarTipoEventoInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];
    
    var ModificarTipoEventoInstanceCtrl = function ($scope, $modalInstance,$http) {
    	'use strict'; 
    	//validación
    	$scope.tipoEvento = {};
    	$scope.accion = 'Modificar';
        $scope.submitted = false;
        $scope.validateInput = function(name, type) {
            var input = $scope.formTipoEvento[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
      //Carga el form
        $scope.tipoEvento.nombre = tipoModificar.tipo;
        
        
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;
            
            if ($scope.formTipoEvento.$valid) {
            	$http.post('rest/tipoEvento/update', {
            		idTipoEvento : tipoModificar.idTipoEvento,
            		tipo : $scope.tipoEvento.nombre,
            		active: tipoModificar.active
        		 	})
        		.success(function(data){
        			if(data.code = 200){
        			var aTipos = [];
        			data.tiposEventos.forEach(
                			function(tipo,index){
                				var tipoView = {};
                				tipoView = {
                						idTipoEvento: tipo.idTipoEvento,
                						tipo: tipo.tipo,
                						active: tipo.active
                				}
                				
                				if(tipoView.active == 0){        					
                				}else{
                					aTipos.push(tipoView);
                				}
                			}
                			
                	);
        			
        			var responsedata = {
        		            type:  'success',
        		            title: 'Tipos de Eventos',
        		            text:  data.codeMessage,
        		            newGrid: aTipos
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
    ModificarTipoEventoInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];
    
    var EliminarTipoEventoInstanceCtrl = function ($scope, $modalInstance,$http) {
    	
    	$scope.ok = function () {
    		
    		$http.post('rest/tipoEvento/delete', {
        		idTipoEvento : tipoModificar.idTipoEvento,
        		tipo : tipoModificar.tipo
    		 	})
    		.success(function(data){
    			if(data.code == 200){
    			var aTipos = [];			
    			data.tiposEventos.forEach(
            			function(tipo,index){
            				var tipoView = {};
            				tipoView = {
            						idTipoEvento: tipo.idTipoEvento,
            						tipo: tipo.tipo,
            						active: tipo.active
            				}
            				
            				if(tipoView.active == 0){        					
            				}else{
            					aTipos.push(tipoView);
            				}
            			}
            			
            	);
    			
    			var responsedata = {
    		            type:  'success',
    		            title: 'Tipo de Evento',
    		            text:  data.codeMessage,
    		            newGrid: aTipos
    		        	};
    			toaster.pop(responsedata.type, responsedata.title, responsedata.text);
    			$rootScope.$broadcast('actualizarGrid',responsedata);
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
    EliminarTipoEventoInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];

}]);