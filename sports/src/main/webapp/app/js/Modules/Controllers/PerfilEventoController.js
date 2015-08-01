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

            $scope.evento = response.evento;
		});
		

		$http.get('rest/tiquete/getAll')
		.success(function(response) {
			var tiquetes = response.tiquetes;
			console.log(tiquetes);
			for (var i = 0; i < tiquetes.length; i++) {
				
                if (tiquetes[i].idEvento == $stateParams.id){
                    $scope.tiquete = tiquetes[i];
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