/**
 * Modulo Controlador para generar reportes 
 * author: Mauricio Fernandez
 * Fecha: 16/08/2015
 * Revision: 1.0
 */
var gridReportes = {};
App.controller('ReportesController', ['$scope', '$http', '$stateParams', function($scope, $http, $stateParams) {
	
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
				console.log(data);
				
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
            alert(response.message);
       
        });
	
}]);