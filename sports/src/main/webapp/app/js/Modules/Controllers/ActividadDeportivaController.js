/**
 * Created by JuanManuel on 30/07/2015.
 */

App.controller('ActividadesDeportivasController', ['$scope','$http', function($scope,$http, $stateParams) {
	
       
    var data = [];
    $scope.gridActividadesDeportivas = {
        columnDefs: [
            {field: 'idActividadDeportiva', visible:false},
            {field: 'actividadDeportiva', name: 'ActividadDeportiva', displayName: 'Actividad Deportiva'},
            {name: 'acciones', cellTemplate:'<div ng-controller="ActividadDeportivaModalController" >' +
            '<button ng-click="modificar(row)" class="btn btn-primary" >' +
            '<span class="fa fa-rocket"></span>' +
            '</button>'+
            '</div>'}
        ],
        data: data,
        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
        }
    };
    
    $http.get('rest/actividadDeportiva/getAll')
        .success(function(data) {
            data.actividadesDeportivas.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });
            $scope.gridActividadesDeportivas.data = data.actividadesDeportivas;
        });
    
}]);

/**==========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion de Usuario
 ============================================================*/
var actividadModificar = {};
App.controller('ActividadDeportivaModalController', ['$scope', '$modal',function ($scope, $modal) {

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


    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var RegistrarActividadDeportivaInstanceCtrl = function ($scope, $modalInstance,$http) {
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
            	alert($scope.actividadDeportiva.nombre);
            	alert("Funciono?");
            	$http.post('rest/actividadDeportiva/save', {
            		actividadDeportiva : $scope.actividadDeportiva.nombre
        		 	})
        		.success(function(data){
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
    RegistrarActividadDeportivaInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];
    
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
            	alert($scope.actividadDeportiva.nombre);
            	alert("Funciono?");
            	$http.post('rest/actividadDeportiva/update', {
            		idActividadDeportiva : actividadModificar.idActividadDeportiva,
            		actividadDeportiva : $scope.actividadDeportiva.nombre
        		 	})
        		.success(function(data){
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
    ModificarActividadDeportivaInstanceCtrl.$inject = ["$scope", "$modalInstance","$http"];

}]);