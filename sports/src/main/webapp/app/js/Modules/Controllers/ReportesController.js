/**
 * Modulo Controlador para generar reportes 
 * author: Mauricio Fernandez
 * Fecha: 16/08/2015
 * Revision: 1.0
 */
var gridReportes = {};
App.controller('ReportesController', ['$scope', '$http', '$stateParams', 'uiGridConstants', function($scope, $http, $stateParams, uiGridConstants) {
	
	var nombreEvento;
	nombreEvento = $stateParams.nombre;

	var data = [];
	gridReportes = $scope.gridReportes = {
			paginationPageSizes: [],
		paginationPageSize: 7,
		columnDefs: [
		{ field: 'idTiquete', visible:false},
		{ field: 'codigo', name:"Código"},
		{ field: 'estado', name:"Estado"},
		{ field: 'fechaCaducidad' , name:'Fecha de caducidad'},
		{ field: 'nombre' , name: "Nombre"},
		{ field: 'precio' , name:'Precio'}
		],
		filterOptions: {filterText: '', useExternalFilter: false},
	    showFilter: true,
	    data: data,
			onRegisterApi: function (gridApi) {
				$scope.gridApi = gridApi;
		    }
		};
	
		var aTiquetes = [];
	    $http.post('rest/tiquete/getByNombreEvento', nombreEvento)
		.success(function(data) {			
			data.tiquetes.forEach( function(tiquete, index) {
				var tiqueteView = {};
				tiqueteView.idTiquete = tiquete.idTiquete;
				tiqueteView.codigo = tiquete.codigo;
				tiqueteView.estado = tiquete.estado;
				tiqueteView.fechaCaducidad = tiquete.fechaCaducidad;
				tiqueteView.nombre = tiquete.nombreEvento;
				tiqueteView.precio = tiquete.precio;
				if(tiqueteView.active == 0){	
				}else{
					aTiquetes.push(tiqueteView);
				}
				
	        });
	            $scope.gridReportes.data = aTiquetes;
	}).error(function(response){
   
    });
	
}]);



var gridReporteRetos = {};
App.controller('ReporteRetosController', ['$scope', '$http', '$stateParams', 'uiGridConstants', function($scope, $http, $stateParams,uiGridConstants) {
	
	var establecimiento;
	
	var data = [];
	gridReporteRetos = $scope.gridReporteRetos = {
			paginationPageSizes: [],
		paginationPageSize: 7,
		columnDefs: [
		{ field: 'idReto', visible:false},
		{ field: 'nombreUsuario', name:"Nombre"},
		{ field: 'apellidoUsuario', name:"Apellido"},
		{ field: 'telefonoUsuario' , name: "Teléfono"},
		{ field: 'mensaje', name: "Mensaje"},
		{ field: 'nombreServicio' , name:'Servicio'},
		{ field: 'precioServicio' , name:'precioServicio'}
		],
	    data: data,
			onRegisterApi: function (gridApi) {
				$scope.gridApi = gridApi;
		    }
		};
		
	$http.get('rest/establecimientoDeportivo/getAll')
	.success(function(response) {
		var establecimientos = response.establecimientosDeportivos;
		for (var i = 0; i < establecimientos.length; i++) {
            if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.id){
                $scope.establecimiento = establecimientos[i];
    			establecimiento = establecimientos[i];
            }
        }
		
			var aRetos = [];
		    $http.get('rest/reto/getAll')
			.success(function(data) {
				data.retospojo.forEach( function(reto, index) {
					
					for(i = 0; i < establecimiento.servicios.length; i++){
						if(establecimiento.servicios[i].idServicio == reto.idServicio){
							var retoView = {};
							retoView.idReto = reto.idReto;
							retoView.nombreUsuario = reto.nombreUsuario;
							retoView.apellidoUsuario = reto.apellidoUsuario;
							retoView.telefonoUsuario = reto.telefonoUsuario;
							retoView.mensaje = reto.mensaje;
							retoView.nombreServicio = reto.nombreServicio;
							retoView.precioServicio = reto.precioServicio;
							if(retoView.active == 0){	
							}else{
								aRetos.push(retoView);
							}
						}
					}
					
		        });
				
	            $scope.gridReporteRetos.data = aRetos;
		            
			}).error(function(response){
		   
		    });
		
	});
	
}]);