/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *Sprint #4 Descripción: Controlador para gestionar los servicios
 */


var gridServicio = {};
var servicios;

App.controller('ServicioController', ['$scope', '$rootScope','uiGridConstants', '$http', function($scope, $rootScope,uiGridConstants, $http) {
	
	var data = [];

    gridServicio = $scope.gridServicio = {
    	paginationPageSizes: [],
		paginationPageSize: 7,
        columnDefs: [
            { field: 'idServicio',visible:false},
            {field:'horaInicial.millis', visible:false},
            {field: 'horaFinal.millis', visible:false},
            { field: 'servicio', name:"Servicio"},
            { field: 'precio' , name:'Precio'},
            { field: 'horaApertura' , name:'Hora de apertura'},
            { field: 'horaCierre' , name:'Hora de cierre'},
            {name: 'modificar', cellTemplate:
            '<div class="btn-group btn-group-justified" role="group">' +	
            	'<div class="btn-group" role="group" ng-controller="ServicioModalController" >' +
            		'<button  ng-click="modificar(row)" class="btn btn-green" >' +
            			'<span class="fa fa-pencil"></span>' +
            		'</button>'+
            	'</div>' + 
            	'<div class="btn-group" role="group" ng-controller="ServicioModalController" >' +
                	'<button ng-click="eliminar(row)" class="btn btn-warning" >' +
                		'<span class="fa fa-trash"></span>' +
                	'</button>'+
                '</div>'+
            '</div>',width:120
                
            }
        ],
        data: establecimientoCalendario.servicios
    }
}]);

var idTipoServicio;
var idActividadDeportiva;

/**=========================================================
 * Module: modals.js Servicio
 * Implementa el modal de registro y modificacion
 =========================================================*/
var servicioModificar = {};
App.controller('ServicioModalController', ['$scope', '$rootScope','$modal', "$timeout" ,"$http", 'toaster', '$route', '$state', '$stateParams', function ($scope, $rootScope,$modal, $timeout ,$http, toaster, $route, $state, $stateParams) {
	
	$scope.registrar = function () {

        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myServicioModalContent.html',
            controller: RegistrarServicioInstanceCtrl,
            size: 'lg'
        });

    };

    $scope.modificar = function ($row) {
        servicioModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myServicioModalContent.html',
            controller: ModificarServicioInstanceCtrl,
            size: 'lg'
        });
    };
    
    $scope.eliminar = function($row){
		servicioModificar = $row.entity;
		data = {'idServicio': servicioModificar.idServicio,
				"establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo};
	    $http.post('rest/servicio/delete', data).
	    success(function(data){
	    	if(data.code == 200){
	    	var toasterdata = {
		            type:  'success',
		            title: 'Servicio',
		            text:  'Se eliminó el servicio.'
		    };
	    	
	    	establecimientoCalendario = data.establecimientoDeportivo;
	    	gridServicio.data = establecimientoCalendario.servicios;
	    }else{
	    	$rootScope.errorMessage = data.codeMessage;
    		$state.go('page.error');
	    }
	    
	    });
    }
    

//------------------------------------------------------------------------------------
    var RegistrarServicioInstanceCtrl = function ($scope, $modalInstance) {
        
        $scope.accion = "Registrar";
        $scope.servicioForm = {};
        $scope.servicioForm.horaApertura = new Date();
        $scope.servicioForm.horaCierre = new Date();
        $scope.servicioForm.registrar = function () {
         
            var data = {
             "servicio": $scope.servicioForm.servicio,
                "precio": $scope.servicioForm.precio,
                "horaApertura": $scope.servicioForm.horaApertura.getTime(),
                "horaCierre": $scope.servicioForm.horaCierre.getTime(),
                "arbitro": $scope.servicioForm.arbitro,
                "establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo,
                "tipoServicio" : idTipoServicio,
                "actividadDeportiva" : idActividadDeportiva,
                "accion" : $scope.accion
            };
            $http.post('rest/servicio/save', data).
            success(function(data){
             if(data.code == 200){
             var toasterdata = {
               type:  'success',
               title: 'Servicio',
               text:  'Se registro el servicio correctamente.'
       };
       $scope.pop(toasterdata);
             $http.get('rest/establecimientoDeportivo/getAll')
          .success(function(response) {
           if(response.code == 200){
           var establecimientos = response.establecimientosDeportivos;
           for (var i = 0; i < establecimientos.length; i++) {
                        if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                            establecimientoCalendario = establecimientos[i];
                        }
                        gridServicio.data = establcimientoCalendario.servicios;
                    }
           }else{
                  $rootScope.errorMessage = response.codeMessage;
                  $state.go('page.error');
                 }
          });
             $state.reload();
             }else{
              $rootScope.errorMessage = data.codeMessage;
              $state.go('page.error');
             }
            });
            $modalInstance.close('closed');  
         
        };
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

    RegistrarServicioInstanceCtrl.$inject = ["$scope", "$modalInstance", "$http"];
    var ModificarServicioInstanceCtrl = function ($scope, $modalInstance) {
    	
        $scope.accion = "Modificar";
        $scope.servicioForm = {};
        
        $scope.servicioForm.idServicio = servicioModificar.idServicio;
        $scope.servicioForm.servicio = servicioModificar.servicio;
        $scope.servicioForm.precio = servicioModificar.precio;
        $scope.servicioForm.arbitro = servicioModificar.arbitro;
        $scope.idActividadDeportiva = servicioModificar.actividadDeportiva;
        $scope.idTipoServicio = servicioModifciar.tipoServicio;
        
        horaInicial = new Date(servicioModificar.horaInicial.millis);
        horaFinal = new Date(servicioModificar.horaFinal.millis);
        
        $scope.servicioForm.horaApertura = horaInicial;
        $scope.servicioForm.horaCierre = horaFinal;
        
        
        $scope.servicioForm.modificar = function () {
        	var data = {
        			"idServicio": servicioModificar.idServicio,
                	"servicio":$scope.servicioForm.servicio,
                    "precio": $scope.servicioForm.precio,
                    "horaApertura": $scope.servicioForm.horaApertura.getTime(),
                    "horaCierre": $scope.servicioForm.horaCierre.getTime(),
                    "arbitro": $scope.servicioForm.arbitro,
                    "establecimiento" : establecimientoCalendario.idEstablecimientoDeportivo,
                    "tipoServicio" : idTipoServicio,
                    "actividadDeportiva" : idActividadDeportiva,
                    "accion" : $scope.accion
                };
                $http.post('rest/servicio/save', data).
                success(function(response){
                	if(response.code == 200){
                	var toasterdata = {
    			            type:  'success',
    			            title: 'Servicio',
    			            text:  'Se registro los cambios correctamente.'
    			    };
        			$scope.pop(toasterdata);
        			gridServicio.data[data.servicio.idServicio-1] = data.servicio;
        			$state.reload();
                	}else{
                		$rootScope.errorMessage = data.codeMessage;
                		$state.go('page.error');
                	}
                });
                
            $modalInstance.close('closed');
            $scope.pop = function(toasterdata) {
                toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
            };
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarServicioInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);

App.controller('ComboTipoServicioController', ['$scope', '$http', function($scope, $http){
	$http.get('rest/tipoServicio/getAll')
    .success(function(data) {
    	if(data.code == 200){
    		$scope.tipoServicios = data.tipoServicio;
    	}else{
    		$rootScope.errorMessage = data.codeMessage;
    		$state.go('page.error');
    	}
    });
	$scope.changed = function(){
		idTipoServicio = $scope.idTipoServicio;
	}
}]);

App.controller('ComboActividadDeportivaController', ['$scope', '$http', function($scope, $http){
	$http.get('rest/actividadDeportiva/getAll').success(function(data){
		if(data.code == 200){
			$scope.actividadesDeportivas = data.actividadesDeportivas;
		}else{
    		$rootScope.errorMessage = data.codeMessage;
    		$state.go('page.error');
    	}
		
		$scope.changed = function(){
		idActividadDeportiva = $scope.idActividadDeportiva;
		}
	});
}]);
