/**
 * Created by JuanManuel on 30/07/2015.
 */

App.controller('TiposEventosController', ['$scope','$http','toaster', function($scope,$http,toaster) {
	
       
    var data = [];
    $scope.gridTiposEventos = {	
        columnDefs: [
            {field: 'idTipoEvento', visible:false},
            {field: 'tipo', name: 'tipo', displayName: 'Tipo de Evento Deportivo'},
            {name: 'acciones', cellTemplate:
            '<div class="btn-group btn-group-justified" role="group" ng-controller="TipoEventoModalController">' +   			
            	'<div class="btn-group" role="group">'+
					'<button ng-click="modificar(row)" class="btn btn-sm btn-warning" >' +
						'<span class="fa fa-pencil"></span>' +
					'</button>'+
				'</div>'+			
				'<div class="btn-group" role="group">'+
					'<button ng-click="eliminar(row)" class="btn btn-sm btn-danger" >' +
						'<span class="fa fa-trash"></span>' +
					'</button>'+
				'</div>'+			
			'</div>'}
        ],
        data: data,
        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
        }
    };
    
    var aTipos = [];
    $http.get('rest/tipoEvento/getAll')
        .success(function(data) {
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
    	$http.post('rest/tipoEvento/delete', {
    		idTipoEvento : tipoModificar.idTipoEvento,
    		tipo : tipoModificar.tipo
		 	})
		.success(function(data){
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
            $scope.submitted = false;
            alert("Validando");
            if ($scope.formTipoEvento.$valid) {
            	$http.post('rest/tipoEvento/save', {
            		tipo : $scope.tipoEvento.nombre
        		 	})
        		.success(function(data){
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
        			alert("Porque entro aqui?");
        			var responsedata = {
        		            type:  'success',
        		            title: 'Tipos de Eventos',
        		            text:  data.codeMessage,
        		            newGrid: aTipos
        		        	};
        			toaster.pop(responsedata.type, responsedata.title, responsedata.text);
        			$rootScope.$broadcast('actualizarGrid',responsedata);
        			$modalInstance.close('closed');       			
        		});        	
            	
            } else {
            	
                return false;
            }
        };
    	
        $scope.cancel = function () {
        	alert("Se cancelo");
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

}]);