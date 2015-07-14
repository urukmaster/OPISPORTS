/**
 * Created by JuanManuel on 09/07/2015.
 */
var gridEstablecimientos = {};

App.controller('EstablecimientosController', ['$scope','$http', '$stateParams','uiGridConstants', function($scope,$http, $stateParams,uiGridConstants) {
    // no filter for inbox
	
    $scope.init = function(){  	
	    $http.get('rest/establecimientoDeportivo/getAll')
		.success(function(response) {
			$scope.Establecimientos = response.establecimientoDeportivo;
		});
    };
    $scope.init();
       
App.controller('InformacionPerfilController', [ '$scope', '$http',
		'$stateParams', '$state',
		function($scope, $http, $stateParams, $state) {
			var path = 'server/establecimientos.json';
			$scope.init = function() {
				$scope.mostrarCalendario = false;
				console.log("entrarndo")
				$http.get(path).then(function(resp) {
					console.log("ressssp", resp)
					var establecimientos = resp.data;
					for (var i = 0; i < establecimientos.length; i++) {
						if (establecimientos[i].id == $stateParams.mid) {
							$scope.establecimiento = establecimientos[i];
						}
					}
				});
			}

			$scope.init();


		} ]);

    $scope.init();
    $state.go("app.perfil.informacion");
    
    
    $scope.mostrarReservaciones = function() {
			$scope.mostrarCalendario = true;
	}
			
	$scope.mostrarInformacion = function(){
		$scope.mostrarCalendario = false;
		$state.go("app.perfil.informacion");
	}
			
	$scope.mostrarServicios = function(){
		$scope.mostrarCalendario = false;
		$state.go("app.perfil.servicios");
	}

}]);
