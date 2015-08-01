/**=========================================================
 * Module: reto
 =========================================================*/

var gridReto = {};

App.controller('RetoController', ['$scope','uiGridConstants', '$http', function($scope, uiGridConstants, $http) {
			
	var data = [];
	gridReto = $scope.gridReto = {
			columnDefs: [
			{ field: 'idReto', visible:false,width : 135},
			{ field: 'fecha', name:"Fecha", width : 135},
			{ field: 'hora' , name:'Hora', width : 135},
			{ field: 'mensaje' , name:'Mensaje', width : 135},
			{ field: 'nombreUsuario' , name:'Retador', width : 135},
			{ field: 'telefonoUsuario' , name:'Telefono', width : 135},
			{ field: 'nombreServicio' , name:'Servicio', width : 135},
			{ field: 'nombreEstablecimiento' , name:'Establecimiento', width : 135},
			{name: 'acciones', cellTemplate:'<div ng-controller="ServicioModalController" >' +
			'<button ng-click="modificar(row)" class="btn btn-primary" >' +
			'<span class="fa fa-rocket"></span>' +
			'</button>'+
			'</div>', width : 100}
			],data: data,
				onRegisterApi: function (gridApi) {
					$scope.gridApi = gridApi;
			    }
			};
			$http.get('rest/reto/getAll')
				.success(function(data) {
					data.retospojo.forEach( function(row) {
						row.registered = Date.parse(row.registered);
			        });
			            $scope.gridReto.data = data.retospojo;
			});
}]);



