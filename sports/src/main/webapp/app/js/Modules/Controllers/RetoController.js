/**=========================================================
 * Module: reto
 =========================================================*/

var gridReto = {};

App.controller('RetoController', ['$scope','$rootScope','uiGridConstants', '$http', function($scope, $rootScope,uiGridConstants, $http) {

	var data = [];
	gridReto = $scope.gridReto = {
			paginationPageSizes: [],
			paginationPageSize: 7,
			columnDefs: [
			{ field: 'idReto', visible:false},
			{ field: 'fechaGrid', name:"Fecha"},
			{ field: 'fecha', visible:false},
			{ field: 'horaGrid' , name:'Hora'},
			{ field: 'hora' , visible:false},
			{ field: 'mensaje' , name:'Mensaje'},
			{ field: 'idUsuario' , visible:false},
			{ field: 'nombreUsuario' , name:'Retador'},
			{ field: 'telefonoUsuario' , name:'Telefono'},
			{ field: 'idServicio', visible:false},
			{ field: 'nombreServicio' , name:'Servicio'},
			{ field: 'idEstablecimiento', visible:false},
			{ field: 'nombreEstablecimiento' , name:'Establecimiento'},
			{name: 'acciones', cellTemplate:
				
			'<div class="btn-group btn-group-justified" role="group" >' +
			
				'<div class="btn-group" role="group" ng-controller="RetoModalController">'+
					'<button ng-click="modificar(row)" class="btn btn-sm btn-green" >' +
						'<span class="fa fa-pencil"></span>' +
						'</button>'+
				'</div>'+
				'<div class="btn-group" role="group" ng-controller="EliminarModalController">'+
					'<button ng-click="eliminar(row)" class="btn btn-sm btn-warning" >' +
						'<span class="fa fa-trash"></span>' +
					'</button>'+
				'</div>'+
			
			'</div>',width:120	
			}
			],
			filterOptions: {filterText: '', useExternalFilter: false},
		    showFilter: true,
		    data: data,
				onRegisterApi: function (gridApi) {
					$scope.gridApi = gridApi;
			    }
			};
			var ARetos  = [];
			$http.get('rest/reto/getAll')
				.success(function(data) {
					if(data.code == 200){
					data.retospojo.forEach( function(reto, index) {
						var retosView = {};
						retosView.idReto = reto.idReto;
						retosView.fechaGrid = reto.fecha.dayOfMonth + '/' + reto.fecha.monthOfYear + '/' + reto.fecha.year;
						retosView.fecha = reto.fecha;
						retosView.horaGrid = getHora(reto.hora.millis);
						retosView.hora = reto.hora;
						retosView.mensaje = reto.mensaje;
						retosView.idUsuario = reto.idUsuario;
						retosView.nombreUsuario = reto.nombreUsuario + reto.apellidoUsuario;
						retosView.telefonoUsuario = reto.telefonoUsuario;
						retosView.idServicio = reto.idServicio;
						retosView.nombreServicio = reto.nombreServicio;
						retosView.idEstablecimiento = reto.idEstablecimiento;
						retosView.nombreEstablecimiento = reto.nombreEstablecimiento;
						retosView.active = reto.active;
						ARetos.push(retosView);
							
			        });
			            $scope.gridReto.data = ARetos;
					}else{
                		$rootScope.errorMessage = data.codeMessage;
                		$state.go('page.error');
                	}
			}).error(function(response){
				$rootScope.errorMessage = response.codeMessage;
        		$state.go('page.error');
           
            });
			
			function getMonth(mes){ 
				if(mes<=10){
					return mes;
				}else{
					return '0' + mes;
				}
			}		
			function getHora(mil){
				var horaMil = new Date(mil);
				var hora;
					if(horaMil.getHours()>= 10){
						hora = horaMil.getHours() + ':';
					}else{
						hora= '0'+horaMil.getHours() + ':';
					}
					if(horaMil.getMinutes() >= 10){
						hora += horaMil.getMinutes();
					}else{
						hora += '0'+ horaMil.getMinutes();
					}
					return hora;
			}
			
			$scope.$on('actualizarGrid', function (event, responsedata) {
				 $scope.gridReto.data = responsedata.newGrid;    
			});
	
}]);
var retoModificar = {};
var retoEliminar = {};
App.controller('RetoModalController', ['$scope', '$rootScope','$modal','$http','$rootScope','toaster',function ($scope, $rootScope,$modal,$http,$rootScope,toaster) {


//----------------------------------------------------------------------------
	
    $scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myRetoModalContent.html',
            controller: RegistrarRetoInstanceCtrl,
            size: 'lg'
        });


    };
    
    $scope.modificar = function ($row) {
    	retoModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myRetoModalContent.html',
            controller: ModificarRetoInstanceCtrl,
            size: 'lg'
        });
    };

    function getMonth(mes){ 
			if(mes<=10){
				return mes;
			}else{
				return '0' + mes;
			}
		}	
		function getHora(mil){
			var horaMil = new Date(mil);
			var hora;
				if(horaMil.getHours()>= 10){
					hora = horaMil.getHours() + ':';
				}else{
					hora= '0'+horaMil.getHours() + ':';
				}
				if(horaMil.getMinutes() >= 10){
					hora += horaMil.getMinutes();
				}else{
					hora += '0'+ horaMil.getMinutes();
				}
				return hora;
		}
		
    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var RegistrarRetoInstanceCtrl = function ($scope, $modalInstance,$http,$rootScope) {
    	


    	'use strict'; 
    	//validación
    	$scope.reto = {};
    	$scope.reto.hora = new Date();
    	$scope.reto.fecha = new Date();
    	
    	
    	$scope.accion = 'Registrar';
        $scope.submitted = false;
                
        $scope.validateInput = function(name, type) {
            var input = $scope.formReto[name];
            return (input.$dirty || $scope.submitted) && input.$error[type];
        };
        
        // Submit form
        $scope.submitForm = function() {
            $scope.submitted = true;  
            if ($scope.formReto.$valid) {
            	$http.post('rest/reto/save', {
            		estado:'En espera',
            		fecha: $scope.reto.fecha,
            		hora: $scope.reto.hora.getTime(),
            		mensaje: $scope.reto.mensaje,
            		active: 1,
            		servicio: $rootScope.Servicio,
            		usuario: $rootScope.usuario.idUsuario
        		 	})
        		.success(function(data){
        			var ARetos = [];
   					data.retospojo.forEach( function(reto, index) {
   						var retosView = {};
   						retosView.idReto = reto.idReto;
   						retosView.fechaGrid = reto.fecha.dayOfMonth + '/' + reto.fecha.monthOfYear + '/' + reto.fecha.year;
   						retosView.fecha = reto.fecha;
   						retosView.horaGrid = getHora(reto.hora.millis);
   						retosView.hora = reto.hora;
   						retosView.mensaje = reto.mensaje;
   						retosView.idUsuario = reto.idUsuario;
   						retosView.nombreUsuario = reto.nombreUsuario + reto.apellidoUsuario;
   						retosView.telefonoUsuario = reto.telefonoUsuario;
   						retosView.idServicio = reto.idServicio;
   						retosView.nombreServicio = reto.nombreServicio;
   						retosView.idEstablecimiento = reto.idEstablecimiento;
   						retosView.nombreEstablecimiento = reto.nombreEstablecimiento;
   						retosView.active = reto.active;
   						if(retosView.active == 0){	
   						}else{
   							ARetos.push(retosView);
   						}	
   			     });                 
   				 var responsedata = {
   				              type:  'success',
   				              title: 'Reto',
   				              text:  data.codeMessage,
   				              newGrid: ARetos
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
    
    RegistrarRetoInstanceCtrl.$inject = ["$scope", "$modalInstance","$http","$rootScope"];
    
    var ModificarRetoInstanceCtrl = function ($scope, $modalInstance,$http,$rootScope) {
        $scope.accion = "Modificar";
        $scope.reto = {};
        $scope.formReto = {};
        
        
        $scope.reto.mensaje = retoModificar.mensaje;
        horaModal = new Date(retoModificar.hora.millis);
        fechaModal = new Date(retoModificar.fecha.millis);
        $scope.reto.fecha = fechaModal;
        $scope.reto.hora = horaModal;
        $scope.reto.servicio = retoModificar.nombreServicio;
        $scope.idEstablecimientoDeportivo = retoModificar.idEstablecimiento;
        $scope.idServicio = retoModificar.idServicio;

        $scope.submitForm = function () {
                $http.post('rest/reto/update',{
                	idReto: retoModificar.idReto,
        			estado:"En espera",
                	mensaje: $scope.reto.mensaje,
                	fecha: $scope.reto.fecha,
                	hora:$scope.reto.hora.getTime(),
                    active: 1,
                    servicio : $rootScope.Servicio,
                    usuario : retoModificar.idUsuario
                })
                .success(function(data){
                	if(data.code == 200){
                	var ARetos = [];
                	data.retospojo.forEach( function(reto, index) {
   						var retosView = {};
   						retosView.idReto = reto.idReto;
   						retosView.fechaGrid = reto.fecha.dayOfMonth + '/' + reto.fecha.monthOfYear + '/' + reto.fecha.year;
   						retosView.fecha = reto.fecha;
   						retosView.horaGrid = getHora(reto.hora.millis);
   						retosView.hora = reto.hora;
   						retosView.mensaje = reto.mensaje;
   						retosView.idUsuario = reto.idUsuario;
   						retosView.nombreUsuario = reto.nombreUsuario + reto.apellidoUsuario;
   						retosView.telefonoUsuario = reto.telefonoUsuario;
   						retosView.idServicio = reto.idServicio;
   						retosView.nombreServicio = reto.nombreServicio;
   						retosView.idEstablecimiento = reto.idEstablecimiento;
   						retosView.nombreEstablecimiento = reto.nombreEstablecimiento;
   						retosView.active = reto.active;
   						if(retosView.active == 0){	
   						}else{
   							ARetos.push(retosView);
   						}	
   			     });                 
   				 var responsedata = {
   				              type:  'success',
   				              title: 'Reto',
   				              text:  data.codeMessage,
   				              newGrid: ARetos
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
    ModificarRetoInstanceCtrl.$inject = ["$scope", "$modalInstance","$http","$rootScope"];
    
    
    
    App.controller('Cargar', ['$scope', '$rootScope','$modal', '$rootScope','$http', 'toaster', function ($scope, $rootScope,$modal, $rootScope, $http, toaster) {    
    	 
    	$scope.init = function(){  	
		    $http.get('rest/establecimientoDeportivo/getAll')
			.success(function(response) {
				if(response.code = 200)
				{
					$scope.Establecimientos = response.establecimientosDeportivos;
				}else{
					$rootScope.errorMessage = response.codeMessage;
            		$state.go('page.error');
				}
			});
	    };
	    //Inicializa la aplicación
	    $scope.init();  
	    
	    $scope.buscarServicios = function(idEstablecimiento){
	    	angular.forEach($scope.Establecimientos, function(establecimiento, index){
	    		if(establecimiento.idEstablecimientoDeportivo == idEstablecimiento){
	    			$scope.Servicios = establecimiento.servicios;
	    		}
	    	});
	    };
    	 
	    $scope.buscarServicio = function(){
	    	$rootScope.Servicio = $scope.idServicio;
    	};
 
    }]);
  
  
}]);
var retoEliminar = {};
App.controller('EliminarModalController', ['$scope', '$rootScope','$modal', '$rootScope','$http', 'toaster', function ($scope, $rootScope,$modal, $rootScope, $http, toaster) {

	$scope.eliminar = function ($row) {
		retoEliminar = $row.entity;
	var modalInstance = $modal.open({
		templateUrl: '/modalEliminarReto.html',
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
  			horaRow = new Date(retoEliminar.hora.millis);
  			fechaRow = new Date(retoEliminar.fecha.millis);
  			$http.post('rest/reto/delete', {
  				idReto : retoEliminar.idReto,
  				estado : "En espera",
  				mensaje : retoEliminar.mensaje,
  				fecha : fechaRow,
  				hora : horaRow.getTime(),
  				active : 0,
  				servicio : retoEliminar.idServicio,
  				usuario : retoEliminar.idUsuario
  				
  				}).success(function(data) {
  					if(data.code == 200){
  					   var ARetos = [];
  						data.retospojo.forEach( function(reto, index) {
  							var retosView = {};
  							retosView.idReto = reto.idReto;
  							retosView.fechaGrid = reto.fecha.dayOfMonth + '/' + reto.fecha.monthOfYear + '/' + reto.fecha.year;
  							retosView.fecha = reto.fecha;
  							retosView.horaGrid = getHora(reto.hora.millis);
  							retosView.hora = reto.hora;
  							retosView.mensaje = reto.mensaje;
  							retosView.idUsuario = reto.idUsuario;
  							retosView.nombreUsuario = reto.nombreUsuario + reto.apellidoUsuario;
  							retosView.telefonoUsuario = reto.telefonoUsuario;
  							retosView.idServicio = reto.idServicio;
  							retosView.nombreServicio = reto.nombreServicio;
  							retosView.idEstablecimiento = reto.idEstablecimiento;
  							retosView.nombreEstablecimiento = reto.nombreEstablecimiento;
  							retosView.active = reto.active;
  							if(retosView.active == 0){	
  	   						}else{
  	   							ARetos.push(retosView);
  	   						}
  				     });
  					 var responsedata = {
  					              type:  'success',
  					              title: 'Reto',
  					              text:  data.codeMessage,
  					              newGrid: ARetos
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
  				function getMonth(mes){ 
  					if(mes<=10){
  						return mes;
  					}else{
  						return '0' + mes;
  					}
  				}	
  				function getHora(mil){
  					var horaMil = new Date(mil);
  					var hora;
  						if(horaMil.getHours()>= 10){
  							hora = horaMil.getHours() + ':';
  						}else{
  							hora= '0'+horaMil.getHours() + ':';
  						}
  						if(horaMil.getMinutes() >= 10){
  							hora += horaMil.getMinutes();
  						}else{
  							hora += '0'+ horaMil.getMinutes();
  						}
  						return hora;
  				}
	};
	  
	  ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);