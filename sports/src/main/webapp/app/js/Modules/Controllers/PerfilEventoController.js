/**
 * Fecha: 23-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 */

App.controller('PerfilEventoController', ['$scope','$http', '$stateParams','$state', function($scope, $http, $stateParams, $state) {

    
    $scope.init = function(){
		$http.post('rest/evento/getEvento', $stateParams.id)
		.success(function(response) {
			
			console.log(response)

            $scope.evento = response.evento;
		});
    };
    
    $scope.init();
    $state.go("app.perfilEvento.informacion");

    $scope.mostrarInformacion = function(){
		$state.go("app.perfilEvento.informacion");
	}
    
	$scope.mostrarPuntosDeRetiro = function(){
		$state.go("app.perfilEvento.puntosRetiro");
	}

    $scope.init();
}]);