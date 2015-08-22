/**
 * Created by JuanManuel on 30/07/2015.
 */

App.controller('ActividadesDeportivasController', ['$scope','$rootScope','$http','toaster', function($scope,$rootScope,$http,toaster) {
	
       
    var data = [];
    $scope.gridActividadesDeportivas = {
    	paginationPageSizes: [],
		paginationPageSize: 7,
        columnDefs: [
            {field: 'idActividadDeportiva', visible:false},
            {field: 'actividadDeportiva', name: 'ActividadDeportiva', displayName: 'Actividad Deportiva'},
            {name: 'acciones', cellTemplate:
                '<div class="btn-group btn-group-justified" role="group" ng-controller="ActividadDeportivaModalController">' +   			
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
    
    var aActividades = [];
    $http.get('rest/actividadDeportiva/getAll')
        .success(function(data) {
        	if(data.code == 200){
        	data.actividadesDeportivas.forEach(
        			function(actividad,index){
        				var actividadView = {};
        				actividadView = {
        						idActividadDeportiva: actividad.idActividadDeportiva,
        						actividadDeportiva: actividad.actividadDeportiva,
        						active: actividad.active
        				}
        				
        				if(actividadView.active == 0){
        					
        				}else{
        					aActividades.push(actividadView);
        				}
        			}
        			
        	);
        	$scope.gridActividadesDeportivas.data = aActividades;
        	}else{
        		$rootScope.errorMessage = data.codeMessage;
        		$state.go('page.error');
        	}
        });
    
    $scope.$on('actualizarGrid', function (event, responsedata) {
    	$scope.gridActividadesDeportivas.data = responsedata.newGrid;   	
    	
    });
    
}]);

/**==========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion de Usuario
 ============================================================*/
var actividadModificar = {};
App.controller('ActividadDeportivaModalController', ['$rootScope','$scope', '$modal','$http','toaster',function ($rootScope,$scope, $modal,$http,toaster) {

    $scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myActividadDeportivaModalContent.html',
            controller: RegistrarActividadDeportivaInstanceCtrl,
            size: 'lg'
        });


    };
    
    $scope.modificar = function ($row) {
    	actividadModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
        	templateUrl: '/myActividadDeportivaModalContent.html',
        	controller: ModificarActividadDeportivaInstanceCtrl,
            size: 'lg'
        });


    };
    
    $scope.eliminar = function ($row) {
    	actividadModificar = $row.entity;
		var modalInstance = $modal.open({
			templateUrl: '/modalEliminarActividad.html',
			controller: EliminarActividadDeportivaInstanceCtrl,
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

    var RegistrarActividadDeportivaInstanceCtrl = function ($scope,$rootScope, $modalInstance,$http) {
    	'use strict'; 
    	//validación
    	$scope.accion = 'Registrar';
        $scope.submitted = false;
        $scope.validateInput = function(name, type) {
            var input = $scope.formActividadDeportiva[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
    	
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;
            
            if ($scope.formActividadDeportiva.$valid) {
            	$http.post('rest/actividadDeportiva/save', {
            		actividadDeportiva : $scope.actividadDeportiva.nombre
        		 	})
        		.success(function(data){
        			if(data.code = 200){
        			var aActividades = [];
        			data.actividadesDeportivas.forEach(
                			function(actividad,index){
                				var actividadView = {};
                				actividadView = {
                						idActividadDeportiva: actividad.idActividadDeportiva,
                						actividadDeportiva: actividad.actividadDeportiva,
                						active: actividad.active
                				}
                				
                				if(actividadView.active == 0){        					
                				}else{
                					aActividades.push(actividadView);
                				}
                			});
        			
        			var responsedata = {
        		            type:  'success',
        		            title: 'Actividad Deportiva',
        		            text:  data.codeMessage,
        		            newGrid: aActividades
        		        	};
        			toaster.pop(responsedata.type, responsedata.title, responsedata.text);
        			$rootScope.$broadcast('actualizarGrid',responsedata);
        			$modalInstance.close('closed');    
        			}else{
        				$rootScope.codeMessage = data.codeMessage;
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
    RegistrarActividadDeportivaInstanceCtrl.$inject = ["$scope", "$rootScope" ,"$modalInstance","$http"];
    
    var ModificarActividadDeportivaInstanceCtrl = function ($scope, $modalInstance,$http) {
    	'use strict'; 
    	//validación
    	$scope.actividadDeportiva = {};
    	$scope.accion = 'Modificar';
        $scope.submitted = false;
        $scope.validateInput = function(name, type) {
            var input = $scope.formActividadDeportiva[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
    	//Carga el form
        $scope.actividadDeportiva.nombre = actividadModificar.actividadDeportiva        
        
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;
            
            if ($scope.formActividadDeportiva.$valid) {
            	$http.post('rest/actividadDeportiva/update', {
            		idActividadDeportiva : actividadModificar.idActividadDeportiva,
            		actividadDeportiva : $scope.actividadDeportiva.nombre
        		 	})
        		.success(function(data){
        			if(data.code = 200){
        			var aActividades = [];
        			data.actividadesDeportivas.forEach(
                			function(actividad,index){
                				var actividadView = {};
                				actividadView = {
                						idActividadDeportiva: actividad.idActividadDeportiva,
                						actividadDeportiva: actividad.actividadDeportiva,
                						active: actividad.active
                				}
                				
                				if(actividadView.active == 0){        					
                				}else{
                					aActividades.push(actividadView);
                				}
                			}
                			
                	);
        			
        			var responsedata = {
        		            type:  'success',
        		            title: 'Actividad Deportiva',
        		            text:  data.codeMessage,
        		            newGrid: aActividades
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

    ModificarActividadDeportivaInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];
    
    var EliminarActividadDeportivaInstanceCtrl = function ($scope, $modalInstance,$http) {
      
        $scope.ok = function () {        
	        
        	$http.post('rest/actividadDeportiva/delete', {
        		idActividadDeportiva : actividadModificar.idActividadDeportiva,
        		actividadDeportiva : actividadModificar.actividadDeportiva
    		 	})
    		.success(function(data){
    			if(data.code = 200){
    			var aActividades = [];
    			
    			data.actividadesDeportivas.forEach(
            			function(actividad,index){
            				var actividadView = {};
            				actividadView = {
            						idActividadDeportiva: actividad.idActividadDeportiva,
            						actividadDeportiva: actividad.actividadDeportiva,
            						active: actividad.active
            				}
            				
            				if(actividadView.active == 0){        					
            				}else{
            					aActividades.push(actividadView);
            				}
            			}
            			
            	);
    			
    			var responsedata = {
    		            type:  'success',
    		            title: 'Actividad Deportiva',
    		            text:  data.codeMessage,
    		            newGrid: aActividades
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
    EliminarActividadDeportivaInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];

}]);