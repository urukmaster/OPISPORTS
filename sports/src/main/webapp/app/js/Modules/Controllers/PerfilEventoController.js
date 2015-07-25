/**
 * Fecha: 23-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 */

App.controller('PerfilEventoController', ['$scope','$http', '$stateParams','$state', function($scope, $http, $stateParams, $state) {

    
    $scope.init = function(){
		$http.get('rest/evento/getAll')
		.success(function(response) {
			var eventos = response.eventos;
			for (var i = 0; i < eventos.length; i++) {
                if (eventos[i].idEvento == $stateParams.id){
                    $scope.evento = eventos[i];
                }
                
            }
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